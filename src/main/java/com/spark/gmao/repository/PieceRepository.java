package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.Piece;

@Repository
public interface PieceRepository extends CrudRepository<Piece, Long>{


}
