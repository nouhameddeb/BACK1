package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.Fournisseur;

@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long>{

}
