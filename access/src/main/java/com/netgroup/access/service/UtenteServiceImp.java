package com.netgroup.access.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.netgroup.access.data.Role;
import com.netgroup.access.data.Utente;
import com.netgroup.access.repository.RoleRepo;
import com.netgroup.access.repository.UtenteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
 @RequiredArgsConstructor
public class UtenteServiceImp implements UtenteService, UserDetailsService {

	@Autowired
	UtenteRepository uten;

	@Autowired
	RoleRepo roleRepo;
	
	private final BCryptPasswordEncoder bCryptPassword;

	@Override
	public List<Utente> selTutti()
	{
		return uten.findAll();
	}

	@Override
	public Utente selUser(String username)
	{
		return uten.findByUsername(username);
	}


	@Override
	public Utente save(Utente utente)
	{
		utente.setPassword(bCryptPassword.encode(utente.getPassword()));
		return uten.save(utente);
	}

	@Override
	public void delete(Utente utente)
	{
		uten.delete(utente);
	}

	@Override
	public Role saveRole(Role role) {
		
		return roleRepo.save(role);
	}

	@Override
	public void aggiungiRuolo(String username, String ruolo) {
		Utente utente = uten.findByUsername(username);
		Role role = roleRepo.findByName(ruolo);
		utente.getRoles().add(role);
		
	}

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente user=uten.findByUsername(username);
        if(user == null){
            log.info("User couldn't be found");
            throw new UsernameNotFoundException("User couldn't be found");
        }
        log.info("loaded user by username "+username);
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        //  ↓ ↓ user di tipo  userdetails   default di spring security
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }


}
