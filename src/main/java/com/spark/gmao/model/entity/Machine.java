package com.spark.gmao.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MACHINE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Machine implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idM;
	
	@Column(name = "DESIGNATION", length = 50, nullable = false)
	private String designation;
	
	/*@Column(name = "CODE", length = 50, nullable = false)
	private String code;
	
	@Column(name = "LIBELLE", length = 50, nullable = false)
	private String libelle;*/
	
	@Column(name = "REFERENCE", length = 50, nullable = false)
	private String reference;
	
	/*@Column(name = "TYPE", length = 50, nullable = false)
	private String type;*/
	
	@Column(name = "MODELE", length = 50)
	private String modele;
	
	@Column(name = "MARQUE", length = 50, nullable = false)
	private String marque;
	
	@Column(name = "FOURNISSEUR", length = 50, nullable = false)
	private String fournisseur;
	
	@Column(name = "FABRICANT", length = 50, nullable = false)
	private String fabricant;
	
	@Column(name = "DATE_ACQUISITION", length = 50, nullable = false)
	private Date dateAcquisition;
	
	@Column(name = "MISE_EN_PANNE", length = 50)
	private Date miseEnPanne;
	
	@Column(name = "FIN_GARANTIE", length = 50, nullable = false)
	private Date finGarantie;
	
	@Column(name = "CRITICITE", length = 50, nullable = false)
	private String criticite;
	
	@Column(name = "LOCALISATION", length = 50, nullable = false)
	private String localisation;
	
	@Column(name = "COMMENTAIRES", length = 50)
	private String com;
	
	@OneToMany(mappedBy = "machine", fetch = FetchType.LAZY)
	   private Set<DemandeIntervention> demandeIntervention;

	public void setIdMachine(long idM) {
		// TODO Auto-generated method stub
		
	}

}
