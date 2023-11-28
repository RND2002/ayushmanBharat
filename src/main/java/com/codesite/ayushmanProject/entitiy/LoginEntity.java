package com.codesite.ayushmanProject.entitiy;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long LoginEntityId;
    @Column(unique = true)
    private Long id;
    @Column(unique = true)
    private String emailAddress;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;
}