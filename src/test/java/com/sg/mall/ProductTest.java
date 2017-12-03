package com.sg.mall;

import org.junit.Assert;
import org.junit.Test;

import com.sg.mall.model.Brand;
import com.sg.mall.model.Category;
import com.sg.mall.model.Product;

public class ProductTest {

	@Test(expected = RuntimeException.class)
	public void ShouldThrowExceptionWhenCreatingProductWithoutCategory() {
		new Product(null, new Category("test", 5d, null), 100d);
	}

	@Test(expected = RuntimeException.class)
	public void ShouldThrowExceptionWhenCreatingProductWithoutBrand() {
		new Product(new Brand("test", 5d), null, 100d);
	}

	@Test
	public void ShouldGetMaxDiscountWhenBrandDiscountHigher() {
		Brand b = new Brand("test", 6d);
		Category c1 = new Category("C1", 5d, null);
		Category c2 = new Category("C2", 4d, c1);
		Category c3 = new Category("C3", 3d, c2);

		Product p = new Product(b, c3, 100d);
		Assert.assertEquals(6d, p.calculateDiscount().doubleValue(), 0);
	}

	@Test
	public void ShouldGetMaxDiscountWhenCategoryDiscountHigher() {
		Brand b = new Brand("test", 3d);
		Category c1 = new Category("C1", 5d, null);
		Category c2 = new Category("C2", 4d, c1);
		Category c3 = new Category("C3", 3d, c2);

		Product p = new Product(b, c3, 100d);
		Assert.assertEquals(5d, p.calculateDiscount().doubleValue(), 0);
	}

}
