package com.api.proposta.cartao;

import java.math.BigDecimal;

public class CartaoResponse {
	private String numero;
	private String titular;
	private BigDecimal limite;
	private String emitido_em;
	
	public CartaoResponse(String numero, String titular, BigDecimal limite, String emitido_em) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.limite = limite;
		this.emitido_em = emitido_em;
	}

	public String getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public String getEmitido_em() {
		return emitido_em;
	}
	
	
	
	
}
