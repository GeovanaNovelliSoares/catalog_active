package com.erp.assets.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(c -> c.disable())
            .authorizeHttpRequests(a -> a.requestMatchers("/h2-console/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll().anyRequest().authenticated())
            .headers(h -> h.frameOptions(f -> f.disable()))
            .httpBasic(Customizer.withDefaults()).build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withDefaultPasswordEncoder().username("funcionario").password("123").roles("EMPLOYEE").build(),
            User.withDefaultPasswordEncoder().username("gerente").password("admin").roles("MANAGER").build()
        );
    }
}