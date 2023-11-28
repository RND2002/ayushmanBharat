package com.codesite.ayushmanProject.controller;

import com.codesite.ayushmanProject.entitiy.PatientMedicalRecord;
import com.codesite.ayushmanProject.service.PatientMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@PreAuthorize("hasRole('ROLE_PATIENT')")
@RequestMapping("patient")

public class PatientController {

    @Autowired
    private PatientMedicalRecordService patientMedicalRecordService;

    @GetMapping("getMedicalRecord/{patientId}")
    public ResponseEntity<List<PatientMedicalRecord>> getPatientMedicalRecord(@PathVariable long patientId){
        return patientMedicalRecordService.getListOfPatientMedicalRecordForPatient(patientId);
    }
}
