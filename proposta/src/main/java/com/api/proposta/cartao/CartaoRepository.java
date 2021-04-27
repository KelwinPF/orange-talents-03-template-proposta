package com.api.proposta.cartao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao,Long>{

	Optional<Cartao> findByNumero(String id);

}
