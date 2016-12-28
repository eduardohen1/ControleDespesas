package br.com.ehSolucoes.ControleDespesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ehSolucoes.ControleDespesas.model.Parcela;

public interface Parcelas extends JpaRepository<Parcela, Long> {

}
