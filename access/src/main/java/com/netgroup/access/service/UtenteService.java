package com.netgroup.access.service;

import java.util.List;

import com.netgroup.access.data.Role;
import com.netgroup.access.data.Utente;

public interface UtenteService {

	public List<Utente> selTutti();

	public Utente selUser(String username);

	public Utente save(Utente utente);

	public void delete(Utente utente);
	
	public Role saveRole (Role role);
	
	public void aggiungiRuolo(String username, String ruolo);


}
