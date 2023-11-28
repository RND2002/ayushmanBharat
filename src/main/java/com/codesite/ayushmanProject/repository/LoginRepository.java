package com.codesite.ayushmanProject.repository;

import com.codesite.ayushmanProject.entitiy.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,Long> {
    LoginEntity findByEmailAddress(String subject);
}
