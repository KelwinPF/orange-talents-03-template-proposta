package com.api.proposta.proposta;

public class ConsultaDadosRequest {
	private String documento;
	private String nome;
	private String idProposta;
	
	
	public ConsultaDadosRequest(String documento,String nome,Long idProposta) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta.toString();
	}


	public String getDocumento() {
		return documento;
	}


	public String getNome() {
		return nome;
	}


	public String getIdProposta() {
		return idProposta;
	}
	
	
}
