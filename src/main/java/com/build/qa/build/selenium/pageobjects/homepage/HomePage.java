package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

import junit.framework.Assert;

public class HomePage extends BasePage {
	
	private By homePageWrapper;
	
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		homePageWrapper = By.cssSelector("#wrapper.homepage");
	}
	
	
	
	public boolean onHomePage() {
		
		//System.out.println("Wrapper is"+homePageWrapper);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(homePageWrapper)) != null;
		
		
	
	
	
	
}
}
