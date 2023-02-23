package com.minascafe.api.controllers;

import java.security.NoSuchAlgorithmException;

import javax.naming.Binding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.minascafe.api.dtos.Cafe_CocoDto;
import com.minascafe.api.responses.Cafe_CocoResponse;
import com.minascafe.api.services.Cafe_Coco_Service;

import jakarta.validation.Valid;


@RestController//Endpoint (página web) de Controller
@RequestMapping("/api/cadastrar_cafecoco") //Define a url da classe
public class CafeCocoController {
	
	public static final Logger log = LoggerFactory.getLogger(CafeCocoController.class);
	
	@Autowired
	private Cafe_Coco_Service cafe_Coco_Service;

	/**
	 * Cadastra um lote de café em côco no sistema
	 * 
	 * @param cafe_cocoDto
	 * @return ResponseEntity<Response<Cafe_CocoDto>>
	 * @throws NoSuckAlgorithmException
	 */
	
	
	@PostMapping//Verbo Http de cadastro
	public ResponseEntity<Cafe_CocoResponse<Cafe_CocoDto>> cadastrar(@Valid @RequestBody Cafe_CocoDto cafe_cocoDto,//Pega os dados do request e converte em um Dto. @Valid chama a validação que eu criei no Dto.
			BindingResult result) throws NoSuchAlgorithmException{//Exceção da parte de geração de senhas - BindingResult - terá a informação do resultado da validação do Dto.
	  log.info("Cadastrando um café em côco: {}", cafe_cocoDto.toString()); //passa os dados que chegaram via Post Request
	  Cafe_CocoResponse<Cafe_CocoDto> response = new Cafe_CocoResponse<Cafe_CocoDto>(); //Criando uma instância de Cafe_CocoResponse que será utilizadom para 
	  validarDadosExistentes(cafe_cocoDto, result);
	  
		return ResponseEntity.ok(response);		
	}
	
	private void validarDadosExistentes(Cafe_CocoDto cafe_CocoDto, BindingResult result) { //Verifica se esse café em côco já existe no banco de dados
		this.cafe_Coco_Service.buscarPorProdutor(cafe_CocoDto.getProdutor())
		.ifPresent(emp -> result.addError/*Adicionando um erro ao result */(new ObjectError("cafe_Coco", "Este café em Côco já existe!")));
	}
}