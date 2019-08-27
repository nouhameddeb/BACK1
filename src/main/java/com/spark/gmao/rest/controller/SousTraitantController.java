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

import com.spark.gmao.model.entity.SousTraitant;
import com.spark.gmao.rest.dto.SousTraitantDto;
import com.spark.gmao.service.SousTraitantService;

@CrossOrigin("*")
@RestController
public class SousTraitantController {
	
	@Autowired
	private SousTraitantService sousTraitantService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/traitants")
	public Object sousTraitantsList() {
		List<SousTraitant> sousTraitants = sousTraitantService.getAllSousTraitant();
		Type listType = new TypeToken<List<SousTraitantDto>>(){}.getType();
		List<SousTraitantDto> sousTraitantDtos = modelMapper.map(sousTraitants, listType);
		return ResponseEntity.status(HttpStatus.OK).body(sousTraitantDtos);
	}
	
	@GetMapping("/traitants/{idTraitant}")
	public Object retrievesousTraitant(@PathVariable Long idTraitant) {
		SousTraitant sousTraitant= sousTraitantService.getSousTraitant(idTraitant);
		SousTraitantDto sousTraitantDto = modelMapper.map( sousTraitant,  SousTraitantDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(sousTraitantDto);
	}
	
	@PostMapping("/traitants")
	public Object saveSousTraitant(@Valid @RequestBody SousTraitantDto sousTraitantDto) {
		SousTraitant sousTraitant = modelMapper.map(sousTraitantDto, SousTraitant.class);
		
		sousTraitant = sousTraitantService.saveSousTraitant(sousTraitant);

		sousTraitantDto = modelMapper.map(sousTraitant, SousTraitantDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(sousTraitantDto);
	}
	
	@PutMapping("/traitants/{idTraitant}")
	public Object updateSousTraitant(@Valid @RequestBody SousTraitantDto sousTraitantDto, @PathVariable long idTraitant) {
		SousTraitant sousTraitant = modelMapper.map(sousTraitantDto, SousTraitant.class);
		sousTraitant.setIdTraitant(idTraitant);
	sousTraitant = sousTraitantService.saveSousTraitant(sousTraitant);
		
		sousTraitantDto = modelMapper.map(sousTraitant, SousTraitantDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(sousTraitant);
	}
	
	@DeleteMapping("/traitants/{idTraitant}")
	public Object Delete(@PathVariable("idTraitant") long idTraitant) {
		sousTraitantService.deleteSousTraitant(idTraitant);;
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	

	

}
