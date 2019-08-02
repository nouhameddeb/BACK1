package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.OrdreTravail;

@Repository
public interface OrdreTravailRepository extends CrudRepository<OrdreTravail, Long> {

}
