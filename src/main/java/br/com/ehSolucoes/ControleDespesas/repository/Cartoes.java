package br.com.ehSolucoes.ControleDespesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ehSolucoes.ControleDespesas.model.Cartao;

public interface Cartoes extends JpaRepository<Cartao, Long> {
	
}
