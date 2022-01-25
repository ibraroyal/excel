package com.netgroup.access.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utenti")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "username")
	@NotEmpty
	@NotBlank
	@NotNull
	private String username;

	@Column(name = "firstname")
	@NotEmpty
	@NotBlank
	@NotNull
	private String firstName;

	@Column(name = "lastname")
	@NotEmpty
	@NotBlank
	@NotNull
	private String lastName;

	@Column(name = "email")
	@NotEmpty
	@NotBlank
	@NotNull
	private String email;

	@Column(name = "password")
	@NotEmpty
	@NotBlank
	@NotNull
	private String password;

	@Column(name = "role")
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles;

}
