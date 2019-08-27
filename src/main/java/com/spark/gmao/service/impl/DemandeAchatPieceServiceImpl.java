package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.gmao.model.entity.DemandeAchat;
import com.spark.gmao.model.entity.DemandeAchatPiece;
import com.spark.gmao.model.entity.Piece;
import com.spark.gmao.model.pk.DemandeAchatPieceKey;
import com.spark.gmao.repository.DemandeAchatPieceRepository;
import com.spark.gmao.repository.DemandeAchatRepository;
import com.spark.gmao.repository.PieceRepository;
import com.spark.gmao.service.DemandeAchatPieceService;

@Service
public class DemandeAchatPieceServiceImpl implements DemandeAchatPieceService {
	
	   @Autowired
	    private DemandeAchatPieceRepository demandeAchatPieceRepository;
	    
	    @Autowired
	    private DemandeAchatRepository demandeAchatRepository;
	    
	    @Autowired
	    private PieceRepository pieceRepository;
	    
	    @Override
	    public DemandeAchatPiece getDemandeAchatPiece(Long idDemandeAchat, Long idPi) {
	        DemandeAchatPieceKey demandeAchatPieceKey = new DemandeAchatPieceKey(idDemandeAchat, idPi);
	        DemandeAchatPiece demandeAchatPiece = demandeAchatPieceRepository.findOne(demandeAchatPieceKey);
	        if(demandeAchatPiece == null) {
	            System.out.println("Not found");
	        }
	        return demandeAchatPiece;
	    }
	    @Override
	    public List<DemandeAchatPiece> getAllDemandeAchatPiece() {
	        return (List<DemandeAchatPiece>) demandeAchatPieceRepository.findAll();
	    }
	    @Override
	    @Transactional
	    public DemandeAchatPiece saveDemandeAchatPiece(Long idDemandeAchat, Long idPi, DemandeAchatPiece demandeAchatPiece) {
	        
	        // recupération du transporteur
	        DemandeAchat demandeAchat = demandeAchatRepository.findOne(idDemandeAchat);
	        
	        // recupération du dossier client
	        Piece piece = pieceRepository.findOne(idPi);
	        
	        
	        // construction du TransporteurDossierClient
	        demandeAchatPiece = new DemandeAchatPiece();
	        demandeAchatPiece.setDemandeAchat(demandeAchat);
	        demandeAchatPiece.setPiece(piece);
	        
	        return demandeAchatPieceRepository.save(demandeAchatPiece);    
	    }
	    @Override
	    @Transactional
	    public DemandeAchatPiece updateDemandeAchatPiece(Long idDemandeAchat, Long idPi, DemandeAchatPiece demandeAchatPiece) {
	        demandeAchatPiece = getDemandeAchatPiece(idDemandeAchat, idPi);
	        DemandeAchatPieceKey demandeAchatPieceKey = new DemandeAchatPieceKey();
	        demandeAchatPieceKey.setIdDemandeAchat(idDemandeAchat);
	        demandeAchatPieceKey.setIdPi(idPi);
	        demandeAchatPiece.setId(demandeAchatPieceKey);
	        return saveDemandeAchatPiece(idDemandeAchat, idPi, demandeAchatPiece);
	    }
	    @Override
	    @Transactional
	    public void deleteDemandeAchatPiece(Long idDemandeAchat, Long idPi) {
	        DemandeAchatPiece demandeAchatPiece = getDemandeAchatPiece(idDemandeAchat, idPi);
	        if(demandeAchatPiece == null) {
	            System.out.println("Not found");
	        }
	        demandeAchatPieceRepository.delete(demandeAchatPiece);
	    }
	}

