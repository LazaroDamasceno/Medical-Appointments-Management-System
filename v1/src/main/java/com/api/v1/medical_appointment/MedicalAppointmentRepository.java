package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;

public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, UUID>{
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.patient = :patient
			and ma.scheduledDateTime = :dateTime
			and ma.finishingDateTime is null
	""")
	Optional<MedicalAppointment> findScheduledMedicalAppointmentByPatient(@Param("patient") Patient patient, @Param("dateTime") LocalDateTime dateTime);
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.physician = :physician
			and ma.scheduledDateTime = :dateTime
	""")
	Optional<MedicalAppointment> findScheduledMedicalAppointmentByPhysician(@Param("physician") Physician physician, @Param("dateTime") LocalDateTime dateTime);
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.physician = :physician
			and ma.patient = :patient
			and ma.scheduledDateTime = :dateTime
	""")
	Optional<MedicalAppointment> findScheduledMedicalAppointmentByDate(@Param("patient") Patient patient, @Param("physician") Physician physician, @Param("dateTime") LocalDateTime dateTime);
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.scheduledDateTime >= :firtstDateTime
			and ma.scheduledDateTime <= :lastDateTime
	""")
	Optional<MedicalAppointment> findScheduledMedicalAppointmentsBeetwenDates(@Param("firtstDateTime") LocalDateTime firtstDateTime, @Param("lastDateTime") LocalDateTime lastDateTime);
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.cancelationDateTime is null
			and ma.finishingDateTime is null
	""")
	List<MedicalAppointment> findScheduledMedicalAppointments();
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.cancelationDateTime is not null
	""")
	List<MedicalAppointment> findCanceledMedicalAppointments();

	@Query("""
		select ma from MedicalAppointment ma
		where ma.finishingDateTime is not null
	""")
	List<MedicalAppointment> findFinishedMedicalAppointments();

}
