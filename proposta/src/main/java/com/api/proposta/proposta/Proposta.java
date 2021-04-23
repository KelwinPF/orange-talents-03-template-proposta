package com.api.proposta.proposta;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.api.proposta.cartao.Cartao;
import com.api.proposta.util.StatusPropostaEnum;

@Entity
@Table(name="propostas")
public class Proposta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false,unique = true)
	private String documento;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String endereco;
	@Column(nullable=false,scale = 2)
	private BigDecimal salario;
	@Enumerated(EnumType.STRING)
	private StatusPropostaEnum status;
	@OneToOne
	private Cartao cartao;
	
	public Proposta() {
	}
	
	public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario,StatusPropostaEnum status) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public StatusPropostaEnum getStatus() {
		return status;
	}
	
	public void Eligibilidade(StatusPropostaEnum eligibilidade) {
		this.status = eligibilidade;
	}
	
	public void addCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	
	
}
