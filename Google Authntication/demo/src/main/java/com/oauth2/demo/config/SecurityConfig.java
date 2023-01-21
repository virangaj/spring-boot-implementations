package com.oauth2.demo.config;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login(oauthCustomize -> oauthCustomize
                        .loginProcessingUrl("/login")
                        .loginPage("/oauth2/authorization/google")
                        .successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request,
                                                                HttpServletResponse response,
                                                                Authentication authentication) throws IOException, ServletException {
                                request.authenticate(response);
                            }
                        }).failureHandler(new AuthenticationFailureHandler() {
                                         @Override
                                         public void onAuthenticationFailure(HttpServletRequest request,
                                                                             HttpServletResponse response,
                                                                             AuthenticationException exception) throws IOException, ServletException {

                                         }
                                     })
                            );

        return http.build();
    }
}
