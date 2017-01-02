package br.com.ehSolucoes.ControleDespesas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehSolucoes.ControleDespesas.model.Operador;
import br.com.ehSolucoes.ControleDespesas.repository.Operadors;

@Service
public class CadastroOperadorService {
	
	@Autowired
	private Operadors operadors;
	
	public Operador buscaOperadorLogin(String login, String senha){
		return operadors.findByLoginAndSenha(login, senha);
	}
	
	/**
	 * Serviço para buscar o objeto Operador mediante o código dele
	 * @param codigo Código do operador para pesquisa
	 * @return Retorna objeto Operador
	 */
	public Operador buscarOperador(Long codigo){
		return operadors.findOne(codigo);
	}
	
}
