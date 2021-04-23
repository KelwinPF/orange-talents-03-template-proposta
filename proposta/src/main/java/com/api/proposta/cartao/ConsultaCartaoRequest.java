package com.api.proposta.cartao;

public class ConsultaCartaoRequest {
	private String idProposta;
	private String nome;
	private String documento;
	
	public String getIdProposta() {
		return idProposta;
	}

	public String getNome() {
		return nome;
	}

	public String getDocumento() {
		return documento;
	}

	public ConsultaCartaoRequest(String idProposta,String nome,String documento) {
		super();
		this.idProposta = idProposta;
		this.nome=nome;
		this.documento = documento;
	}
	
	
}
