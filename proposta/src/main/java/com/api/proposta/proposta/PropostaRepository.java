package com.api.proposta.proposta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.proposta.util.StatusPropostaEnum;

public interface PropostaRepository extends JpaRepository<Proposta,Long>{

	boolean existsByDocumento(String documento);

	List<Proposta> findAllByStatusAndCartaoIsNull(StatusPropostaEnum elegivel);
	
}
