package com.api.proposta.biometria;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.proposta.cartao.Cartao;
import com.api.proposta.cartao.CartaoRepository;


@RestController
@RequestMapping("/biometrias")
public class BiometriaController {
	private BiometriaRepository biometriaRepository;
	private CartaoRepository cartaoRepository;
	public BiometriaController(BiometriaRepository biometriaRepository,CartaoRepository cartaoRepository) {
		this.biometriaRepository = biometriaRepository;
		this.cartaoRepository = cartaoRepository;
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<?> cadastrar(@Valid @RequestBody BiometriaRequest request,
			@PathVariable(name = "id", required = true) String id){
		Optional<Cartao> cartao = cartaoRepository.findByNumero(id);
		if(cartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Biometria bio = biometriaRepository.save(request.convert(cartao.get()));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(bio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
