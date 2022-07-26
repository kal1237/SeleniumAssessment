package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class BathroomSinkFaucets extends BasePage{


	public BathroomSinkFaucets(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);

		
	}

	@FindBy(xpath="(//li[contains(@class,'compare-search-item')])[2]") WebElement product2;

	@FindBy(xpath="(//div[@class='sr-content-box']//p)[1]") WebElement product2Select;
	@FindBy(xpath="//div[@class='col-lg-12 col-md-12']//h2") WebElement product2Brand;
	@FindBy(xpath="(//div[@class='col-lg-12 col-md-12']//p//span)[1]") WebElement product2ID;
	@FindBy(xpath="//*[@class='product__name']") WebElement productDesc;
	@FindBy(xpath="//div[@class='add__to__cart__success']//div") WebElement addToCartSuccessMessage;
	@FindBy(xpath="//input[contains(@class ,'add-to-cart')]") WebElement addToCart;
	@FindBy(xpath="//div[@class='header-details-user']//li[@class='cart i-cart']//a") WebElement cartView;
	@FindBy(xpath="(//div[@class='cl-summary']//div[@class='cl-info']//p)[2]") WebElement productIDSelected;
	@FindBy(xpath="//div[@class='cl-summary']//div[@class='cl-name']//p") WebElement productDescSelected;



	String secondProductName=null;
	String secondProductID=null;
	String secondProductDesc=null;

	//selecting second product from bathroom sink faucets and adding to cart

	public boolean productSelectionPage() throws InterruptedException
	{


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", product2);
		


		product2.click();

		Thread.sleep(2000);
		secondProductName=product2Brand.getText();
		System.out.println("second product name selected is:"+secondProductName);

		secondProductID=product2ID.getText();
		System.out.println("second product id selected is:"+secondProductID);

		secondProductDesc=productDesc.getText();
		System.out.println("second product desc selected is :"+secondProductDesc);

		boolean flag=false;
		if(addToCart.isEnabled())
		{
			addToCart.click();
			Thread.sleep(3000);

			if(addToCartSuccessMessage.getText().equalsIgnoreCase("Added to your cart. View Cart"))
			{
				flag=true;
				System.out.println("Product Successfully added to cart and message displayed");
			}


		}
		return flag;



	}

	//validating the shopping cart for the product added

	public boolean shoppingCartValidation() throws InterruptedException
	{
		String expectedProductNameAndDesc=secondProductName+" "+secondProductDesc;
		String expectedProductID=secondProductID.substring(6);
		System.out.println("Expected Product full name:"+expectedProductNameAndDesc);
		System.out.println("Expected Product ID:"+expectedProductID);

		boolean flag=false;
		cartView.click();
		Thread.sleep(2000);
		String displayedProductID=productIDSelected.getText();
		String displayedProductName=productDescSelected.getText();

		System.out.println("Displayed Prdt ID:"+displayedProductID);
		System.out.println("Displyed Name:"+displayedProductName);

		if((expectedProductNameAndDesc.equals(displayedProductName))&&(expectedProductID.equals(displayedProductID)))
		{
			flag=true;
			System.out.println("validated product id and Description");
		}


		return flag;



	}






}
