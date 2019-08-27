package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.FournisseurNotFoundException;
import com.spark.gmao.model.entity.Fournisseur;
import com.spark.gmao.repository.FournisseurRepository;
import com.spark.gmao.service.FournisseurService;

@Service
public class FournisseurServiceImpl implements FournisseurService{
	
	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	@Override
	public Fournisseur getFournisseur(Long idFournisseur) {
		Fournisseur fournisseur = fournisseurRepository.findOne(idFournisseur);
		if(fournisseur == null) {
			throw new FournisseurNotFoundException();
		}
		return fournisseur;
	}
	
	
	@Override
	public List<Fournisseur> getAllFournisseur() {
		return (List<Fournisseur>) fournisseurRepository.findAll();
	}
	
	@Transactional
	@Override
	public Fournisseur saveFournisseur(Fournisseur fournisseur) {
		return fournisseurRepository.save(fournisseur);
	}

	@Override
	public void deleteFournisseur(Long idFournisseur) {
		try {
			fournisseurRepository.delete(idFournisseur);
		} catch (EmptyResultDataAccessException e) {
			throw new FournisseurNotFoundException();
		}
	}

}
