package br.com.bctc.stockmanager.stock.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "stock", schema = "test", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE")
})
public class Stock {

	private Calendar dataCompra;
	private Calendar dataVenda;
	private Integer stockId;
	private String codigo;
	private String desc;
	private float valorAtual;
	private float valorCompra;
	private float valorVenda;
	private int quantidade;

	@Id
	@GeneratedValue
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getStockId() {
		return this.stockId;
	}
	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
	public String getCodigo() {
		return codigo;
	}
	public Calendar getDataCompra() {
		return dataCompra;
	}
	public Calendar getDataVenda() {
		return dataVenda;
	}
	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
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
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
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
