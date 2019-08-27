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

import com.spark.gmao.model.entity.DemandeAchatPiece;
import com.spark.gmao.rest.dto.DemandeAchatPieceDto;
import com.spark.gmao.service.DemandeAchatPieceService;


@CrossOrigin("*")
@RestController
public class DemandeAchatPieceController {
	
	@Autowired
    private DemandeAchatPieceService demandeAchatPieceService;
	
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping("/demandeAchatPieces")
    public Object DemandeAchatPieceList() {
        List<DemandeAchatPiece> demandeAchatPieces = demandeAchatPieceService.getAllDemandeAchatPiece();
        Type listType = new TypeToken<List<DemandeAchatPieceDto>>() {}.getType();
        List<DemandeAchatPieceDto> demandeAchatPieceDtos = 
                modelMapper.map(demandeAchatPieces, listType);
        return ResponseEntity.status(HttpStatus.OK).body(demandeAchatPieceDtos);
    }
    
    @GetMapping("/demandeAchatPiece/{id}")
    public Object retrieveDemandeAchatPiece(@PathVariable("id") Long idDemandeAchat, Long idPi) {
        DemandeAchatPiece demandeAchatPiece = demandeAchatPieceService.getDemandeAchatPiece(idDemandeAchat, idPi);
        DemandeAchatPieceDto demandeAchatPieceDto = modelMapper.map(demandeAchatPiece,  DemandeAchatPieceDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(demandeAchatPieceDto);
    }
    
    @PostMapping("/demandeAchatPiece")
    public Object addDemandeAchatPiece(@Valid @RequestBody DemandeAchatPieceDto demandeAchatPieceDto) {
        
        DemandeAchatPiece demandeAchatPiece = modelMapper.map(demandeAchatPieceDto, DemandeAchatPiece.class);
        
        demandeAchatPiece = demandeAchatPieceService.saveDemandeAchatPiece(demandeAchatPieceDto.getIdDemandeAchat(), demandeAchatPieceDto.getIdPi(), demandeAchatPiece);
        demandeAchatPieceDto = modelMapper.map(demandeAchatPiece, DemandeAchatPieceDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(demandeAchatPieceDto);
    }
    
    @PutMapping("/demandeAchatPiece/{id}")
    public Object updateDemandeAchatPiece(@Valid @RequestBody DemandeAchatPieceDto demandeAchatPieceDto, @PathVariable("id") Long idDemandeAchat, Long idPi) {

        DemandeAchatPiece demandeAchatPiece = modelMapper.map(demandeAchatPieceDto, DemandeAchatPiece.class);
        demandeAchatPiece = demandeAchatPieceService.updateDemandeAchatPiece(idDemandeAchat, idPi, demandeAchatPiece);
        demandeAchatPieceDto = modelMapper.map(demandeAchatPiece, DemandeAchatPieceDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(demandeAchatPieceDto);
    }
    
    @DeleteMapping("/demandeAchatPiece/{id}")
    public Object DeleteDemandeAchatPiece(@PathVariable("id") Long idDemandeAchat, Long idPi) {

        demandeAchatPieceService.deleteDemandeAchatPiece(idDemandeAchat, idPi);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
