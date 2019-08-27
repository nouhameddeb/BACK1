package com.spark.gmao.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spark.gmao.model.entity.Fournisseur;
import com.spark.gmao.rest.dto.FournisseurDto;
import com.spark.gmao.service.FournisseurService;

@CrossOrigin("*")
@RestController
public class FournisseurController {
	
	@Autowired
	private FournisseurService fournisseurService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/fournisseurs")
	public Object fournisseursList() {
		List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseur();
		Type listType = new TypeToken<List<FournisseurDto>>(){}.getType();
		List<FournisseurDto> fournisseurDtos = modelMapper.map(fournisseurs, listType);
		return ResponseEntity.status(HttpStatus.OK).body(fournisseurDtos);
	}

	@GetMapping("/fournisseurs/{idFournisseur}")
	public Object retrievefournisseur(@PathVariable Long idFournisseur) {
		Fournisseur fournisseur = fournisseurService.getFournisseur(idFournisseur);
		FournisseurDto fournisseurDto = modelMapper.map( fournisseur,  FournisseurDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(fournisseurDto);
	}
	
	@PostMapping("/fournisseurs")
	public Object saveFournisseur(@Valid @RequestBody FournisseurDto fournisseurDto) {
		Fournisseur fournisseur = modelMapper.map(fournisseurDto, Fournisseur.class);
		
		fournisseur = fournisseurService.saveFournisseur(fournisseur);

		fournisseurDto = modelMapper.map(fournisseur, FournisseurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(fournisseurDto);
	}
	
	@PutMapping("/fournisseurs/{idFournisseur}")
	public Object updateFournisseur(@Valid @RequestBody FournisseurDto fournisseurDto, @PathVariable long idFournisseur) {
		Fournisseur fournisseur = modelMapper.map(fournisseurDto, Fournisseur.class);
		fournisseur.setIdFournisseur(idFournisseur);
	fournisseur = fournisseurService.saveFournisseur(fournisseur);
		
		fournisseurDto = modelMapper.map(fournisseur, FournisseurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(fournisseur);
	}
	
	@DeleteMapping("/fournisseurs/{idFournisseur}")
	public Object Delete(@PathVariable("idFournisseur") long idFournisseur) {
		fournisseurService.deleteFournisseur(idFournisseur);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
}
