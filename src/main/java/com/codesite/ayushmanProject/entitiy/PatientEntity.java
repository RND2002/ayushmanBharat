package com.codesite.ayushmanProject.entitiy;

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
public class PatientEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;

    private String fullName;
    @Column(unique = true)
    private String adharNumber;

    private String password;

    private String emailAddress;

    private String fullAddress;

    private String phoneNumber;

    private String role;

    private String city;

    private String zipCode;
}
