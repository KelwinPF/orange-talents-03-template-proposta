package com.api.proposta.cartao;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="bloqueios_cartao")
public class BloqueioCartao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	private LocalDateTime instante;
	@Column(nullable=false)
	private String ip;
	@Column(nullable=false)
	private String user_agent;
	@ManyToOne
	private Cartao cartao;
	
	public BloqueioCartao(String ip, String user_agent, Cartao cartao) {
		super();
		this.ip = ip;
		this.user_agent = user_agent;
		this.cartao = cartao;
	}
	
	
	
	
}
