package com.example.healthcare_managment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"/").permitAll()
                .requestMatchers("/user/register").permitAll()
                .requestMatchers("/user/admin").hasAnyAuthority("ADMIN")
                .requestMatchers("/doctors/**").hasAnyAuthority("ADMIN","DOCTOR")
                .requestMatchers("/patients/remove").hasAuthority("ADMIN")
                .requestMatchers("/patients/add").hasAnyAuthority("ADMIN","PATIENT")
                .requestMatchers("/appointments/remove").hasAnyAuthority("ADMIN","DOCTOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/customLogin")
                .defaultSuccessUrl("/customSuccessLogin")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .logout().permitAll()
                .logoutSuccessUrl("/");



        return httpSecurity.build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
}
