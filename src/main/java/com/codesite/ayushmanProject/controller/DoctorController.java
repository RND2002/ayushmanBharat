package com.codesite.ayushmanProject.controller;

import com.codesite.ayushmanProject.entitiy.DoctorEntity;
import com.codesite.ayushmanProject.entitiy.PatientMedicalRecord;
import com.codesite.ayushmanProject.service.DoctorService;
import com.codesite.ayushmanProject.service.PatientMedicalRecordService;
import com.codesite.ayushmanProject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
@PreAuthorize("hasRole('ROLE_DOCTOR')")
public class DoctorController {

    @Autowired
    private PatientMedicalRecordService patientMedicalRecordService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @PostMapping("addPatientMedical/{doctorId}")
    public ResponseEntity<String> addPatientMedicalRecordToRepository
            (@PathVariable Long doctorId, @RequestBody PatientMedicalRecord patientMedicalRecord)
    {
        return patientMedicalRecordService.addPatientMedicalRecordToRepository(doctorId,patientMedicalRecord);

    }

    @GetMapping("getMedicalRecord/{doctorId}")
    public ResponseEntity<List<PatientMedicalRecord>> getListOFPatientMedicalRecord(@PathVariable Long doctorId){
        return patientMedicalRecordService.getListOfPatientMedicalRecordForDoctor(doctorId);
    }



}
