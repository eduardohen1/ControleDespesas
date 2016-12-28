package br.com.ehSolucoes.ControleDespesas.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "Descrição é obrigatória")
	@Size(max=60, message = "A descrição não pode conter mais de 60 caracteres")
	private String descricao;
	
	@NotNull(message="Dia do vencimento é obrigatório")
	@NumberFormat(pattern="##")
	private int DiaVencimento;
	
	@NotNull(message = "Valor do limite 1 é obrigatório")
	@DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
	@NumberFormat(pattern="R$ #,##0.00")
	private BigDecimal vrLimite01;
	
	@NotNull(message = "Valor do limite 2 é obrigatório")
	@DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
	@NumberFormat(pattern="R$ #,##0.00")
	private BigDecimal vrLimite02;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDiaVencimento() {
		return DiaVencimento;
	}

	public void setDiaVencimento(int diaVencimento) {
		DiaVencimento = diaVencimento;
	}

	public BigDecimal getVrLimite01() {
		return vrLimite01;
	}

	public void setVrLimite01(BigDecimal vrLimite01) {
		this.vrLimite01 = vrLimite01;
	}

	public BigDecimal getVrLimite02() {
		return vrLimite02;
	}

	public void setVrLimite02(BigDecimal vrLimite02) {
		this.vrLimite02 = vrLimite02;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
