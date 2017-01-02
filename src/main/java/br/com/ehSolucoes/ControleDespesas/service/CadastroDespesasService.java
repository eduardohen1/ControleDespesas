package br.com.ehSolucoes.ControleDespesas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehSolucoes.ControleDespesas.model.Despesa;
import br.com.ehSolucoes.ControleDespesas.model.Situacao;
import br.com.ehSolucoes.ControleDespesas.repository.Despesas;

@Service
public class CadastroDespesasService {

	@Autowired
	private Despesas despesas;
	
	public List<Despesa> buscaDespesasOperador(Long codigoOperador, Situacao situacao){
		//return despesas.findByCodigoOperador(codigoOperador);
		return despesas.findByCodigoOperadorAndSituacao(codigoOperador, situacao);
	}
	
}
