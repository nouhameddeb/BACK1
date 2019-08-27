package com.spark.gmao.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class SousTraitantDto {
	
	private Long idTraitant;
	private Integer cin;
	private String nom;
	private Integer telephone;
	private String email;
	private String societe;
	private String adresse;

}
