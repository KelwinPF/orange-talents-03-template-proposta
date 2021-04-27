package com.api.proposta.biometria;

import javax.validation.constraints.NotEmpty;

import com.api.proposta.cartao.Cartao;
import com.api.proposta.configuracao.IsBase64;

public class BiometriaRequest {
	@NotEmpty
	@IsBase64
	private String fingerprint;

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
	public Biometria convert(Cartao cartao) {
		return new Biometria(fingerprint,cartao);
	}
}
