package br.com.bctc.calculadora.juridica.controller;

import java.text.NumberFormat;

public class Controller {

	public String atualizaValorCausa(long valorCausa, double indiceDistribuicao, double indiceAtual) {

		return format(valorCausa/indiceDistribuicao*indiceAtual);
	}
	
	public double getValorPreparo(double valorCausaAtualizado) {
		
		return 0.03*valorCausaAtualizado;
	}
	
	public String format(double valor) {

		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setMaximumFractionDigits(2);

		//TODO Remover syso.
		//TODO Ver com a Talita se é pra truncar ou arrendondar os valores dos cálculos.
		System.out.println(Math.floor(valor*100)/100);
		System.out.println("Valor formatado: " + nf.format(valor));
		System.out.println("Valor bruto: " + valor);

		return nf.format(valor);
	}
}
