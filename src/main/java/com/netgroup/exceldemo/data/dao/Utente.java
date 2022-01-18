package com.netgroup.exceldemo.data.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "utenti")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "username", unique = true)
	@NotBlank @NotEmpty @NotNull
 	private String username; 

	@Column(name = "firstname")
	@NotBlank @NotEmpty @NotNull
	private String firstName;

	@Column(name = "lastname")
	@NotBlank @NotEmpty @NotNull
	private String lastName;

	@Column(name = "email")
	@NotBlank @NotEmpty @NotNull
	private String email;

	@Column(name = "password")
	@NotBlank
	@NotEmpty
	@NotNull
	private String password;

	@Column(name = "role")
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<>();

}
