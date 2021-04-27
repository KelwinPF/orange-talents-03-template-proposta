package com.api.proposta.biometria;

import java.time.LocalDateTime;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.api.proposta.cartao.Cartao;

@Entity
@Table(name="biometrias")
public class Biometria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Lob
	@Column(nullable=false)
	private String fingerprint;
	@CreationTimestamp
	private LocalDateTime instante;
	@ManyToOne
	private Cartao cartao;
	
	public Biometria(String fingerprint, Cartao cartao) {
		super();
		this.fingerprint = fingerprint;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}
	
	@Deprecated
	public Biometria() {
	}
	
	
}
