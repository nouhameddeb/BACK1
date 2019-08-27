package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.DemandeAchatPiece;
import com.spark.gmao.model.pk.DemandeAchatPieceKey;

@Repository
public interface DemandeAchatPieceRepository extends CrudRepository<DemandeAchatPiece, DemandeAchatPieceKey>{

	Object findById(DemandeAchatPieceKey demandeAchatPieceKey);

}
