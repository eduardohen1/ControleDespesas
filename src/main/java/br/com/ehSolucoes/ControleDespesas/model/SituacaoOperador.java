package br.com.ehSolucoes.ControleDespesas.model;

public enum SituacaoOperador {

	ATIVO("Ativo"),
	SUSPENSO("Suspenso"),
	CANCELADO("Cancelado");
	
	private String descricao;

	SituacaoOperador(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
