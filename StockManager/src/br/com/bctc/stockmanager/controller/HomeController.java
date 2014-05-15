package br.com.bctc.stockmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(method=RequestMethod.GET, value={"/"})
	public String showHomeMessage(Model model) {

		System.out.println("teste");
		model.addAttribute("");

		return "redirect:/conferidor";
	}

}
