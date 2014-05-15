package br.com.bctc.stockmanager.model;

import java.util.Calendar;

public class Stock {

	private String codigo;
	private Calendar dataCompra;
	private Calendar dataVenda;
	private String desc;
	private int quantidade;
	private float valorAtual;
	private float valorCompra;
	private float valorVenda;


	public String getCodigo() {
		return codigo;
	}
	public Calendar getDataCompra() {
		return dataCompra;
	}
	public Calendar getDataVenda() {
		return dataVenda;
	}
	public String getDesc() {
		return desc;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public float getValorAtual() {
		return valorAtual;
	}
	public float getValorCompra() {
		return valorCompra;
	}
	public float getValorVenda() {
		return valorVenda;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}
	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setValorAtual(float valorAtual) {
		this.valorAtual = valorAtual;
	}
	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}
	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}

	public void valorAtualUp() {
		setValorAtual(valorAtual+0.01f);
	}

	public void valorAtualDown() {
		setValorAtual(valorAtual-0.01f);
	}

}
