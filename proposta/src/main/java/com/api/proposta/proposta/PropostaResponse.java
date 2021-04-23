package com.api.proposta.proposta;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.api.proposta.cartao.Cartao;
import com.api.proposta.cartao.CartaoResponse;

public class PropostaResponse {
	
	private String documento;
	private String nome;
	private String email;
	private String endereco;
	private BigDecimal salario;
	private String status;
	private CartaoResponse cartao = null;
	
	public PropostaResponse(Proposta proposta) {
		super();
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.email = proposta.getEmail();
		this.endereco = proposta.getEndereco();
		this.salario = proposta.getSalario();
		this.status = proposta.getStatus().getEstado();
		
		if(proposta.getCartao().isPresent()) {
			Cartao cartaum = proposta.getCartao().get();
			this.cartao = new CartaoResponse(cartaum.getNumero()
					,cartaum.getTitular()
					,cartaum.getLimite(),
					cartaum.getEmitidoEm().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		}
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public String getStatus() {
		return status;
	}

	public CartaoResponse getCartao() {
		return cartao;
	}
	
	
	
	
	
	
}
