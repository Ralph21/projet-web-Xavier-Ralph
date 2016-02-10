package com.miage;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Utilisateur {

	//TODO : ajouter id ?
	
	// Le Prénom doit être relativement long 
 	//    mais pas trop court non plus.
    @Size(min=2, max=30)
    private String firstName;
	
    // Idem pour le Nom.
    @Size(min=2, max=30)
    private String lastName;
    

    // L'utilisateur doit spécifier son âge
    @NotNull
    @Min(18)
    private Integer age;
    
    // TODO: add validation annotation
    private String sexe;

    private String email;
    private String pwd;
    

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
    
    


}