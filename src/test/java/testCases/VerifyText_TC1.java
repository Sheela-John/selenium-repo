package testCases;

import java.io.IOException;

import org.apache.hc.core5.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Base_Class;
import pages.VerifyText;



public class VerifyText_TC1 extends Base_Class {

	
	
		
		
	
	@Test
	public void verifytext_method() throws InterruptedException, IOException {
		
		//driver_method_start();
		
				driver.get("http://uitestingplayground.com/verifytext");
		VerifyText txt=new VerifyText(driver);
		
		Thread.sleep(2000);
		String actualtext;
		//System.out.println(txt.verifytext_method());
		String tempext="Welcome UserName!";
		
		
		//startTest();
		//testmethod("demo1");
		boolean value;
		if(txt.verifytext_method().equalsIgnoreCase(tempext)) {
			value=true;
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Test Passed");
		}
		else
		{
			value=false;
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+ "Test Failed");
}
               //Close browser instance
		Assert.assertTrue(value);
		///endTest();;
	
		driver_method_close();
              
	}

}
