package com.codesite.ayushmanProject.service;

import com.codesite.ayushmanProject.entitiy.LoginEntity;
import com.codesite.ayushmanProject.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;
    public LoginEntity findByEmailAddress(String emailAddress) {
        return loginRepository.findByEmailAddress(emailAddress);
    }
}
