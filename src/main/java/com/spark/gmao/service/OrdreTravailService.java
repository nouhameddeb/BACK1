package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.OrdreTravail;

public interface OrdreTravailService {

	OrdreTravail getOrdre(Long idOrdre);

	List<OrdreTravail> getAllOrdre();

	OrdreTravail saveOrdre(OrdreTravail ordreTravail);

	void deleteOrdre(Long idOrdre);


}
