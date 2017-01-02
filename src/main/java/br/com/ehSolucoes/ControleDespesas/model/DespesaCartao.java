package br.com.ehSolucoes.ControleDespesas.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DespesaCartao extends Despesa {
	private String nomeCartao;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date vencimento;
	public String getNomeCartao() {
		return nomeCartao;
	}
	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	
}
