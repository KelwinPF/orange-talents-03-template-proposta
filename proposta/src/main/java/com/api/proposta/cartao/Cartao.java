package com.api.proposta.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.api.proposta.biometria.Biometria;

@Entity
@Table(name="cartoes")
public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String numero;
	private LocalDateTime emitidoEm;
	private String titular;
	private BigDecimal limite;
	@OneToMany(mappedBy="cartao",cascade = CascadeType.ALL)
	private List<Biometria> biometrias;
	
	@Deprecated
	public Cartao() {
	}
	
	public Cartao(String numero,LocalDateTime emitidoEm, String titular,BigDecimal limite) {
		super();
		this.numero = numero;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
	}

	public String getNumero() {
		return numero;
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
}
