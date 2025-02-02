package com.ssa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Disables CSRF protection
				.authorizeHttpRequests(auth -> auth.anyRequest().authenticated() // All endpoints require authentication
				).httpBasic(httpBasic -> {
				}); // Enables Basic Authentication

		return http.build();
	}

}
