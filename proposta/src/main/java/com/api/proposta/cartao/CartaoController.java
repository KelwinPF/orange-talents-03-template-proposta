package com.api.proposta.cartao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.proposta.proposta.Proposta;
import com.api.proposta.proposta.PropostaRepository;
import com.api.proposta.util.StatusPropostaEnum;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
	
	private CartaoRepository cartaoRepository;
	private PropostaRepository propostaRepository;
	private ConsultaCartao consultacartao;
	
	public CartaoController(CartaoRepository cartaoRepository,PropostaRepository propostaRepository,
			ConsultaCartao consultacartao) {
		this.cartaoRepository = cartaoRepository;
		this.propostaRepository = propostaRepository;
		this.consultacartao = consultacartao;
	}
	
	@Scheduled(cron = "0 0 23 * * *", zone = "America/Sao_Paulo")
	private void verificacao() {
		List<Proposta> propostas = propostaRepository.findAllByStatusAndCartaoIsNull(
				StatusPropostaEnum.ELEGIVEL);
		propostas.forEach(proposta->verificaProposta(proposta));
	}
	
	@Transactional
	private void verificaProposta(Proposta proposta) {
		try {
			ConsultaCartaoResponse consulta = consultacartao.consulta(
					new ConsultaCartaoRequest(proposta.getId().toString(),
							proposta.getNome(),proposta.getDocumento()));
			Cartao cartao = cartaoRepository.save(
					new Cartao(consulta.getId(),consulta.getEmitidoEm(),consulta.getTitular(),consulta.getLimite()
							));
			proposta.addCartao(cartao);
			propostaRepository.save(proposta);
		}catch(Exception e) {
			
		}
	}
	
}
