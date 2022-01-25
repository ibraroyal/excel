package com.netgroup.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.netgroup.access.data.Role;
import com.netgroup.access.data.Utente;
import com.netgroup.access.service.UtenteService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AccessApplication{
	
	
	

	
	@Autowired
	BCryptPasswordEncoder bcPassword;

	public static void main(String[] args) {
		SpringApplication.run(AccessApplication.class, args);
	}
	
	
	
	
	@Bean
    BCryptPasswordEncoder passEncoder(){
        return new BCryptPasswordEncoder();
    }



	

	
	
}
