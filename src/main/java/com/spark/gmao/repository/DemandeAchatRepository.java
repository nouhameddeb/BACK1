package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.DemandeAchat;

@Repository
public interface DemandeAchatRepository extends CrudRepository<DemandeAchat, Long>{


}
