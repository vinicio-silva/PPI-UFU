package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private Integer quantidade;
	private Float preco;
	
	public Long getId() {
	    return id;
	}
	public void setId(Long id) {
	    this.id = id;
	}
	public String getName() {
	    return name;
	}
	public void setName(String name) {
	    this.name = name;
	}
	public Integer getQuantidade() {
	    return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
	    this.quantidade = quantidade;
	}
	public Float getPreco() {
	    return preco;
	}
	public void setPreco(Float preco) {
	    this.preco = preco;
	}
	@Override
	public String toString() {
	    return "Produto [id=" + id + ", name=" + name + ", quantidade=" + quantidade + ", preco=" + preco + ",toString()=" + super.toString() + "]";
	}
}