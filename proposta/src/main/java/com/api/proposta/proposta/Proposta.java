package com.api.proposta.proposta;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="propostas")
public class Proposta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String documento;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String endereco;
	@Column(nullable=false,scale = 2)
	private BigDecimal salario;
	
	public Proposta() {
	}
	
	public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
}
