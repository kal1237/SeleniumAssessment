package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class AddMultipleCartItems extends BasePage {
	
	
	public AddMultipleCartItems(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		
	}
	
	//@FindBy(name="search") WebElement searchBar;
	@FindBy(xpath="(//div[@class='color__picker']//li//img[@class='lazyload'])[1]") WebElement moenChromeFinish;
	@FindBy(xpath="(//div[@class='color__picker']//li//img[@class='lazyload'])[2]") WebElement moenMatteBlackFinish;
	//@FindBy(xpath="//input[contains(@class,'add-to-cart')]") WebElement addToCart;
	//@FindBy(xpath="//div[@class='header-details-user']//li[@class='cart i-cart']//a") WebElement cartView;
	@FindBy(xpath="//input[contains(@class,'7797863')]") WebElement matteBlackquantity;
	@FindBy(xpath="//input[contains(@class,'7203481')]") WebElement chromequantity;
	@FindBy(xpath="(//div[contains(@class,'quantity__up')])[1]") WebElement quantityUp;
	//@FindBy(xpath="(//div[@class='quantityBtn']//div)[2]") WebElement qtyUP;
	@FindBy(xpath="(//li[@data-sku-id='7797863']//div[@class='quantityBtn']//div)[2]") WebElement qtyUPMatteBlackCart;
	@FindBy(xpath="(//li[@data-sku-id='7203481']//div[@class='quantityBtn']//div)[2]") WebElement qtyUPChromeCart;
	//@FindBy(xpath="(//div[contains(@class,'quantity__down')])[2]") WebElement quantitydown;
	@FindBy(xpath="(//div[@class='price__display clearfix']//span)[2]") WebElement priceMoenChrome;
	@FindBy(xpath="(//div[contains(@class,'price__display')]//span)[2]") WebElement priceMoenMatteBlack;
	@FindBy(xpath="(//li[@data-sku-id='7797863']//div[@class='total-price']//span)[1]") WebElement priceMoenMatteBlackCart;
	@FindBy(xpath="(//li[@data-sku-id='7203481']//div[@class='total-price']//span)[1]") WebElement priceMoenChromeCart;
	
	
	String priceMoenCh;
	String priceMoenMB;
	String priceMoenChCart;
	String priceMoenMBCart;
	String newPriceMoenMBCart;
	String newPriceMoenChCart;
	boolean flag=false;
	BathroomSinkFaucets bsf;
	ProductNameCheck product;
	JavascriptExecutor js;
	boolean flag1=false;
	boolean flag2=false;
	
	Actions action;
	
	public void addTwoDifferentFinishOfProduct() throws InterruptedException
	{
		bsf=new BathroomSinkFaucets(driver,wait);
		product=new ProductNameCheck(driver,wait);
		
		//Searching Product Moen m6702bn
		product.searchBar.click();
		product.searchBar.sendKeys("Moen m6702bn");
		action= new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		//Selecting on Chrome Finish for Moen m6702bn
		moenChromeFinish.click();
		
		System.out.println("In Product page Moen Chrome");
		//getting price of chrome finish product
		priceMoenCh=priceMoenChrome.getText();
		System.out.println("Price of chrome is:"+priceMoenCh);
				
			bsf.addToCart.click();
			Thread.sleep(2000);
			System.out.println("Product1 Chrome Finish  is added to cart");

			//selecting Matte Black Finish for Moen m6702bn
		moenMatteBlackFinish.click();
		
		System.out.println("In Product page Moen Matte Black");
		//getting price of Matte Black finish product
		priceMoenMB=priceMoenMatteBlack.getText();
		System.out.println("Price of Matte Black"+priceMoenMB);
		
		    bsf.addToCart.click();
			Thread.sleep(2000);
			System.out.println("Product2 Matte Finish is added to cart");
			
	}
	
	/*Checking price for each product finish(Chrome) and 
	change the quantity of Chrome finish to 2 and checking the price*/
	
	public boolean shoppingCartViewProductChrome() throws InterruptedException
	{
			
			
			bsf.cartView.click();
			
			Thread.sleep(2000);
			 js = (JavascriptExecutor) driver;
			
			action.moveToElement(chromequantity);
			chromequantity.click();
			
			String quantityOfChrome=chromequantity.getAttribute("value");
			System.out.println("Quantity of first product"+quantityOfChrome);
			
			//getting current price and checkin if it matches the actual value
			
			priceMoenChCart=priceMoenChromeCart.getText();
			
			String priceMoenChCart1=priceMoenChCart.substring(1);
			float priceChrome=Float.parseFloat(priceMoenChCart1);
			System.out.println("price in cart of product Chrome"+priceMoenChCart);
			
			if(priceMoenChCart1.equals(priceMoenCh))
			{
				flag=true;
				System.out.println("The product price of chrome matched with cart");
			}
			
			
			Thread.sleep(2000);
			//Changing the quantity to one more and getting the price changed
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(qtyUPChromeCart));
			
			qtyUPChromeCart.click();
			Thread.sleep(2000);
			System.out.println("Adding 1 more to first one Chrome");
			
			String quantityOfChrome1=chromequantity.getAttribute("value");
			float qtyChrome=Float.parseFloat(quantityOfChrome1);
			System.out.println("Quantity of Chrome Now:"+qtyChrome);
			
			String newPriceMoenChCart=priceMoenChromeCart.getText().substring(1);
			System.out.println(newPriceMoenChCart);
			float totalPriceChrome=Float.parseFloat(newPriceMoenChCart);
			System.out.println("new price is:"+newPriceMoenChCart);
			
			
			float CalculateNewPrice=priceChrome*qtyChrome;
			System.out.println("calculated new price is:"+CalculateNewPrice);
			
			if(CalculateNewPrice==totalPriceChrome)
			{
				flag1=true;
				System.out.println("The value displayed for Chrome Product is as per the quantity");
			}
			
		
			if(flag&&flag1)
			{
				flag2=true;
				System.out.println("The value displayed for Chrome Product is calculated correctly as per the quantity");
			}
			
			return flag2;
			
	}
			
			public boolean shoppingCartViewProductMatte() throws InterruptedException {
				 js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();",qtyUPMatteBlackCart );
			System.out.println("step2");
			Thread.sleep(2000);
			action.moveToElement(matteBlackquantity);
			matteBlackquantity.click();
			System.out.println("Quantity of second product");
			
			String quantityOfMatte=matteBlackquantity.getAttribute("value");
			System.out.println("Quantity of second product"+quantityOfMatte);
			
			
			
//getting current price and checkin if it matches the actual value
			
			priceMoenMBCart=priceMoenMatteBlackCart.getText();
			
			String priceMoenMBCart1=priceMoenMBCart.substring(1);
			float PriceMatteBlack=Float.parseFloat(priceMoenMBCart1);
			System.out.println("price in cart of product Chrome"+priceMoenMBCart1);
			
			if(priceMoenMBCart1.equals(priceMoenMB))
			{
				flag=true;
				System.out.println("The product price of Matte Black Finish matched with cart");
			}
			
			
			
			Thread.sleep(2000);
			
//Changing the quantity to one more and getting the price changed
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(qtyUPMatteBlackCart));
			
			qtyUPMatteBlackCart.click();
			qtyUPMatteBlackCart.click();
			
			Thread.sleep(2000);
			System.out.println("Adding 1 more to second one Matte Black");
			
			String quantityOfMB=matteBlackquantity.getAttribute("value");
			float qtyMb=Float.parseFloat(quantityOfMB);
			System.out.println("Quantity of Matte Black Finish Now:"+qtyMb);
			
			String newPriceMoenMBCart=priceMoenMatteBlackCart.getText().substring(1);
			System.out.println(newPriceMoenMBCart);
			float totalPriceMatteBlack=Float.parseFloat(newPriceMoenMBCart);
			System.out.println("new price is:"+newPriceMoenMBCart);
			
			
			
			float CalculateNewPriceMB=PriceMatteBlack*qtyMb;
			System.out.println("calculated new price is:"+CalculateNewPriceMB);
			
			if(CalculateNewPriceMB==totalPriceMatteBlack)
			{
				flag1=true;
				System.out.println("The value displayed for Matte Black Product is as per the quantity");
			}
			
		
			if(flag&&flag1)
			{
				flag2=true;
				System.out.println(flag2);
				System.out.println("The value displayed for Matte Black Product is calculated correctly as per the quantity");
			}
			
			return flag2;
			
			

		}
	
	
		
		
		
		
		
	}
	


