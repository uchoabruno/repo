package br.com.bctc.calculadora.juridica.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerTest {
	
	Controller controller = new Controller();

	@Test
	public void test() {		
		assertEquals("Valor errado!", 11295.17, controller.atualizaValorCausa(10900, 46.007257, 47.675238), 0.01);
		assertEquals("Valor errado!", 338.85, controller.getValorPreparo(controller.atualizaValorCausa(10900, 46.007257, 47.675238)), 0.01);
		controller.format(controller.atualizaValorCausa(10900, 46.007257, 47.675238));
		controller.format(controller.getValorPreparo(controller.atualizaValorCausa(10900, 46.007257, 47.675238)));
	}

}
