package br.com.ehSolucoes.ControleDespesas.model;

public enum TipoDespesa {
	A_VISTA("A vista"),
	PARCELADO("Parcelado"),
	A_VISTA_CARTAO("A vista no cartão"),
	PARCELADO_CARTAO("Parcelado no cartão");
	
	private String descricao;
	
	TipoDespesa(String descricao){
		this.descricao = descricao;		
	}
	
	public String getDescricao(){
		return descricao;
	}
	
}