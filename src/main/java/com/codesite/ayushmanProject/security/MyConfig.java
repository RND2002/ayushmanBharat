package com.codesite.ayushmanProject.security;

import com.codesite.ayushmanProject.entitiy.LoginEntity;
import com.codesite.ayushmanProject.repository.LoginRepository;

import com.codesite.ayushmanProject.service.IdGenerationImpl;
import com.codesite.ayushmanProject.service.IdGenerationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Configuration
class MyConfig  {
//    @Bean
//    public IdGenerationService idGenerationService() {
//        return new IdGenerationImpl();
//    }

    private static final Logger logger = LoggerFactory.getLogger(MyConfig.class);


//    @Autowired
//    private PatientRepository patientRepository;

    @Autowired
    private LoginRepository loginRepository;

//    @Autowired
//    private UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            //            @Override
//            public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
//                System.out.println("Attempting to load user with email: " + emailAddress);
//                logger.info("Attempting to load user with email: " + emailAddress);
//                //PatientEntity patient = patientRepository.findByEmailAddress(emailAddress);
//               // LoginEntity entity=loginRepository.findByEmailAddress(emailAddress);
//                com.finalProjectBackend.HealthCare.entity.User user=userRepository.findByEmailAddress(emailAddress);
//
//                if (user == null) {
//                    throw new UsernameNotFoundException("User not found with this email addewss");
//                }
//
//
//
////                Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
////                grantedAuthorities.add(new SimpleGrantedAuthority(entity.getRole()));
//                List<GrantedAuthority> authorities = Arrays.stream(user.getRoles().spliterator(","))
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//                return new User(entity.getEmailAddress(), entity.getPassword(),authorities );
//            }
            public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
                LoginEntity loginEntity= loginRepository.findByEmailAddress(emailAddress);
                if (loginEntity == null)
                    throw new UsernameNotFoundException(
                            new StringBuffer().append("User name ").append(emailAddress).append(" not found!").toString());

                List<GrantedAuthority> authorities = loginEntity.getRoles().stream().map(role -> new SimpleGrantedAuthority(role))
                        .collect(Collectors.toList());
                System.out.println(authorities);
                return new org.springframework.security.core.userdetails.User(emailAddress, loginEntity.getPassword(), authorities);
            }
        };
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

}

//    @Autowired
//    PatientRepository patientRepository;
//    @Override
//    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
//        PatientEntity patient=patientRepository.findByEmail(emailAddress);
//        if(patient==null){
//            throw new UsernameNotFoundException("User not found with this email");
//        }
//
//        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority(patient.getRole()));
//
//        return new User(patient.getEmailAddress(),patient.getAdharNumber(),grantedAuthorities);
//    }
