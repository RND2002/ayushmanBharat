package com.codesite.ayushmanProject.repository;

import com.codesite.ayushmanProject.entitiy.PatientMedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientMedicalRecordRepository extends JpaRepository<PatientMedicalRecord,Long> {
    @Query("SELECT record FROM PatientMedicalRecord record WHERE record.doctorEntity.doctorId = :doctorId")
    List<PatientMedicalRecord> findAllByPateintId(Long doctorId);
    @Query("SELECT record FROM PatientMedicalRecord record WHERE record.doctorEntity.doctorId = :doctorId")
    List<PatientMedicalRecord> findAllByDoctorId(Long doctorId);
}
