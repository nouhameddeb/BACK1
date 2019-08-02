package com.spark.gmao.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class OrdreTravailDto {
	
	private Long idOrdre;
	private Long numOrdre;
	private String module;
	private Date dateOT;
	private Date dateFin;
	private String typeMaintenance;
	private Integer niveauMaintenance;
	private String criticite;
	private MachineDto machine;
	private DemandeInterventionDto demande;
	private PieceDto piece;
	



}
