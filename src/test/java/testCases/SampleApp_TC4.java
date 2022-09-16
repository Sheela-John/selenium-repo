package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Base_Class;
import pages.MouseOver;
import pages.SampleApp;


public class SampleApp_TC4 extends Base_Class {

	@BeforeTest
	public void setURL() throws InterruptedException
	{
		driver_method_start();
		
		driver.get("http://uitestingplayground.com/sampleapp");
		
	}
@Test
	public void sample_method() throws InterruptedException, IOException {
		
		
		
		SampleApp sam=new SampleApp(driver);
		sam.enterUsername("Sheela");
		sam.enterPassword("pwd");
		sam.clickLogin();
		String val=sam.WelcomeMethod();
		System.out.println(val);
		boolean value;
		if(val.contains("Sheela"))
			{
			value=true;
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Test Passed");
		}
		else
		{
			value=false;
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+ "Test Failed");
		}
		//System.out.println(m.count_mentod());
		Assert.assertTrue(value);
		//endTest();;

			
			driver_method_close();
	              
		}

}
