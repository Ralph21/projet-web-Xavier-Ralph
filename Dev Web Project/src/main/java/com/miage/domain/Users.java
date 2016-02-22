package com.miage.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@NamedQuery(name = "Users.findByUserName",
query = "select u from Users u where u.username = ?1")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUtilisateur;

	@Size(min = 2, max = 30)
	private String firstName;

	@Size(min = 2, max = 30)
	private String lastName;

	@NotNull
	@Min(18)
	private Integer age;

	private String username;

	private int enabled;

	// TODO: add validation annotation
	private String sexe;

	private String email;

	private String password;

	public Users() {
		super();
	}

	public Users(String firstName, String lastName, Integer age, String sexe, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.username = email;
		this.enabled = 1;
		this.sexe = sexe;
		this.email = email;
		this.password = encodeMDP(password);
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = encodeMDP(password);
	}
	
	public void setPasswordEncode(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	private String encodeMDP(String mdp) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(mdp);
	}

}