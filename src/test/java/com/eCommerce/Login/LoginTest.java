package com.eCommerce.Login;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.eCommerce.Config.Base;
import com.eCommerce.pageObjects.LoginPage;

public class LoginTest extends Base {
    LoginPage lp;
	public static Logger logger = LogManager.getLogger(LoginTest.class.getName());
	@BeforeTest
	public void BrowserSetup() throws IOException
	{
		driver= initializeDriver();
		logger.info("Start invokeing browser");
		driver.get(prop.getProperty("url"));
		logger.info("Entering the URL");
	}
	@Test
	public void LoginVerify() throws InterruptedException
	{
		lp= new LoginPage(driver);
		lp.Signin.click();
		logger.info("Click on the Signin button");
		lp.EmailAddress.click();
		logger.info("Click on the EmailAddress");
		lp.EmailAddress.sendKeys(prop.getProperty("username"));
		logger.info("Enter the email in EmailAddress");
		lp.Password.sendKeys(prop.getProperty("password"));
		logger.info("Enter the Password");
		lp.Submit.click();
		logger.info("Click on Login button");
		Thread.sleep(3000);
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		logger.info("Browser Closing");
	}
}
