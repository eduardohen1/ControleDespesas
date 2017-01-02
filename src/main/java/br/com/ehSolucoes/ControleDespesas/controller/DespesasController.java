package br.com.ehSolucoes.ControleDespesas.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ehSolucoes.ControleDespesas.Funcoes;
import br.com.ehSolucoes.ControleDespesas.model.Cartao;
import br.com.ehSolucoes.ControleDespesas.model.Despesa;
import br.com.ehSolucoes.ControleDespesas.model.DespesaCartao;
import br.com.ehSolucoes.ControleDespesas.model.Operador;
import br.com.ehSolucoes.ControleDespesas.model.Situacao;
import br.com.ehSolucoes.ControleDespesas.service.CadastroCartaoService;
import br.com.ehSolucoes.ControleDespesas.service.CadastroDespesasService;
import br.com.ehSolucoes.ControleDespesas.service.CadastroOperadorService;

@Controller
@RequestMapping("/despesas")
public class DespesasController {
	
	@Autowired
	private CadastroOperadorService cadastroOperadorService;
	@Autowired
	private CadastroDespesasService cadastroDespesaService;
	@Autowired
	private CadastroCartaoService cadastroCartaoService;
	
	private DespesaCartao d; 
	
	@RequestMapping
	public ModelAndView pesquisar(){		
		//buscar dados do operador
		Funcoes funcoes = new Funcoes();
		try{
			Operador operador = cadastroOperadorService.buscarOperador(new Long(1));
			List<DespesaCartao> listDespesa = new ArrayList<>();			
			List<Despesa> listDespesas = cadastroDespesaService.buscaDespesasOperador(operador.getCodigo(), Situacao.EM_ABERTO);
			for (Despesa despesa : listDespesas) {
				DespesaCartao despesaCartao = new DespesaCartao();
				despesaCartao.setCodigo(despesa.getCodigo());
				despesaCartao.setCodigoCartao(despesa.getCodigoCartao());
				despesaCartao.setCodigoOperador(despesa.getCodigoOperador());
				despesaCartao.setDataDespesa(despesa.getDataDespesa());
				despesaCartao.setDataVencimento(despesa.getDataVencimento());
				despesaCartao.setDescricao(despesa.getDescricao());
				despesaCartao.setParcelaList(despesa.getParcelaList());
				despesaCartao.setQteParcelas(despesa.getQteParcelas());
				despesaCartao.setSituacao(despesa.getSituacao());
				despesaCartao.setTipoDespesa(despesa.getTipoDespesa());
				despesaCartao.setValor(despesa.getValor());
				String dtVenc = "";
				if(despesa.getCodigoCartao() > 0){
					Cartao cartao = cadastroCartaoService.buscaCartao(despesa.getCodigoCartao());
					despesaCartao.setNomeCartao(cartao.getDescricao());
					dtVenc = String.format("%02d",cartao.getDiaVencimento()) + "/" + String.format("%02d", 10) + "/" + String.format("%04d",2017);
				}else{
					despesaCartao.setNomeCartao("-");
					dtVenc = String.format("%02d",1) + "/" + String.format("%02d", 1) + "/" + String.format("%04d",2017);
				}
				despesaCartao.setVencimento(funcoes.formataData(dtVenc));
				listDespesa.add(despesaCartao);
			}
			ModelAndView mv = new ModelAndView("Listar");
			mv.addObject("operador", operador);
			mv.addObject("listDespesa", listDespesa);
			return mv;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro: " + e.getMessage());
			return new ModelAndView("Erro");
		}
	}
	
	@RequestMapping("/nova")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("NovaDespesa");
		mv.addObject(new Despesa());
		return mv;
	}
	
}
