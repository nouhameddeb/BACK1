package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.SousTraitant;

@Repository
public interface SousTraitantRepository extends CrudRepository<SousTraitant, Long> {
	

}
