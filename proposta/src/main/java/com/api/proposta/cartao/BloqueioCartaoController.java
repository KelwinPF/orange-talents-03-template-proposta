package com.api.proposta.cartao;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.proposta.util.StatusCartaoEnum;


@RestController
@RequestMapping("/cartoes")
public class BloqueioCartaoController {
	
	private BloqueioCartaoRepository bloqueioRepository;
	private CartaoRepository cartaoRepository;
	private ConsultaCartao consultacartao;
	
	public BloqueioCartaoController(BloqueioCartaoRepository bloqueioRepository,
			CartaoRepository cartaoRepository,
			ConsultaCartao consultacartao) {
		this.bloqueioRepository = bloqueioRepository;
		this.cartaoRepository = cartaoRepository;
		this.consultacartao = consultacartao;
	}
	
	@PostMapping(value = "/{id}/bloquear")
	public ResponseEntity<?> bloquear(@PathVariable(name = "id", required = true) Long id,
			@RequestHeader("User-Agent") String userAgent,HttpServletRequest request){
		Optional<Cartao> card = cartaoRepository.findById(id);
		
		if(card.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		if(card.get().getStatus().equals(StatusCartaoEnum.BLOQUEADO)) {
			return ResponseEntity.unprocessableEntity().build();
		}
			
		try {
			consultacartao.bloqueio(card.get().getNumero(),new BloqueioRequest("proposta"));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}	
		
		bloqueiaCartao(card.get(),userAgent,request.getRemoteAddr());
		
		return ResponseEntity.ok().build();
	}
	
	private void bloqueiaCartao(Cartao cartao,String userAgent,String request) {		
		BloqueioCartao bloqueio = new BloqueioCartao(request,userAgent,cartao);
		bloqueioRepository.save(bloqueio);
		
		cartao.bloquear(StatusCartaoEnum.BLOQUEADO);
		cartaoRepository.save(cartao);
	}
	
}
