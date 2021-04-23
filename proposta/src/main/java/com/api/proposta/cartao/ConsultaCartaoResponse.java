package com.api.proposta.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConsultaCartaoResponse {
	private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private BigDecimal limite;
    private String idProposta;
    
	public String getId() {
		return id;
	}

	public ConsultaCartaoResponse(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite,
			String idProposta) {
		super();
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.idProposta = idProposta;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public String getIdProposta() {
		return idProposta;
	}

	
	
	
}
