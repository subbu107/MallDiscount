package com.sg.mall.model;

public class Product {
	
	
	
	private Brand brand;
	
	private Category category;

	private Double basePrice;
	
	
	public Product( Brand brand, Category category, Double basePrice) {
		super();
		
		if( brand == null || category ==null)
			throw new RuntimeException("Cannot create product without brand & category");
		this.brand = brand;
		this.category = category;
		this.basePrice = basePrice;
	}
	
	
	public Double calculateDiscount() {
		Double categoryDiscount = category.getMaxDiscount();
		return categoryDiscount > brand.getDiscount() ? categoryDiscount : brand.getDiscount();
	}
	
	public Double getDiscountedPrice() {
		Double discountedPrice = basePrice - (basePrice * calculateDiscount()/100);
		System.out.println(" "+brand.getName()+ " "+discountedPrice.toString());
		return basePrice - (basePrice * calculateDiscount()/100);
	}
	
}
