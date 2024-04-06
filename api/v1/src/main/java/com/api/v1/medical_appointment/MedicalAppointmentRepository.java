package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;

public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, UUID>{
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.patient = :patient
			and ma.scheduledDateTime = :dateTime
	""")
	MedicalAppointment findMedicalAppointmentByPatientAndDate(@Param("patient") Patient patient, 
											                  @Param("dateTime") LocalDateTime dateTime);
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.physician = :physician
			and ma.scheduledDateTime = :dateTime
	""")
	MedicalAppointment findMedicalAppointmentByPhysicianAndDate(@Param("physician") Physician physician, 
											                    @Param("dateTime") LocalDateTime dateTime);
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.physician = :physician
			and ma.patient = :patient
			and ma.scheduledDateTime = :dateTime
	""")
	MedicalAppointment findMedicalAppointmentByPatientAndPhysicianAndDate(@Param("patient") Patient patient, 
																		  @Param("physician") Physician physician, 
																		  @Param("dateTime") LocalDateTime dateTime);
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.scheduledDateTime >= :firtstDateTime
			and ma.scheduledDateTime <= :lastDateTime
	""")
	MedicalAppointment findMedicalAppointmentsBeetwenDates(@Param("firtstDateTime") LocalDateTime firtstDateTime, 
														   @Param("lastDateTime") LocalDateTime lastDateTime);
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.cancelationDateTime is null
	""")
	List<MedicalAppointment> findScheduledMedicalAppointments();
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.cancelationDateTime is not null
	""")
	List<MedicalAppointment> findCanceledMedicalAppointments();

	@Modifying
	@Transactional
	@Query(value = "DROP TABLE IF EXISTS v1_medical_appointment", nativeQuery = true)
	void dropTable();

}
