package com.codesite.ayushmanProject.security;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class JwtRequest {
    private String emailAddress;
    private String password;



    // Constructors, getters, and setters

    public JwtRequest(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmail(String email) {
        this.emailAddress = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

