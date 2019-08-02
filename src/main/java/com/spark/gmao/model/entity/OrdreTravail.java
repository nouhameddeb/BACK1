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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDRE_TRAVAIL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdreTravail implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrdre;
	
	@Column(name = "NUM_ORDRE", length = 50)
	 private Long numOrdre; //par telephone ou sur place
	
	@Column(name = "DateOT", length = 50)
	 private Date dateOT;
	
	@Column(name = "DateFin", length = 50)
	 private Date dateFin;
	
	@Column(name = "MODULE", length = 50)
	private String module;
	
	@Column(name = "TYPE_MAINTENANCE", length = 50)
	private String typeMaintenance;
	
	@Column(name = "NIVEAU_MAINTENANCE", length = 50)
	private Integer niveauMaintenance;
	
	@Column(name = "CRITICITE", length = 50)
	private String criticite;
	
	 @OneToMany(mappedBy = "ordreTravail", fetch = FetchType.LAZY)
	   private Set<Maintenance> maintenances;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name ="idDemande")
	   private DemandeIntervention demandeIntervention;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name ="idConsultant")
	   private Consultant consultant;

	public void setIdOrdre(long idOrdre) {
		// TODO Auto-generated method stub
		
	}

}
