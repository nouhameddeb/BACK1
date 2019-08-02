package com.spark.gmao.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "FOURNISSEUR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFournisseur;
	
	@Column(name = "NAME", length = 50)
	 private String nomFournisseur;
	
	 
	 @Column(name = "ENTREPRISE", length = 50)
	 private String entr;
	 
	 @Column(name = "VILLE", length = 50)
	 private String ville;
	 	 
	 @Column(name = "TELEPHONE", length = 50)
	 private Long telF;
	 
	 @Column(name = "MAIL", length = 50)
	 private String mail;
	 

}
