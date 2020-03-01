package com.eCommerce.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
	prop= new Properties();
	FileInputStream fis=new FileInputStream("src/main/java/com/eCommerce/resources/data.properties");

	prop.load(fis);
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);

	if(browserName.equals("chrome"))
	{
	    System.setProperty("webdriver.chrome.driver", "src/main/java/com/eCommerce/webdrivers/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();

	}
	else if (browserName.equals("firefox"))
	{
		//WebDriverManager.firefoxdriver().setup();
		
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/WebDrivers/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumWebDrivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		 driver= new  FirefoxDriver();
		//firefox code
	}
	else if (browserName.equals("InternetExplorer"))
	{
//		IE code
		  System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/WebDrivers/IEDriverServer.exe");
		  WebDriverManager.iedriver().setup();
		  driver = new InternetExplorerDriver();
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;

	}

	//public void getScreenshot(String result) throws IOException
	//{
//		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		//FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	//	
	//}

	public void takeScreenshot() 
	{
		String screenName= System.currentTimeMillis()+ ".pnng";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try
	{
		FileHandler.copy(src, new File(System.getProperty("user.dir")+"/target/Screenshots/"+screenName+""));
	}
	catch(IOException e)
	{
		System.out.println(e.getMessage());
	}
	}

}
