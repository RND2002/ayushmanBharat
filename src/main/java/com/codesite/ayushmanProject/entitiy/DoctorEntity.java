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
public class DoctorEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doctorId;

    private String fullName;
    @Column(unique = true)
    private String registrationName;

    private String specialization;

    private String emailAddress;

    private String password;

    private String role;

    private String fullAddress;

    private String city;

    private String zipCode;

    private long hospitalEntityId;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospitalEntity;
}
