package br.com.bctc.calculadora.juridica.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerTest {
	
	Controller controller = new Controller();

	@Test
	public void test() {
		assertEquals(11295.17, controller.atualizaValorCausa(10900l, (long) 46.007257, (long) 47.675238));
	}

}
