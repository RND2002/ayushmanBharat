package com.codesite.ayushmanProject.repository;

import com.codesite.ayushmanProject.entitiy.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,Long> {
    PatientEntity findByAdharNumber(String adharNumber);
}
