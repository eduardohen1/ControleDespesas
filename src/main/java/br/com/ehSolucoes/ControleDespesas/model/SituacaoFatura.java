package br.com.ehSolucoes.ControleDespesas.model;

public enum SituacaoFatura {

	ABERTA("Aberta"),
	FECHADA("Fechada");
	
	private String descricao;

	SituacaoFatura(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
