package com.codesite.ayushmanProject.service;

import com.codesite.ayushmanProject.entitiy.DoctorEntity;
import com.codesite.ayushmanProject.entitiy.HospitalEntity;
import com.codesite.ayushmanProject.entitiy.LoginEntity;
import com.codesite.ayushmanProject.entitiy.PatientMedicalRecord;
import com.codesite.ayushmanProject.repository.DoctorRepository;
import com.codesite.ayushmanProject.repository.HospitalRepository;
import com.codesite.ayushmanProject.repository.LoginRepository;
import com.codesite.ayushmanProject.repository.PatientMedicalRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private PatientMedicalRecordRepository patientMedicalRecordRepository;

    @Autowired
    private LoginRepository loginRepository;


    private final IdGenerationService idGenerationService;

    @Autowired
    public DoctorService(IdGenerationService idGenerationService) {
        this.idGenerationService = idGenerationService;
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public ResponseEntity<String> addDoctorToRepository(DoctorEntity doctorEntity){

        try{
            doctorEntity.setDoctorId(idGenerationService.generateUniqueId());
            doctorEntity.setPassword(passwordEncoder().encode(doctorEntity.getPassword()));
            LoginEntity loginEntity=new LoginEntity();
            loginEntity.setId(doctorEntity.getDoctorId());
            loginEntity.setEmailAddress(doctorEntity.getEmailAddress());
            loginEntity.setPassword(doctorEntity.getPassword());
            loginEntity.setRoles(Collections.singleton(doctorEntity.getRole()));
            long hospitalId=doctorEntity.getHospitalEntityId();
            HospitalEntity hospitalEntity=hospitalRepository.findById(hospitalId).orElseThrow();
            doctorEntity.setHospitalEntity(hospitalEntity);
            doctorRepository.save(doctorEntity);
            loginEntity.setId(doctorEntity.getDoctorId());
            loginRepository.save(loginEntity);
            return new ResponseEntity<>("Doctor Added Successfully", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("error saving doctor try again",HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> setVisibleFalseForDoctor(PatientMedicalRecord patientMedicalRecord){
        patientMedicalRecord.setSetVisible(false);
        return new ResponseEntity<>("Data is hidden for doctor",HttpStatus.OK);
    }

    public DoctorEntity findDoctorByDoctorId(Long doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow();
    }
}
