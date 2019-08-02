package com.spark.gmao.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.spark.gmao.model.pk.DemandeAchatPieceKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeAchatPiece {
	
	@EmbeddedId
	private DemandeAchatPieceKey id;
	
	@ManyToOne
	@MapsId("idPi")
    @JoinColumn(name = "ID_PIEC")
    private Piece piece;
    
    @ManyToOne
    @MapsId("idDemandeAchat")
    @JoinColumn(name = "ID_DEMANDE")
    private DemandeAchat demandeAchat;

}
