package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.SousTraitant;

public interface SousTraitantService {

	SousTraitant getSousTraitant(Long idTraitant);

	List<SousTraitant> getAllSousTraitant();

	SousTraitant saveSousTraitant(SousTraitant sousTraitant);

	void deleteSousTraitant(Long idTraitant);

}
