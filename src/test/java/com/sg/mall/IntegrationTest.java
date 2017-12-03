package com.sg.mall;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sg.mall.model.Product;

public class IntegrationTest {

	@Test
	public void test() {
		Context context = new Context();
		context.setup();
		
		Product p1 = new Product(context.getBrand("Arrow"), context.getCategory("Shirts"), 800d);
		Product p2 = new Product(context.getBrand("Vera Moda"), context.getCategory("Dresses"), 1400d);
		Product p3 = new Product(context.getBrand("Provogue"), context.getCategory("Footwear"), 1800d);
		Product p4 = new Product(context.getBrand("Wrangler"), context.getCategory("Jeans"), 2200d);
		Product p5 = new Product(context.getBrand("UCB"), context.getCategory("Shirts"), 1500d);
		
		
		List<Product> cust1Products = new ArrayList<>();
		cust1Products.add(p1);
		cust1Products.add(p2);
		cust1Products.add(p3);
		cust1Products.add(p4);
		
		
		List<Product> cust2Products = new ArrayList<>();
		cust2Products.add(p1);		
		cust2Products.add(p5);
		
		Assert.assertEquals(3860d, calculateCustomerTotal(cust1Products), 0);
		Assert.assertEquals(2140d, calculateCustomerTotal(cust2Products),0);
	}
	
	private Double calculateCustomerTotal(List<Product> products) {
		Double total = 0d;
		for(Product p : products) {
			total += p.getDiscountedPrice();
		}
		
		return total;
	}

}
