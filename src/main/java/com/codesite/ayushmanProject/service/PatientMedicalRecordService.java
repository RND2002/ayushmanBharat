package com.codesite.ayushmanProject.service;

import com.codesite.ayushmanProject.entitiy.DoctorEntity;
import com.codesite.ayushmanProject.entitiy.PatientEntity;
import com.codesite.ayushmanProject.entitiy.PatientMedicalRecord;
import com.codesite.ayushmanProject.repository.DoctorRepository;
import com.codesite.ayushmanProject.repository.PatientMedicalRecordRepository;
import com.codesite.ayushmanProject.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PatientMedicalRecordService {

    @Autowired
    private PatientMedicalRecordRepository patientMedicalRecordRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    public ResponseEntity<String> addPatientMedicalRecordToRepository(Long doctorId,PatientMedicalRecord patientMedicalRecord){
            try{

                DoctorEntity doctorEntity=doctorRepository.findById(doctorId).orElseThrow();
                PatientEntity patientEntity=patientRepository.findByAdharNumber(patientMedicalRecord.getAdharNumber());
                patientMedicalRecord.setPatientEntity(patientEntity);
                patientMedicalRecord.setDoctorEntity(doctorEntity);
                patientMedicalRecordRepository.save(patientMedicalRecord);
                return new ResponseEntity<>("Medical Record added successfully", HttpStatus.OK);
            }catch(Exception e){
                return new ResponseEntity<>("Error saving patient data",HttpStatus.BAD_REQUEST);
            }
    }

    public ResponseEntity<List<PatientMedicalRecord>> getListOfPatientMedicalRecordForDoctor(Long doctorId){
        List<PatientMedicalRecord> medicalRecords=
                patientMedicalRecordRepository.findAllByDoctorId(doctorId);
        if(medicalRecords.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicalRecords,HttpStatus.OK);
    }

    public ResponseEntity<List<PatientMedicalRecord>> getListOfPatientMedicalRecordForPatient(Long patientId){
        List<PatientMedicalRecord> medicalRecords=
                patientMedicalRecordRepository.findAllByPateintId(patientId);
        if(medicalRecords.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicalRecords,HttpStatus.OK);
    }
}
