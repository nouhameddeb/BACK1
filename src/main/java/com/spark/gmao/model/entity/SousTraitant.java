package com.spark.gmao.model.entity;

import java.io.Serializable;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SOUS_TRAITANT")
public class SousTraitant implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTraitant;
	
	@Column(name = "NAME", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "TELEPHONE", length = 50, nullable = false)
	private Integer telephone;
	
	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;
	
	
	@Column(name = "SOCIETE", length = 50, nullable = false)
	private String societe;
	
	@Column(name = "adresse", length = 50, nullable = false)
	private String adresse;
	
	@Column(name = "CIN", length = 50, nullable = false)
	private Integer cin;
	
	@OneToMany(mappedBy = "sousTraitant", fetch = FetchType.LAZY)
	   private Set<OrdreTravail> ordreTravails;
	 
	 @OneToMany(mappedBy = "sousTraitant", fetch = FetchType.LAZY)
	   private Set<Maintenance> maintenances;

	

}
