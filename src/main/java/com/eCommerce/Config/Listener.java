package com.eCommerce.Config;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener extends Base implements ITestListener {
	

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		  SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");		   
		  String methodName = result.getName();
		  if(!result.isSuccess())
		  {
		       File scrFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			   try{
			        String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "/target/FailedScreenshot/";
			        File destFile = new File((String) reportDirectory + "" + methodName + "_" + formater.format(calendar.getTime())+".png");				
					FileHandler.copy(scrFile, destFile);
					Reporter.log("<a herf='" +destFile.getAbsolutePath()+"'> <img src ='" + destFile.getAbsolutePath()+"' height='100' width='100'/> </a>");
				}
				catch(IOException e)
				{
				     e.printStackTrace();
				}
		   }
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		
		Calendar calendar = Calendar.getInstance();
		 SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");	   
		 String methodName = arg0.getName();
		 if(arg0.isSuccess())
		 {
		       File scrFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			   try
			   {
			        String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "/target/Successscreenshot/";
			        File destFile = new File((String) reportDirectory + "" + methodName + "_" + formater.format(calendar.getTime())+".png");				
					//FileUtils.copyFile(scrFile, destFile);
			        FileHandler.copy(scrFile, destFile);
					Reporter.log("<a herf='" +destFile.getAbsolutePath()+"'> <img src ='" + destFile.getAbsolutePath()+"' height='100' width='100'/> </a>");
				}
				catch(IOException e)
				{
				     e.printStackTrace();
				}
		  }
	}

}
