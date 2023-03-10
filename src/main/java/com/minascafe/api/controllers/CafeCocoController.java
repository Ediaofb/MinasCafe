package com.minascafe.api.controllers;

import java.security.NoSuchAlgorithmException;
import javax.naming.Binding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.minascafe.api.dtos.Cafe_CocoDto;
import com.minascafe.api.entities.Cafe_Coco;
import com.minascafe.api.responses.Cafe_CocoResponse;
import com.minascafe.api.services.Cafe_Coco_Service;

import jakarta.validation.Valid;

@RestController //Endpoint (página web) de Controller
@RequestMapping("/cadastrar_cafecoco") //Define a url da classe - "mapeando a requisição"
//@CrossOrigin(origins = "*") //Permite que as requisições venham de lugares distintos
public class CafeCocoController {
	
	public static final Logger log = LoggerFactory.getLogger(CafeCocoController.class); //Log para adicionar entradas no console
	
	@Autowired
	private Cafe_Coco_Service cafe_Coco_Service;

	/**
	 * Cadastra um lote de café em côco no sistema
	 * 
	 * @param cafe_cocoDto
	 * @return ResponseEntity<Response<Cafe_CocoDto>>
	 * @throws NoSuckAlgorithmException
	 */	
	
	@PostMapping//Verbo Http de 'Cadastro'
	public ResponseEntity<Cafe_CocoResponse<Cafe_CocoDto>> cadastrar(@Valid @RequestBody Cafe_CocoDto cafe_cocoDto,//RequestBody pega os dados do request e converte em um Dto. @Valid chama a validação que eu criei no Dto.
			BindingResult result) throws NoSuchAlgorithmException{//Exceção da parte de geração de senhas - BindingResult - terá a informação do resultado da validação do Dto.
		System.out.println(cafe_cocoDto);
	  log.info("Cadastrando um café em côco: {}", cafe_cocoDto.toString()); //passa os dados que chegaram via Post Request
	  Cafe_CocoResponse<Cafe_CocoDto> response = new Cafe_CocoResponse<Cafe_CocoDto>(); //Criando uma instância de Cafe_CocoResponse que será utilizado para retornar os dados. 
	  //validarDadosExistentes(cafe_cocoDto, result);
	  Cafe_Coco cafe_coco = this.converterDtoParaCafeCoco(cafe_cocoDto);	  
	  
	  if (result.hasErrors()) { //Se possui erros de validação
		  log.error("Erro validando dados de cadastro de café em côco: {}", result.getAllErrors());
		  result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
		  return ResponseEntity.badRequest().body(response);
	  }
	    
	    this.cafe_Coco_Service.persistir(cafe_coco);
		return ResponseEntity.ok(response);		
	}
	
	private void validarDadosExistentes(Cafe_CocoDto cafe_CocoDto, BindingResult result) { //Verifica se esse café em côco já existe no banco de dados
		this.cafe_Coco_Service.buscarPorProdutor(cafe_CocoDto.getProdutor())
		.ifPresent(emp -> result.addError/*Adicionando um erro ao result */(new ObjectError("cafe_Coco", "Este café em Côco já existe!")));
	}
	
	private Cafe_Coco converterDtoParaCafeCoco(Cafe_CocoDto cafe_cocoDto) {
		Cafe_Coco cafe_coco = new Cafe_Coco();
		cafe_coco.setLote(cafe_cocoDto.getLote());
		cafe_coco.setData(cafe_cocoDto.getData());
		cafe_coco.setProdutor(cafe_cocoDto.getProdutor());
		cafe_coco.setQuilos(cafe_cocoDto.getQuilos());
		cafe_coco.setSacos(cafe_cocoDto.getSacos());
		
		return cafe_coco;
	}
}