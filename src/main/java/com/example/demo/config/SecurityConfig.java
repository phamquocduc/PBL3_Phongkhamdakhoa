package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService user() {
        UserDetails userDetails = User.builder()
			.username("user")
			.password("{bcrypt}$2a$10$2CDhnnLHFoi8yVtNchYjBOkroZI7jIWUOPQCgSJLre0wRIPCyPGZS")
			.roles("USER")
			.build();

		return new InMemoryUserDetailsManager(userDetails);
    }

	@Bean
	SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		http
          .csrf(csrf-> csrf.disable());
        return http.build();
	}
}
