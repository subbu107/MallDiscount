package com.sg.mall.model;

public class Category {

	private String name;
	
	private Double discount=0d;
	
	private Category parent;

	
	
	public Category(String name, Double discount, Category parent) {
		super();
		
		
		this.name = name;
		this.discount = discount;
		this.parent = parent;
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

	public Double getMaxDiscount() {
		Category category = this;
		Double maxDiscount = category.discount;
		while(category.getParent() != null) {
			category = category.parent;
			maxDiscount = (category.discount > maxDiscount) ? category.discount : maxDiscount;
		}
		return maxDiscount;
	}
	
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", discount=" + discount + ", parent=" + parent + "]";
	}
	
	
}
