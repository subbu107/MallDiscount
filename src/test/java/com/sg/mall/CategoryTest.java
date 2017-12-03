package com.sg.mall;

import org.junit.Test;

import com.sg.mall.model.Category;

import org.junit.Assert;


public class CategoryTest {

	@Test
	public void shouldGetMaxDiscountWhenMaxIsTopParentInChain() {
		
		Category c1 = new Category("C1", 5d, null);
		Category c2 = new Category("C2", 4d, c1);
		Category c3 = new Category("C3", 3d, c2);
		
		Assert.assertEquals(5d, c3.getMaxDiscount().doubleValue(), 0);
		
	}
	
	@Test
	public void shouldGetMaxDiscountWhenMaxIsSelf() {
		
		Category c1 = new Category("C1", 2d, null);
		Category c2 = new Category("C2", 4d, c1);
		Category c3 = new Category("C3", 6d, c2);
		
		Assert.assertEquals(6d, c3.getMaxDiscount().doubleValue(), 0);
		
	}
	
	@Test
	public void shouldGetMaxDiscountWhenSomeDiscountsZero() {
		
		Category c1 = new Category("C1", 5d, null);
		Category c2 = new Category("C2", 0d, c1);
		Category c3 = new Category("C3", 3d, c2);
		
		Assert.assertEquals(5d, c3.getMaxDiscount().doubleValue(), 0);
		
	}
	
	
	

}
