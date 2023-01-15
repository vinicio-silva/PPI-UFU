package com.example.demo;

public class CDomainClass {
	private String produto;
	private Integer qtd;
	
	public String getProduto() {
	    return produto;
	}
	public void setProduto(String produto) {
	    this.produto = produto;
	}
	public Integer getQtd() {
	    return qtd;
	}
	public void setQtd(Integer qtd) {
	    this.qtd = qtd;
	}
	
	@Override
	public String toString() {
	    return "User [Produto=" + produto + ", quantidade=" + qtd + ",toString()=" + super.toString() + "]";
	}
	}
