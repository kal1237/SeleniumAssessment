package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;


import junit.framework.Assert;

public class ProductNameCheck extends BasePage{




	public ProductNameCheck(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);

	}

	@FindBy(name="search") WebElement searchBar;
	@FindBy(xpath="//h2[@class='product__brand']") WebElement productBrand;
	@FindBy(xpath="(//div[@class='col-lg-12 col-md-12']//p[@class='product__prop']//span)[1]") WebElement productID;


	//Searching Product name "Moen m6702bn" in search bar and  navigating to product page
	public boolean searchText() throws InterruptedException
	{
		boolean flag=false;
		String BeforeLaunching=driver.getCurrentUrl();
		System.out.println("currenturl"+BeforeLaunching);

		searchBar.click();
		searchBar.sendKeys("Moen m6702bn");
		Actions action= new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);

		String AfterLaunching=driver.getCurrentUrl();
		System.out.println("after launch url"+AfterLaunching);
		if(!BeforeLaunching.equalsIgnoreCase(AfterLaunching))
		{
			System.out.println("product is searched and product page is displayed");
			flag=true;
		}
		return flag;

	}

	//Checking if the correct Brand Name is displayed

	public boolean fetchProductBrand()
	{
		boolean flag=false;
		String ExpectedBrandName="Moen";
		String ActualBrandName=productBrand.getText();
		System.out.println("product brand is:"+ActualBrandName);
		if(ExpectedBrandName.equalsIgnoreCase(ActualBrandName))
		{
			flag=true;
			System.out.println("The product brand matches and as expected");
		}

		return flag;

	}
	//Checking if the correct ProductID is displayed

	public boolean fetchProductID()
	{
		boolean flag=false;
		String ExpectedBrandID="M6702BN";
		String ActualBrandID=productID.getText();
		String ActualSubString=ActualBrandID.substring(6);
		System.out.println("product id is:"+ActualSubString);

		if(ExpectedBrandID.equalsIgnoreCase(ActualSubString))
		{
			flag=true;
			System.out.println("The product ID matches and as expected");
		}

		return flag;

	}



}
