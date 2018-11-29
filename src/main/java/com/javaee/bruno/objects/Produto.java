package com.javaee.bruno.objects;

public class Produto {
	
	private Long id;
	private String nomeProduto;
	private double valorProduto;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public double getValorProduto() {
		return valorProduto;
	}
	
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
}
