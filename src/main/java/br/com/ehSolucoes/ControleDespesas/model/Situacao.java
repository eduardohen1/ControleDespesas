package br.com.ehSolucoes.ControleDespesas.model;

public enum Situacao {
	
	EM_ABERTO("Em aberto"),
	PAGO("Pago");
	
	private String descricao;

	Situacao(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}