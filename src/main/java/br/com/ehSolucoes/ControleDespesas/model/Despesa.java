package br.com.ehSolucoes.ControleDespesas.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Despesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message="Descrição é obrigatória")
	@Size(max=60, message="A descrição não pode conter mais de 60 caracteres")
	private String descricao;
	
	@NotNull(message= "Data da despesa é obrigatória")
	@DateTimeFormat(pattern="dd/MM/yyyy")	
	@Temporal(TemporalType.DATE)
	private Date dataDespesa;
	
	@NotNull(message="Valor da despesa é obrigatório")
	@DecimalMin(value="0.01", message="Valor não pode ser menor que 0,01")
	@DecimalMax(value="9999999.99", message="Valor não pde ser maior que 9.999.999,99")
	@NumberFormat(pattern="R$ #,##0.00")
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private TipoDespesa tipoDespesa;
	
	@NotNull(message= "Data de vencimento é obrigatória (Caso parcelado, data da primeira parcela)")
	@DateTimeFormat(pattern="dd/MM/yyyy")	
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	private long qteParcelas;
	
	@OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="despesas_parcela",  
              joinColumns={@JoinColumn(name="despesas_codigo", 
               referencedColumnName="codigo")},  
              inverseJoinColumns={@JoinColumn(name="parcela_codigo", 
                referencedColumnName="codigo")})  
    private List<Parcela> parcelaList;
	
	private Long codigoCartao;
	
	@NotEmpty
	private Long codigoOperador;
		
	public Long getCodigoOperador() {
		return codigoOperador;
	}

	public void setCodigoOperador(Long codigoOperador) {
		this.codigoOperador = codigoOperador;
	}

	public Long getCodigoCartao() {
		return codigoCartao;
	}

	public void setCodigoCartao(Long codigoCartao) {		
		this.codigoCartao = codigoCartao;
	}

	public List<Parcela> getParcelaList() {
		return parcelaList;
	}

	public void setParcelaList(List<Parcela> parcelaList) {
		this.parcelaList = parcelaList;
	}

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

	public Date getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(Date dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public long getQteParcelas() {
		return qteParcelas;
	}

	public void setQteParcelas(long qteParcelas) {
		this.qteParcelas = qteParcelas;
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
		Despesa other = (Despesa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}