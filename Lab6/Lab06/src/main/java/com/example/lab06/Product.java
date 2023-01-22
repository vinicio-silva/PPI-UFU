package com.example.lab06;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=3,max=30)
	private String name;	
	
	private Integer quantidade;	
	
	public Product(){};
	
	public Product(String name, Integer quantidade){
		this.name = name;
		this.quantidade = quantidade;
	};
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Integer getQuantidade(){
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade){
		this.quantidade = quantidade;
	}
	
	@Override public String toString(){
		return "User[id=" + id + ",name=" + name + ",quantidade=" + quantidade + ",toString()=" + super.toString() + "]";
	}
	
}

	