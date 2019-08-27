package com.spark.gmao.model.entity;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "MAINTENANCE_CORRECTIVE")
@DiscriminatorValue("Corrective")
public class MaintenanceCorrective extends Maintenance{
	
	private static final long serialVersionUID = 1L;


	
	@Column(name = "CAUSE_PANNE", length = 50)
	private static String causePanne;
	
	@Column(name = "TYPE_PANNE", length = 50)
	private static String typePanne;
	
	@Column(name = "DESCRIPTION", length = 50)
	private static String description;
	
	@Column(name = "ETAT", length = 50)
	private String etat;
	
	@Column(name = "SYMPTOME", length = 50)
	private String symptome;


/*	public MaintenanceCorrective(Long idM, Date datedebut, Date datefin, Consultant consultant, Set<Piece> pieces,
			OrdreTravail ordreTravail, FactureInterne factureInterne, Rapport rapport, String causePanne, String typePanne, String etat, String symptome, String description) {
		super(idM, typePanne, causePanne, description, datedebut, datefin, consultant, sousTraitant, pieces, ordreTravail, factureInterne, rapport);
		this.causePanne = causePanne;
		this.typePanne = typePanne;
		this.etat = etat;
		this.symptome = symptome;
		this.description = description;
	
	}*/

	/*public MaintenanceCorrective(Long idM, Date datedebut, Date datefin, Consultant consultant, Set<Piece> pieces,
			OrdreTravail ordreTravail, FactureInterne factureInterne, Rapport rapport) {
		super(idM, typePanne, causePanne, description, datedebut, datefin, consultant, sousTraitant, pieces, ordreTravail, factureInterne, rapport);
	}
	*/
}
