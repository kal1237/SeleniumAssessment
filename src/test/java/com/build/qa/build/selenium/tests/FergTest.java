package com.build.qa.build.selenium.tests;

import org.junit.Assert;
import org.junit.Test;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.BathroomSinkFaucets;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;
import com.build.qa.build.selenium.pageobjects.homepage.ProductNameCheck;
import com.build.qa.build.selenium.pageobjects.homepage.AddMultipleCartItems;

public class FergTest extends BaseFramework {

	/**
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 * @throws InterruptedException 
	 */
	@Test
	public void navigateToHomePage() {
		driver.get(getConfiguration("HOMEPAGE"));
		driver.manage().window().maximize();

		HomePage homePage = new HomePage(driver, wait);

		Assert.assertTrue(homePage.onHomePage());
		System.out.println("The website should load up with the Build.com desktop theme.");

		//softly.assertThat(homePage.onHomePage()).as("The website should load up with the Build.com desktop theme.").isTrue();
	}

	/**
	 * Search for the Moen m6702bn from the search bar
	 * @throws InterruptedException 
	 * @assert: That the product page we land on is what is expected by checking the product brand and product id
	 * @difficulty Easy
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() throws InterruptedException {
		// TODO: Implement this test
		driver.get(getConfiguration("HOMEPAGE"));
		driver.manage().window().maximize();
		ProductNameCheck product=new ProductNameCheck(driver,wait);
		boolean flag1=product.searchText();
		boolean flag2=product.fetchProductBrand();
		boolean flag3=product.fetchProductID();

		Assert.assertTrue(flag1&&flag2&&flag3);
		System.out.println("The Product page is as expected and details are as expected");

	}

	/**
	 * Go to the Bathroom Sinks category directly
	 * (https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3)
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @throws InterruptedException 
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	
	@Test
	public void addProductToCartFromCategoryDrop() throws InterruptedException {
		// TODO: Implement this test
		driver.get(getConfiguration("HOMEPAGE1"));
		driver.manage().window().maximize();
		BathroomSinkFaucets bsf=new BathroomSinkFaucets(driver,wait);
		boolean flag1=bsf.productSelectionPage();
		System.out.println("product selection page is as expected");
		Thread.sleep(2000);
		boolean flag2=bsf.shoppingCartValidation();
	Thread.sleep(2000);
		Assert.assertTrue(flag1&&flag2);
		System.out.println("The second Product is added successfully to the cart and the product details are as expected");


	}

	/**
	 * Add two different finishes of a product (such as Moen m6702bn) to cart,
	 * change the quantity of each finish on the cart page
	 * @assert that the product and cart total update as expected when the quantity is changed
	 * @difficulty Medium-Hard
	 */
	@Test
	public void addMultipleCartItemsAndChangeQuantity() throws InterruptedException {
		// TODO: Implement this test
		driver.get(getConfiguration("HOMEPAGE"));
		driver.manage().window().maximize();
		AddMultipleCartItems amci=new AddMultipleCartItems(driver,wait);
		amci.addTwoDifferentFinishOfProduct();
		boolean flag1=amci.shoppingCartViewProductChrome();
		System.out.println(flag1);
		System.out.println("Shopping Cart price for Chrome is as expected");
		boolean flag2=amci.shoppingCartViewProductMatte();
		System.out.println(flag2);
		System.out.println("Shopping Cart for price Matte is as expected");
		
		Assert.assertTrue(flag1&&flag2);
		System.out.println("The products are added successfully and the price updated as per quantity");
		
		
	}

	/**
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Brand=Brizo
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	/*@Test
	public void facetNarrowBysResultInCorrectProductCounts() {
		// TODO: Implement this test
	}
	 */
}
