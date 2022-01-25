package com.netgroup.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netgroup.access.data.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

	Utente findByUsername(String user); 
}
