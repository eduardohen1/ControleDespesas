package br.com.ehSolucoes.ControleDespesas.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;

@Entity
public class MesFaturaCartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@NotEmpty(message="Referência é obrigatória")
	@Size(max=6, message="A refereência deve conter 6 caracteres (ano + mês [aaaamm])")
	private String referencia;
	
	@Enumerated(EnumType.STRING)
	private SituacaoFatura situacao;
	
	@NotEmpty(message="Selecione o cartão")
	@Value("0")
	private int codigoCartao;
	
	public int getCodigoCartao() {
		return codigoCartao;
	}

	public void setCartao(int codigoCartao) {
		this.codigoCartao = codigoCartao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public SituacaoFatura getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoFatura situacao) {
		this.situacao = situacao;
	}
	
	
}
