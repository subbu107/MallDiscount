package com.sg.mall;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sg.mall.model.Brand;
import com.sg.mall.model.Category;

@Service
public class Context {

	private Map<String, Category> categories = new HashMap<>();
	private Map<String, Brand> brands = new HashMap<>();
	
	public Context() {
		setup();
	}
	
	public void setup() {
		categories.put("Mens Wear", new Category("Mens Wear", 0d, null)) ;
		categories.put("Shirts", new Category("Shirts", 0d,categories.get("Mens Wear")));
		categories.put("Trousers", new Category("Trousers", 0d,categories.get("Mens Wear")));
		categories.put("Casuals", new Category("Casuals", 30d,categories.get("Trousers")));
		categories.put("Jeans", new Category("Jeans",20d,categories.get("Trousers")));
		
		categories.put("Women's Wear", new Category("Womens Wear", 50d, null)) ;
		categories.put("Dresses", new Category("Dresses", 0d,categories.get("Women's Wear")));
		categories.put("Footwear", new Category("Footwear", 0d,categories.get("Women's Wear")));
				
		brands.put("Wrangler", new Brand("Wrangler", 10d));
		brands.put("Arrow", new Brand("Arrow", 20d));
		brands.put("Vera Moda", new Brand("Vera Moda", 60d));
		brands.put("UCB", new Brand("UCB", 0d));
		brands.put("Adidas", new Brand("Adidas", 5d));
		brands.put("Provogue", new Brand("Provogue", 20d));
		
	}
	
	public Category getCategory(String name) {
		return categories.get(name);
	}
	
	public Brand getBrand(String name) {
		return brands.get(name);
	}
}
