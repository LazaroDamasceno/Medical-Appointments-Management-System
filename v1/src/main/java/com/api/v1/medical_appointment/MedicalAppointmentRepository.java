package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
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
			and ma.cancelationDateTime is null
			and ma.finishingDateTime is null
	""")
	Optional<MedicalAppointment> findScheduledMedicalAppointmentByPatient(@Param("patient") Patient patient, @Param("dateTime") LocalDateTime dateTime);
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.physician = :physician
			and ma.scheduledDateTime = :dateTime
			and ma.cancelationDateTime is null
			and ma.finishingDateTime is null
	""")
	Optional<MedicalAppointment> findScheduledMedicalAppointmentByPhysician(@Param("physician") Physician physician, @Param("dateTime") LocalDateTime dateTime);
	
	@Query("""
			select ma from MedicalAppointment ma
			where ma.physician = :physician
			and ma.patient = :patient
			and ma.scheduledDateTime = :dateTime
			and ma.cancelationDateTime is null
			and ma.finishingDateTime is null
	""")
	Optional<MedicalAppointment> findScheduledMedicalAppointmentByDate(@Param("patient") Patient patient, @Param("physician") Physician physician, @Param("dateTime") LocalDateTime dateTime);

}
