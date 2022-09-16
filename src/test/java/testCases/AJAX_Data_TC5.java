package testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Base_Class;
import pages.AJAX_Data;
import pages.MouseOver;


public class AJAX_Data_TC5 extends Base_Class {
		
	
@Test
	public void ajax_method() throws InterruptedException, IOException {
		
	driver_method_start();
	
	driver.get("http://uitestingplayground.com/ajax");
	
		
		AJAX_Data ajax=new AJAX_Data(driver);
		ajax.clickajax();
		//Thread.sleep(15000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/p")));
		
		System.out.println(ajax.Display());
		boolean value;
	if(!(ajax.Display().isEmpty()))
		{
		value=true;;
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Test Passed");
		}
		else
		{
			value=false;
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+ "Test Failed");
		}
		Assert.assertTrue(value);
		//System.out.println(m.count_mentod());*/
		//endTest();;
		driver_method_close();
	              
		}

}
