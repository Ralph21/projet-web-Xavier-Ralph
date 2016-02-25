package com.miage.services;

import com.miage.domain.Equipement;

public interface EquipementService {
	Iterable<Equipement> listAllEquipement();

	Equipement getEquipementById(Integer id);

	Equipement saveEquipement(Equipement equipement);
}
