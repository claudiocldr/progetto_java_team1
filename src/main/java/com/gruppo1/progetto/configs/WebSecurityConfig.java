package com.gruppo1.progetto.configs;

import com.gruppo1.progetto.repositories.UserRepository;
import jakarta.activation.DataSource;
import jakarta.servlet.annotation.ServletSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.management.relation.Role;
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
