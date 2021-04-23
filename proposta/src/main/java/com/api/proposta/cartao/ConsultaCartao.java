package com.api.proposta.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ConsultaCartao",url="http://localhost:8888/")
public interface ConsultaCartao {
	
	@PostMapping(value = "/api/cartoes",consumes = "application/json")
	ConsultaCartaoResponse consulta(ConsultaCartaoRequest request);
}
	