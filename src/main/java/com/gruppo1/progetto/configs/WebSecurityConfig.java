package com.gruppo1.progetto.configs;

import com.gruppo1.progetto.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final UserRepository userRepository;
    @Autowired
    public WebSecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> listOfUsers = new ArrayList<>();

        for (com.gruppo1.progetto.models.User user : userRepository.findAll()) {
            UserDetails userLogin =
                    User.withDefaultPasswordEncoder().username(user.getUsername())
                            .password(user.getPassword())
                            .roles("USER")
                            .build();
            listOfUsers.add(userLogin);
        }
        return new InMemoryUserDetailsManager(listOfUsers);
    }
}
