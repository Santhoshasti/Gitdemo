package com.eCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Contact Us']")
	public WebElement contactus;
	

	@FindBy(css="img[class='logo img-responsive']")
	public WebElement logo;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	public WebElement search;
	

	@FindBy(xpath="//button[@name='submit_search']")
	public WebElement Submitserch;
	
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	public WebElement Signin;
	
	@FindBy(xpath="//*[@id='email']")
	public WebElement EmailAddress;
	
	
	@FindBy(xpath="//*[@id='passwd']")
	public WebElement Password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	public WebElement Submit;
	

	

}
