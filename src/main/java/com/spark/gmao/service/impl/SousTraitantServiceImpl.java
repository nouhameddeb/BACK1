package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.SousTraitantNotFoundException;
import com.spark.gmao.model.entity.SousTraitant;
import com.spark.gmao.repository.SousTraitantRepository;
import com.spark.gmao.service.SousTraitantService;

@Service
public class SousTraitantServiceImpl implements SousTraitantService{
	
	@Autowired
	private SousTraitantRepository sousTraitantRepository;
	
	@Override
	public SousTraitant getSousTraitant(Long idTraitant) {
		SousTraitant sousTraitant = sousTraitantRepository.findOne(idTraitant);
		if(sousTraitant == null) {
			throw new SousTraitantNotFoundException();
		}
		return sousTraitant;
	}
	
	@Override
	public List<SousTraitant> getAllSousTraitant() {
		return (List<SousTraitant>) sousTraitantRepository.findAll();
	}
	
	@Transactional
	@Override
	public SousTraitant saveSousTraitant(SousTraitant sousTraitant) {
		return sousTraitantRepository.save(sousTraitant);
	}

	@Override
	public void deleteSousTraitant(Long idTraitant) {
		try {
			sousTraitantRepository.delete(idTraitant);
		} catch (EmptyResultDataAccessException e) {
			throw new SousTraitantNotFoundException();
		}
	}

}
