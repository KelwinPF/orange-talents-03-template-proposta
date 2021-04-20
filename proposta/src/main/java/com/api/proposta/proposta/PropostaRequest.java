package com.api.proposta.proposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.api.proposta.configuracao.VerifyDocument;

public class PropostaRequest {
	
	@NotBlank
	@VerifyDocument
	private String documento;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String endereco;
	@Positive
	@NotNull
	private BigDecimal salario;
	
	public PropostaRequest(@NotBlank String documento, @Email @NotBlank String email, @NotBlank String nome,
			@NotBlank String endereco, @Positive @NotNull BigDecimal salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Proposta convert() {
		return new Proposta(documento, email, nome, endereco, salario);
	}

	public String getDocumento() {
		return documento;
	}
	
	
}
