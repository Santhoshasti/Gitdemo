package com.eCommerce.createAccount;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eCommerce.Config.Base;
import com.eCommerce.pageObjects.CreateAccountPage;
import com.eCommerce.pageObjects.LoginPage;

public class CreateAccountTest extends Base {

	public static Logger logger = LogManager.getLogger(CreateAccountTest.class.getName());
	CreateAccountPage ca;
	
	@BeforeTest
	public void InvokeBrowser() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();		
	}
	@Test
	public void CreateAccountVerification() throws InterruptedException
	{
		ca = new CreateAccountPage(driver);
		ca.Signin.click();
		logger.info("Clickn on Signin button");
		ca.CreateEmail.sendKeys("SanthoshRS@gmail.com");
		logger.info("Enter the email in Email address ");
		
		ca.CreateAccount.click();
		logger.info("Click on Create an account button");
		Thread.sleep(3000);
		ca.Title_Mr.click();
		logger.info("Select radio button Mr");
		ca.Firstname.click();
		logger.info("Click on First name field");
		ca.Firstname.sendKeys("Santhosh");
		logger.info("Enter First name in First name field");
		ca.Lastname.sendKeys("RS");
		logger.info("Enter Last name in Last name field");
		ca.Password.sendKeys("test123");
		logger.info("Enter Password in Password field");
		ca.DateofBrith();
		logger.info("Enter Date of Birth");
		//Add Address
		ca.FirstName.clear();
		logger.info("Clear the First name field");
		ca.FirstName.sendKeys("Santhosh");
		logger.info("Enter First name in First name field");
		ca.LastName.clear();
		logger.info("Clear the Last name field");
		ca.LastName.sendKeys("RS");
		logger.info("Enter Last name in Last name field");
		ca.company.sendKeys("Free Lancer");
		logger.info("Enter the Company name in Compnay name Field");
		ca.address.sendKeys("Madison Square");
		logger.info("Enter address in Address field");
		ca.city.sendKeys("New York");
		logger.info("Enter City name in City name field");
		ca.StateSelction();
		logger.info("Select State name from drop down list");
		ca.postcode.sendKeys("23433");
		logger.info("Enter postal code");
	    ca.CountrySelection();
	    logger.info("Select Counry name from Country drop down list");
	    ca.Mobilephone.sendKeys("5438213313");
	    logger.info("Enter Mobile Phone#");
	    ca.Register.click();
	    logger.info("Click on Register button");
	
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
