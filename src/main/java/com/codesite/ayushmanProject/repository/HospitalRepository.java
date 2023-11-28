package com.codesite.ayushmanProject.repository;

import com.codesite.ayushmanProject.entitiy.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity,Long> {
}
