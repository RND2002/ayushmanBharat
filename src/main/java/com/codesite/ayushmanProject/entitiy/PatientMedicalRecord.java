package com.codesite.ayushmanProject.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientMedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String doctorEmail;

    private String patientName;

    private String adharNumber;
    private String time;
    private String patientProblem;

    private String hospitalName;

    private String doctorName;

    private String descriptionData;

    private boolean setVisible;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnore
    private DoctorEntity doctorEntity;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private PatientEntity patientEntity;
}
