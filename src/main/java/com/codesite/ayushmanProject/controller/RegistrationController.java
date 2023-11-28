package com.codesite.ayushmanProject.controller;

import com.codesite.ayushmanProject.entitiy.DoctorEntity;
import com.codesite.ayushmanProject.entitiy.HospitalEntity;
import com.codesite.ayushmanProject.entitiy.PatientEntity;
import com.codesite.ayushmanProject.service.DoctorService;
import com.codesite.ayushmanProject.service.HospitalService;
import com.codesite.ayushmanProject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @PostMapping("addHospital")
    public ResponseEntity<String> saveHospitalToRepository(@RequestBody HospitalEntity hospitalEntity){
        return hospitalService.addHospitalToRepository(hospitalEntity);
    }

    @PostMapping("addDoctor")
    public ResponseEntity<String> addDoctorToRepository(@RequestBody DoctorEntity doctorEntity){
        return doctorService.addDoctorToRepository(doctorEntity);
    }

    @PostMapping("addPatient")
    public ResponseEntity<String> addPatientToRepository(@RequestBody PatientEntity patientEntity){
        return patientService.addPatientToRepository(patientEntity);
    }

    @GetMapping("getAllHospital")
    public ResponseEntity<List<HospitalEntity>>  getAllHospital(){
        return hospitalService.getListOfAllHospital();
    }
}
