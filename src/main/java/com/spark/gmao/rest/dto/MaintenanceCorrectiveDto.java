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
public class MaintenanceCorrectiveDto {
	
	private Long idCorrective;
	private String typePanne;
	private String causePanne;
	private String etat;
	private String symptome;
	private String description;
	private MachineDto machineDto;
	private DemandeInterventionDto demandeInterventionDto;

}

