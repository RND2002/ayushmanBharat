package com.codesite.ayushmanProject.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {
    private String jwtToken;
    private String username;

    private Collection<? extends GrantedAuthority> role;


}

