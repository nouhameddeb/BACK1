package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.Fournisseur;

public interface FournisseurService {

	Fournisseur getFournisseur(Long idFournisseur);

	List<Fournisseur> getAllFournisseur();

	Fournisseur saveFournisseur(Fournisseur fournisseur);

	void deleteFournisseur(Long idFournisseur);

}
