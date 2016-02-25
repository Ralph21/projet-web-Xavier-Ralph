package com.miage.services;

import com.miage.domain.Equipement;
import com.miage.repositories.EquipementRepository;

public class EquipementServiceImpl implements EquipementService{

	private EquipementRepository equipementRepository;
	
	@Override
	public Iterable<Equipement> listAllEquipement() {
		return equipementRepository.findAll();
	}

	@Override
	public Equipement getEquipementById(Integer id) {
		return equipementRepository.findOne(id);
	}

	@Override
	public Equipement saveEquipement(Equipement equipement) {
		return equipementRepository.save(equipement);
	}

}
