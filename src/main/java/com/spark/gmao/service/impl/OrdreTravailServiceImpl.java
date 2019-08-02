package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.OrdreNotFoundException;
import com.spark.gmao.model.entity.OrdreTravail;
import com.spark.gmao.repository.OrdreTravailRepository;
import com.spark.gmao.service.OrdreTravailService;

@Service
public class OrdreTravailServiceImpl implements OrdreTravailService{

	@Autowired
	private OrdreTravailRepository ordreTravailRepository;
	
	@Override
	public OrdreTravail getOrdre(Long idOrdre) {
		OrdreTravail ordreTravail = ordreTravailRepository.findOne(idOrdre);
		if(ordreTravail == null) {
			throw new OrdreNotFoundException();
		}
		return ordreTravail;
	}

	@Override
	public List<OrdreTravail> getAllOrdre() {
		return (List<OrdreTravail>) ordreTravailRepository.findAll();
	}
	
	@Transactional
	@Override
	public OrdreTravail saveOrdre(OrdreTravail ordreTravail) {
		return ordreTravailRepository.save(ordreTravail);
		
	}

	@Override
	public void deleteOrdre(Long idOrdre) {
		try {
			ordreTravailRepository.delete(idOrdre);
		} catch (EmptyResultDataAccessException e) {
			throw new OrdreNotFoundException();
		}
		
	}

}
