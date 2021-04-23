package com.api.proposta.proposta;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.proposta.configuracao.ErroDeFormularioDTO;
import com.api.proposta.util.StatusPropostaEnum;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
	
	private PropostaRepository propostaRepository;
	private ConsultaDados consultadados;
	
	public PropostaController(PropostaRepository proposta,ConsultaDados consultadados) {
		this.propostaRepository = proposta;
		this.consultadados = consultadados;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@Valid @RequestBody PropostaRequest request,UriComponentsBuilder uriComponentsBuilder){

		if(propostaRepository.existsByDocumento(request.getDocumento())) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body(new ErroDeFormularioDTO("documento","Já existe proposta com este documento"));
		}
		Proposta proposta = propostaRepository.save(request.convert());
		validar(proposta);
		URI uri = uriComponentsBuilder.path("/propostas/{id}")
                .buildAndExpand(proposta.getId())
                .toUri();
		return ResponseEntity.created(uri).build();
	}
	
	private Proposta validar(Proposta proposta) {
		ConsultaDadosRequest request = new ConsultaDadosRequest(proposta.getDocumento()
				, proposta.getNome(), proposta.getId());
		try {
			ConsultaDadosResponse r = consultadados.create(request);
			proposta.Eligibilidade(StatusPropostaEnum.getEnum(r.getResultadoSolicitacao()));
		}catch(Exception e) {
		}
		return propostaRepository.save(proposta);
	}

}
