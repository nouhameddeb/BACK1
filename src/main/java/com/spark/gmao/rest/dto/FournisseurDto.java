package com.spark.gmao.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(Include.NON_NULL)
public class FournisseurDto {
	private Long idFournisseur;
	private String nomFournisseur;
	private String entr;
	private String Ville;
	private Long telF;
	private String mail;
	
	

}
