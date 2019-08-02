package com.spark.gmao.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable  //clé composé car dans une table associative bch tjib les 2 id)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeAchatPieceKey implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
	@Column(name = "ID")
	private Long idPi;
	
	@Column(name = "ID")
	private Long idDemandeAchat;
	
	
	
	
	

}
