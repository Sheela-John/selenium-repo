package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Base_Class;
import pages.Progress_Bar;

public class ProgressBar_TC2 extends Base_Class {
	
	
		
		
	
@Test
	public void progressbar_method() throws InterruptedException, IOException {
		
		
	driver_method_start();
	
			driver.get("http://uitestingplayground.com/progressbar");
		Progress_Bar pBar=new Progress_Bar(driver);
		pBar.start_click();
		Thread.sleep(2000);
		pBar.stopp_click();
		String val=pBar.progress_method();
		int val1=Integer.parseInt(val);
		startTest();
		boolean value;
		//testmethod("demo2");
		if(val1==75)
		{
			value=true;
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Test Passed");
		}
		else
		{
			value=false;
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+ "Test Failed");
		}
			//Assert.assertTrue(value);
		//endTest();;
				driver_method_close();
		              
			}

}
