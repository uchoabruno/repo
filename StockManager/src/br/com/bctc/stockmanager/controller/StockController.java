package br.com.bctc.stockmanager.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.bctc.stockmanager.model.Stock;

@Controller
@RequestMapping("/stocks")
public class StockController {


	@Inject
	public StockController(Stock s) {
		System.out.println(s);
	}

	@RequestMapping(method=RequestMethod.GET)
	public String showHomeMessage(Model model) {

		model.addAttribute(new Stock());

		return "acoes";
	}

	/**
	 * Método que vai adicionar uma ação à carteira
	 * @param stock
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String addStock(Stock stock, Model model) {

		return "resultados";
	}

}
