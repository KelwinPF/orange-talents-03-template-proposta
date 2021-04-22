package com.api.proposta.util;


public enum StatusPropostaEnum {
	NAO_ELEGIVEL("COM_RESTRICAO")
	,ELEGIVEL("SEM_RESTRICAO");
	
	private final String estado;
	
	StatusPropostaEnum(String estado){
		this.estado = estado;
	}
	
	public static StatusPropostaEnum getEnum(String value) {
        for(StatusPropostaEnum t : values()) {
            if(value.equals(t.getEstado())) {
                return t;
            }
        }
        return null;
	}
	
	public String getEstado() {
		return estado;
	}
}
