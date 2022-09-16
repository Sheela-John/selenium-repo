package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Base_Class;
import pages.MouseOver;


public class MouseOver_TC3 extends Base_Class {
	@BeforeTest
	public void setURL() throws InterruptedException
	{
		driver_method_start();
		
		driver.get("http://uitestingplayground.com/mouseover");
		
	}
@Test
	public void mouseover_method() throws InterruptedException, IOException {
		
	driver_method_start();
	
	driver.get("http://uitestingplayground.com/mouseover");
		
		MouseOver m=new MouseOver(driver);
		m.clickme_method();
		m.clickme_method();
		int count=m.count_mentod();
		boolean value;
		if(count==2)
		{
			value=true;
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Test Passed");
		}
		else
		{
			value=false;
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+ "Test Failed");
		}
		Assert.assertTrue(value);
		//System.out.println(m.count_mentod());
		//endTest();;

		driver_method_close();
              
	}

}
