package com.build.qa.build.selenium.pageobjects.homepage;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class NarrowByCategoryDropPage extends BasePage {

	public NarrowByCategoryDropPage (WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
	}

	NarrowByCategoryDropPage nbc;

	JavascriptExecutor js;

	@FindBy(xpath="(//div[@class='section'])[1]") WebElement sectionCategory;
	@FindBy(xpath="(//li[@data-di-id='di-id-8a5f626d-528707f4']//a)[2]") WebElement kitchenFaucets;
	@FindBy(xpath="//div[contains(text(),'brand')]") WebElement brand;
	@FindBy(id="totalNumRecs") WebElement totalNumberOfRocords;
	@FindBy(xpath="//div[@class='plp-right-filter clearfix']") WebElement filterSet;
	@FindBy(xpath="//div[@class='filter-label']") WebElement filterBy;
	@FindBy(xpath="(//div[@class='col-lg-4 filter-selects'])[1]") WebElement colorFinishCategory;
	@FindBy(xpath="(//div[@class='col-lg-4 filter-selects'])[2]") WebElement numberOfHandlesCategory;
	@FindBy(xpath="(//div[@class='col-lg-4 filter-selects'])[3]") WebElement collectionCategory;
	@FindBy(xpath="//label[contains(text(),'  Blacks')]") WebElement blacksFinish;
	@FindBy(xpath="//label[contains(text(),'  Two Handle')]") WebElement twoHandles;
	@FindBy(xpath="//label[contains(text(),'  Chesterfield')]") WebElement chesterFieldCollection;

	@FindBy(xpath="(//div[@class='rc-fg-option']//p[@class='js-title'])[1]") WebElement filterCategory1;
	@FindBy(xpath="(//div[@class='rc-fg-option']//p[@class='js-title'])[2]") WebElement filterCategory2;
	@FindBy(xpath="(//div[@class='rc-fg-option']//p[@class='js-title'])[3]") WebElement filterCategory3;
	@FindBy(xpath="(//div[@class='rc-fg-option']//p[@class='js-title'])[4]") WebElement filterCategory4;

	@FindBy(xpath="(//div[@class='rc-fg-option']//p[@class='js-option'])[1]") WebElement filterCategoryDisplayed1;
	@FindBy(xpath="(//div[@class='rc-fg-option']//p[@class='js-option'])[2]") WebElement filterCategoryDisplayed2;
	@FindBy(xpath="(//div[@class='rc-fg-option']//p[@class='js-option'])[3]") WebElement filterCategoryDisplayed3;
	@FindBy(xpath="(//div[@class='rc-fg-option']//p[@class='js-option'])[4]") WebElement filterCategoryDisplayed4;


	//method for total records shown called everytime we need to compare
	public int totalNumberOfrecords()
	{
		String totalRecds=totalNumberOfRocords.getAttribute("value");
		//System.out.println(totalRecds);

		String tr=totalRecds.replace(",","");
		//System.out.println(tr);
		int totalRcords=Integer.parseInt(tr);

		//System.out.println("total number of records shown is:"+totalRcords);
		return totalRcords;
	}


	//selecting the "Kitchen Faucets" from shop by category in homepage

	public boolean searchByCategory() throws InterruptedException
	{

		nbc=new NarrowByCategoryDropPage(driver,wait);
		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", sectionCategory);
		Thread.sleep(2000);
		kitchenFaucets.click();
		System.out.println("kitchen faucet is selected");

		String categoryDisplayed=filterCategory1.getText();
		String CategoryExpected="Category:";
		String CategoryResult=filterCategoryDisplayed1.getText();
		String CategoryResultDisplayed="Kitchen Faucets";
		//removed this hardcoded number since the count has changed in the website
		//int totalNumberExpected=1480;
		int totalNumberDisplayed=nbc.totalNumberOfrecords();
		boolean flag=false;

		System.out.println("The filter typeis:"+filterCategory1.getText());
		System.out.println("The shop by Category selected is:"+filterCategoryDisplayed1.getText());
		System.out.println("total records now:"+nbc.totalNumberOfrecords());

		if((categoryDisplayed.equalsIgnoreCase(CategoryExpected))
				&&(CategoryResult.equalsIgnoreCase(CategoryResultDisplayed)))
				/*&&(totalNumberExpected==totalNumberDisplayed))*/

		{
			flag=true;
			System.out.println("The correct filters for category are being narrowed");
		}

		return flag;
	}


	//selecting the "Blacks (219)" from "Color Finish Category" as first filter

	public boolean searchBycategoryFirstFilter() throws InterruptedException
	{


		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(colorFinishCategory));

		Thread.sleep(3000);
		//selecting the first filter by "color finish catergory" 

		colorFinishCategory.click();

		System.out.println("color finish is selected"); 


		Thread.sleep(2000);
		//Select colorFinishChoose=new Select(driver.findElement(By.name("Color Finish Category")));

		//selecting "Blacks" from color finish category 

		blacksFinish.click();


		System.out.println("color:blacks is selected");
		System.out.println("BlacksSelect count is:"+blacksFinish.getText());
		String blackFinishCount=blacksFinish.getText().substring(8, 11);
		System.out.println(blackFinishCount);
		int blackfinishCountInt=Integer.parseInt(blackFinishCount);

		Thread.sleep(3000);
		String categoryDisplayed=filterCategory2.getText();
		String CategoryExpected="Color/Finish Category:";
		String CategoryResult=filterCategoryDisplayed2.getText();
		String CategoryResultDisplayed="Blacks";
		int totalNumberExpected=blackfinishCountInt;
		int totalNumberDisplayed=nbc.totalNumberOfrecords();
		boolean flag=false;

		System.out.println("The first filter type is:"+categoryDisplayed);
		System.out.println("The shop by Category selected is:"+CategoryResult);
		System.out.println("total records now:"+nbc.totalNumberOfrecords());

		if((categoryDisplayed.equalsIgnoreCase(CategoryExpected))
				&&(CategoryResult.equalsIgnoreCase(CategoryResultDisplayed))
				&&(totalNumberExpected==totalNumberDisplayed))

		{
			flag=true;
			System.out.println("After First Filter :The correct filters are being narrowed, and the result count is correct");
		}

		return flag;
	}


	//Selecting second filter:"Number Of handles" and "Two Handle (27)"


	public boolean searchBycategorySecondFilter() throws InterruptedException
	{


		//selecting the second filter by "number of handles" 

		numberOfHandlesCategory.click();

		System.out.println("Number of Handles  is selected"); 


		Thread.sleep(2000);


		//selecting "Two Handle(27)" from  Number OF Handles category 

		twoHandles.click();


		System.out.println("Number of Handles:Two handles is selected");
		System.out.println(twoHandles.getText());
		String twoHandlesStr=twoHandles.getText().substring(12, 14);
		System.out.println("two Handles count"+twoHandlesStr);
		int twoHandlesInt=Integer.parseInt(twoHandlesStr);

		//  Two Handle (27)
		Thread.sleep(3000);
		String categoryDisplayed=filterCategory3.getText();
		String CategoryExpected="Number of Handles:";
		String CategoryResult=filterCategoryDisplayed3.getText();
		String CategoryResultDisplayed="Two Handle";
		int totalNumberExpected=twoHandlesInt;
		int totalNumberDisplayed=nbc.totalNumberOfrecords();
		boolean flag=false;

		System.out.println("The filter typeis:"+categoryDisplayed);
		System.out.println("The shop by Category selected is:"+CategoryResult);
		System.out.println("total records now:"+nbc.totalNumberOfrecords());

		if((categoryDisplayed.equalsIgnoreCase(CategoryExpected))
				&&(CategoryResult.equalsIgnoreCase(CategoryResultDisplayed))
				&&(totalNumberExpected==totalNumberDisplayed))

		{
			flag=true;
			System.out.println("After second Filter :The correct filters are being narrowed, and the result count is correct");
		}

		return flag;
	}

	//selecting "Chester Field(12)" from  Collection category
	public boolean searchBycategoryThirdFilter() throws InterruptedException
	{


		//selecting the third filter by "Collection" 

		collectionCategory.click();

		System.out.println("Collection  is selected"); 


		Thread.sleep(3000);


		//selecting "Chester Field(12)" from  Collection category 

		chesterFieldCollection.click();


		System.out.println("Collection:Chester Field is selected");
		System.out.println(chesterFieldCollection.getText());
		String chesterStr=chesterFieldCollection.getText().substring(14, 16);
		System.out.println("two Handles count"+chesterStr);
		int chesterInt=Integer.parseInt(chesterStr);


		Thread.sleep(3000);
		String categoryDisplayed=filterCategory4.getText();
		String CategoryExpected="Collection:";
		String CategoryResult=filterCategoryDisplayed4.getText();
		String CategoryResultDisplayed="Chesterfield";
		int totalNumberExpected=chesterInt;
		int totalNumberDisplayed=nbc.totalNumberOfrecords();
		boolean flag=false;

		System.out.println("The filter typeis:"+categoryDisplayed);
		System.out.println("The shop by Category selected is:"+CategoryResult);
		System.out.println("total records now:"+nbc.totalNumberOfrecords());

		if((categoryDisplayed.equalsIgnoreCase(CategoryExpected))
				&&(CategoryResult.equalsIgnoreCase(CategoryResultDisplayed))
				&&(totalNumberExpected==totalNumberDisplayed))

		{
			flag=true;
			System.out.println("After third Filter :The correct filters are being narrowed, and the result count is correct");
		}

		return flag;
	}
























}
