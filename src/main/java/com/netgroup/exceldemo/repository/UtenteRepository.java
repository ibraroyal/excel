package com.netgroup.exceldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netgroup.exceldemo.data.dao.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

	Utente findByUsername(String user);
}
