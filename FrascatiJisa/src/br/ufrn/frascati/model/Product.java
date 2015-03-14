package br.ufrn.frascati.model;

public class Product {
	private String productName;
	private Double value;
	
	public Product(){
		
	}
	
	public Product(String productName,Double value){
		this.productName=productName;
		this.value=value;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
}
