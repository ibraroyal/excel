package com.netgroup.access.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.netgroup.access.data.Role;
import com.netgroup.access.data.Utente;
import com.netgroup.access.service.UtenteService;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

import java.util.List;

@RestController @RequestMapping(value = "/api")
@RequiredArgsConstructor  @Slf4j
public class ControllerLogin {


	private final UtenteService ser;
	

    @GetMapping("/users")
    public ResponseEntity<List<Utente>> getUsers(){
        log.info("getUsers works");
        return ResponseEntity.ok().body(ser.selTutti());
    }

    @PostMapping("/user/save")
    public ResponseEntity<Utente> saveUser(@RequestBody Utente utente){
        log.info("save user works");
        return ResponseEntity.ok().body(ser.save(utente));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role ruolo){
        log.info("save role works");
        return ResponseEntity.ok().body(ser.saveRole(ruolo));
    }

    @PostMapping("/role/add")
    public ResponseEntity<Role> addRoleToUser(@RequestParam("utente") String utente, @RequestParam("ruolo") String ruolo) throws RoleNotFoundException {
        log.info("add role to user works");
        ser.aggiungiRuolo(utente,ruolo);
        return ResponseEntity.ok().build();
    }
    
    
	@PostMapping(value = "/register")
    public ResponseEntity<String> addUser(@Valid @RequestBody Utente ute, BindingResult result) {
		if(result.hasErrors()) {
			return ResponseEntity.status(422).body(result.toString());
		}
		ser.save(ute);
		log.info("utente registrato con successo!");
		
		 return ResponseEntity.ok().body("saved");
	}
    
	@PostMapping(value = "/getUser")
	 public ResponseEntity<Utente> getUser(@RequestParam("username") String username) {
		log.info("utente registrato con successo!");
		 return ResponseEntity.ok().body(ser.selUser(username));
	}
    
}
