package com.codesite.ayushmanProject.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hospitalId;

    private String hospitalName;

    private String registrationNumber;

    private String emailAddress;

    private String password;

    private String specialization;

    private String fullAddress;

    private String city;

    private String role;

    private String zipCode;

    @OneToMany(mappedBy = "hospitalEntity")
    private List<DoctorEntity> doctorEntitiyList;
}
