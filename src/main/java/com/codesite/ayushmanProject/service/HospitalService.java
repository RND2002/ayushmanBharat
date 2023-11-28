package com.codesite.ayushmanProject.service;

import com.codesite.ayushmanProject.entitiy.HospitalEntity;
import com.codesite.ayushmanProject.entitiy.LoginEntity;
import com.codesite.ayushmanProject.repository.HospitalRepository;
import com.codesite.ayushmanProject.repository.LoginRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private LoginRepository loginRepository;

    private final IdGenerationService idGenerationService;

    @Autowired
    public HospitalService(IdGenerationService idGenerationService) {
        this.idGenerationService = idGenerationService;
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public ResponseEntity<String> addHospitalToRepository(HospitalEntity hospitalEntity){
       try{
           hospitalEntity.setHospitalId(idGenerationService.generateUniqueId());
           hospitalEntity.setPassword(passwordEncoder().encode(hospitalEntity.getPassword()));
           LoginEntity loginEntity=new LoginEntity();

           loginEntity.setEmailAddress(hospitalEntity.getEmailAddress());
           loginEntity.setPassword(hospitalEntity.getPassword());
           loginEntity.setRoles(Collections.singleton(hospitalEntity.getRole()));

           hospitalRepository.save(hospitalEntity);
           loginEntity.setId(hospitalEntity.getHospitalId());
           loginRepository.save(loginEntity);
           return new ResponseEntity<>("Hospital Added To Repository", HttpStatus.OK);
       }catch(Exception e){
           e.printStackTrace();
           return new ResponseEntity<>("Error saving doctor try again",HttpStatus.BAD_REQUEST);
       }
    }

    public ResponseEntity<List<HospitalEntity>> getListOfAllHospital() {
       List<HospitalEntity> hospitalEntities= hospitalRepository.findAll();
       return new ResponseEntity<>(hospitalEntities,HttpStatus.OK);
    }
}
