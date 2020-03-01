package com.eCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
	
	WebDriver driver;
	
	public CreateAccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	public WebElement Signin;
	
	@FindBy(xpath="//input[@id='email_create']")
	public WebElement CreateEmail;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	public WebElement CreateAccount;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	public WebElement Title_Mr;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	public WebElement Title_Mrs;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	public WebElement Firstname;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	public WebElement Lastname;
	
	@FindBy(xpath="//input[@id='passwd']")
	public WebElement Password;
	
	@FindBy(xpath="//select[@id='days']")
	public WebElement Day;
	
	@FindBy(xpath="//select[@id='months']")
	public WebElement Month;
	
	@FindBy(xpath="//select[@id='years']")
	public WebElement Year;
	
	@FindBy(xpath="//input[@id='newsletter']")
	public WebElement Sing_up_for_newsletter;
	
	@FindBy(xpath="//input[@id='optin']")
	public WebElement Receive_special_offers_from_our_partners;
	
	@FindBy(xpath="//input[@name='firstname']")
	public WebElement FirstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	public WebElement LastName;
	
	@FindBy(xpath="//input[@id='company']")
	public WebElement company;
	
	@FindBy(xpath="//input[@id='address1']")
	public WebElement address;
	
	@FindBy(xpath="//input[@id='city']")
	public WebElement city;
	
	@FindBy(xpath="//select[@id='id_state']")
	public WebElement state;
	
	@FindBy(xpath="//input[@id='postcode']")
	public WebElement postcode;
	
	@FindBy(xpath="//select[@id='id_country']")
	public WebElement country;
	
	@FindBy(xpath="//textarea[@id='other']")
	public WebElement Additional_information;
	
	@FindBy(xpath="//input[@id='phone']")
	public WebElement Homephone;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	public WebElement Mobilephone;
	
	@FindBy(xpath="//input[@id='alias']")
	public WebElement Assign_an_address;
	
	@FindBy(xpath="//*[text()='Register']")
	public WebElement Register;
	
	
	public void DateofBrith()
	{
		Day.click();
		Select date = new Select(Day);
		date.selectByValue("4");
		// Selection of Month
		Month.click();
		Select month = new Select(Month);
		month.selectByValue("9");
		//Selection of Year
		Year.click();
		Select year = new Select(Year);
		year.selectByValue("1981");			
	}
	
	public void StateSelction()
	{
		state.click();
		Select State = new Select(state);
		State.selectByVisibleText("New York");
	}
	
	public void CountrySelection()
	{
		country.click();
		Select Country = new Select(country);
		Country.selectByVisibleText("United States");
	}

}
