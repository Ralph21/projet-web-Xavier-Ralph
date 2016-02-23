package com.miage.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class carImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idcI;
	
	@NotNull
	@Lob
	private byte[] picture;
}
