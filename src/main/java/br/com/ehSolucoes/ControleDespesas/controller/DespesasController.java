package br.com.ehSolucoes.ControleDespesas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ehSolucoes.ControleDespesas.model.Despesa;

@Controller
@RequestMapping("/despesas")
public class DespesasController {
	
	@RequestMapping
	public ModelAndView pesquisar(){
		ModelAndView mv = new ModelAndView("Listar");
		return mv;
	}
	
	@RequestMapping("/nova")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("NovaDespesa");
		mv.addObject(new Despesa());
		return mv;
	}
	
}
