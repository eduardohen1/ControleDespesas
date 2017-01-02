package br.com.ehSolucoes.ControleDespesas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ehSolucoes.ControleDespesas.model.Despesa;
import br.com.ehSolucoes.ControleDespesas.model.Situacao;

public interface Despesas extends JpaRepository<Despesa, Long> {	
	public List<Despesa> findByCodigoOperador(Long codigoOperador);
	
	public List<Despesa> findByCodigoOperadorAndSituacao(Long codigoOperador, Situacao situacao);
	
}
