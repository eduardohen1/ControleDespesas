package br.com.ehSolucoes.ControleDespesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ehSolucoes.ControleDespesas.model.Operador;

public interface Operadors extends JpaRepository<Operador, Long> {
	public Operador findByLoginAndSenha(String login, String senha);	
}
