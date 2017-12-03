package com.sg.mall.model;

public class Brand {
	
	private String name;
	
	private Double discount;

	
	
	public Brand(String name, Double discount) {
		super();
		this.name = name;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Brand [name=" + name + ", discount=" + discount + "]";
	}
	
}
