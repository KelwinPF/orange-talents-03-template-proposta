package com.api.proposta.proposta;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
	private PropostaRepository propostaRepository;
	
	public PropostaController(PropostaRepository proposta) {
		this.propostaRepository = proposta;
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@Valid @RequestBody PropostaRequest request,UriComponentsBuilder uriComponentsBuilder){
		
		Proposta proposta = propostaRepository.save(request.convert());
		URI uri = uriComponentsBuilder.path("/propostas/{id}")
                .buildAndExpand(proposta.getId())
                .toUri();
		return ResponseEntity.created(uri).build();
	}
}
