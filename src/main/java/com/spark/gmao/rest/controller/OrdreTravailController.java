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

import com.spark.gmao.model.entity.OrdreTravail;
import com.spark.gmao.rest.dto.OrdreTravailDto;
import com.spark.gmao.service.OrdreTravailService;

@CrossOrigin("*")
@RestController
public class OrdreTravailController {
	
    @Autowired
    private OrdreTravailService ordreTravailService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping("/ordres")
	public Object equipementsList() {
		List<OrdreTravail> ordreTravails = ordreTravailService.getAllOrdre();
		Type listType = new TypeToken<List<OrdreTravailDto>>(){}.getType();
		List<OrdreTravailDto> ordreTravailDto = modelMapper.map(ordreTravails, listType);
		return ResponseEntity.status(HttpStatus.OK).body(ordreTravailDto);
	}
	
	@GetMapping("/ordres/{idOrdre}")
	public Object retrieveordre(@PathVariable Long idOrdre) {
		OrdreTravail ordreTravail = ordreTravailService.getOrdre(idOrdre);
		OrdreTravailDto ordreTravailDto = modelMapper.map( ordreTravail,  OrdreTravailDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(ordreTravailDto);
	}
	
	@PostMapping("/ordres")
	public Object saveOrdre(@Valid @RequestBody OrdreTravailDto ordreTravailDto) {
		OrdreTravail ordreTravail = modelMapper.map(ordreTravailDto, OrdreTravail.class);
		
		ordreTravail = ordreTravailService.saveOrdre(ordreTravail);

		ordreTravailDto = modelMapper.map(ordreTravail, OrdreTravailDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordreTravailDto);
	}
	
	@PutMapping("/ordres/{idOrdre}")
	public Object updateOrdre(@Valid @RequestBody OrdreTravailDto ordreTravailDto, @PathVariable long idOrdre) {
		OrdreTravail ordreTravail = modelMapper.map(ordreTravailDto, OrdreTravail.class);
		ordreTravail.setIdOrdre(idOrdre);
	ordreTravail = ordreTravailService.saveOrdre(ordreTravail);
		
		ordreTravailDto = modelMapper.map(ordreTravail, OrdreTravailDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordreTravail);
	}
	
	@DeleteMapping("/ordres/{idOrdre}")
	public Object Delete(@PathVariable("idOrdre") long idOrdre) {
		ordreTravailService.deleteOrdre(idOrdre);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	

}
