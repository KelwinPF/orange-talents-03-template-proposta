package com.api.proposta.proposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="ConsultaDados",url="http://${consulta.dados}/")
public interface ConsultaDados {
	@PostMapping(value = "/api/solicitacao",consumes = "application/json")
	ConsultaDadosResponse create(ConsultaDadosRequest request);
}
