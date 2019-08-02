package com.spark.gmao.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DemandeAchat {
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDemandeAchat;
	
	 @OneToMany(mappedBy = "demandeAchat", fetch = FetchType.LAZY)
	   private Set<DemandeAchatPiece> demandeAchatPieces;

}
