package com.netgroup.exceldemo.service;

import java.util.List;
import java.util.Optional;

import com.netgroup.exceldemo.data.dao.Role;
import com.netgroup.exceldemo.data.dao.Utente;



public interface UtenteService {
	
	public void salva(Utente utent);
	public Utente cercaUtente(String username);
	public Role SalvaRuolo(Role role);
	public void aggiungiRuolo(String username, String ruolo);
	public List<Utente> lista();
	
}
