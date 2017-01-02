package br.com.ehSolucoes.ControleDespesas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehSolucoes.ControleDespesas.model.Cartao;
import br.com.ehSolucoes.ControleDespesas.repository.Cartoes;

@Service
public class CadastroCartaoService {
	
	@Autowired
	private Cartoes cartoes;
	
	public Cartao buscaCartao(Long codigo){
		return cartoes.findOne(codigo);
	}
	
	public List<Cartao> todosCartoes(){
		return cartoes.findAll();
	}
	
}
