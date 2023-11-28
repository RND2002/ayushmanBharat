package com.codesite.ayushmanProject.repository;

import com.codesite.ayushmanProject.entitiy.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {
}
