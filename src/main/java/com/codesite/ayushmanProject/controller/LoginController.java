package com.codesite.ayushmanProject.controller;

import com.codesite.ayushmanProject.entitiy.LoginEntity;
import com.codesite.ayushmanProject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("loggedInUser/{emailAddress}")
    public LoginEntity getLoggedInUser(@PathVariable String emailAddress){
        return loginService.findByEmailAddress(emailAddress);
    }
}
