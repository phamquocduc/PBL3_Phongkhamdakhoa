package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Data
@Builder
public class Greeting {

    private long id;
    private String content;
    
}

