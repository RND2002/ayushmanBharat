package com.codesite.ayushmanProject.service;

import com.codesite.ayushmanProject.entitiy.LoginEntity;
import com.codesite.ayushmanProject.entitiy.PatientEntity;
import com.codesite.ayushmanProject.repository.LoginRepository;
import com.codesite.ayushmanProject.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PatientService {


    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private LoginRepository loginRepository;


   private final IdGenerationService idGenerationService;

    @Autowired
    public PatientService(IdGenerationService idGenerationService) {
        this.idGenerationService = idGenerationService;
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
   @Transactional
    public ResponseEntity<String> addPatientToRepository(PatientEntity patientEntity){
       try{
           patientEntity.setPatientId(idGenerationService.generateUniqueId());
           patientEntity.setPassword(passwordEncoder().encode(patientEntity.getPassword()));
           LoginEntity loginEntity=new LoginEntity();

           loginEntity.setEmailAddress(patientEntity.getEmailAddress());
           loginEntity.setPassword(patientEntity.getPassword());
           loginEntity.setRoles(Collections.singleton(patientEntity.getRole()));
           patientRepository.save(patientEntity);
           loginEntity.setId(patientEntity.getPatientId());
           loginRepository.save(loginEntity);
           return new ResponseEntity<>("Patient Added SuccessFully", HttpStatus.OK);
       }catch(Exception e){
//           patientRepository.save(null);
//           loginRepository.save(null);
           e.printStackTrace();
           return new ResponseEntity<>("Error saving Patient",HttpStatus.BAD_REQUEST);
       }
    }


}
