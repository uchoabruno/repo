package br.com.bctc.stockmanager.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.bctc.stockmanager.stock.dao.StockDao;
import br.com.bctc.stockmanager.stock.model.Stock;

@Controller
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	Stock stock;

	@Autowired
	StockDao stockDao;

	@Inject
	public StockController(Stock s) {
		System.out.println(s);
	}

	@RequestMapping(method=RequestMethod.GET)
	public String showHomeMessage(Model model) {

		model.addAttribute(new Stock());
		
		stock.setCodigo("PETR3F");
		stock.setDesc("Petrobras");
		stockDao.save(stock);
		
		Stock s = new Stock();
		s.setCodigo("LIGT3F");
		s.setDesc("Light");
		stockDao.save(s);
		
		System.out.println("ID = " + stock.getStockId());
		
		Stock stock2 = stockDao.findByStockCode("PETR3F");
		System.out.println("ID = " + stock2.getStockId());

		System.out.println(stock2.getDesc());
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
