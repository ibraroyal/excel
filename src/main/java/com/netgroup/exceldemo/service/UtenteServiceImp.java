package com.netgroup.exceldemo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.netgroup.exceldemo.data.dao.Role;
import com.netgroup.exceldemo.data.dao.Utente;
import com.netgroup.exceldemo.repository.RoleRepo;
import com.netgroup.exceldemo.repository.UtenteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional @RequiredArgsConstructor
public class UtenteServiceImp implements UtenteService, UserDetailsService {

	@Autowired
	UtenteRepository uten;

	@Autowired
	RoleRepo roleRepo;
	
	private final BCryptPasswordEncoder bCryptPassword;

	@Override
	public void salva(Utente utent) {
		utent.setPassword(bCryptPassword.encode(utent.getPassword()));
		uten.save(utent);
	}

	@Override
	public List<Utente> lista() {
		return uten.findAll();
	}

	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utente user = uten.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("utente non registrato");
		}

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});

		return new User(user.getUsername(), user.getPassword(), authorities);
	}

	@Override
	public Utente cercaUtente(String username) {
		return uten.findByUsername(username);
	}

	@Override
	public Role SalvaRuolo(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public void aggiungiRuolo(String username, String ruolo) {
		Utente utente = uten.findByUsername(username);
		Role role = roleRepo.findByName(ruolo);
		utente.getRoles().add(role);
	}

}
