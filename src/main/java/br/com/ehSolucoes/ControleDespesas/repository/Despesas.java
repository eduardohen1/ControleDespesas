package br.com.ehSolucoes.ControleDespesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ehSolucoes.ControleDespesas.model.Despesa;

public interface Despesas extends JpaRepository<Despesa, Long> {

}
