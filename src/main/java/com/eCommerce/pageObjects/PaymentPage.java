package com.eCommerce.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
WebDriver driver;
public PaymentPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//input[@id='search_query_top']")
	public WebElement SearchField;
	
	@FindBy(xpath="//button[@name='submit_search']")
	public WebElement Searchbuton;

	@FindBy(xpath="//*[text()='Add to cart']")
	public  WebElement Addtocart; 
	
	
	
      @FindBy(xpath="//a[contains(@title,'Proceed to checkout')]")
      public WebElement Proceed;
	
	@FindBy(xpath="//*[text()='Proceed to checkout']")
    public WebElement CartProceed;

	
	@FindBy(xpath="//*[@id='email']")
	public WebElement EmailAddress;

	@FindBy(xpath="//input[@id='passwd']")
	public WebElement password;

	@FindBy(xpath="//button[@id='SubmitLogin']")
	public WebElement Submit;
	
	@FindBy(xpath="//button[@name='processAddress']")
	public WebElement AddressPage;

	@FindBy(xpath="//input[@id='cgv']")
    public WebElement Checkbox;
	


	@FindBy(xpath="//button[@name='processCarrier']")
	public WebElement ShippingPage;

	@FindBy(xpath="//*[text()='order processing will be longer']")
	public WebElement OrderProcessing;

	
}


