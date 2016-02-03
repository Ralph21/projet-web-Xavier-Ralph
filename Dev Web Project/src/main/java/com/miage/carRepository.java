package com.miage;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * créer la bdd composé d'une liste de véhicules
 * @author xababa_mac
 *
 */
public interface carRepository extends CrudRepository<car, Long>
{
	car findById(long id);
    List<car> findByMarque(String marque);
    List<car> findByModele(String modele);
}