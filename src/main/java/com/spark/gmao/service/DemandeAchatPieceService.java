package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.DemandeAchatPiece;

public interface DemandeAchatPieceService {

	DemandeAchatPiece getDemandeAchatPiece(Long idDemandeAchat, Long idPi);

	List<DemandeAchatPiece> getAllDemandeAchatPiece();

	DemandeAchatPiece saveDemandeAchatPiece(Long idDemandeAchat, Long idPi, DemandeAchatPiece demandeAchatPiece);

	void deleteDemandeAchatPiece(Long idDemandeAchat, Long idPi);

	DemandeAchatPiece updateDemandeAchatPiece(Long idDemandeAchat, Long idPi, DemandeAchatPiece demandeAchatPiece);

}
