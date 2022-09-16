package Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base_Class {
	
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports report;
    public static ExtentTest test;
	 @BeforeTest
	public void driver_method_start() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().driverVersion("105.0.5195.102").setup();
		driver = new ChromeDriver();
		
        String baseUrl = "http://uitestingplayground.com/";
        
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
	}
	
	
	@BeforeSuite
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReportResults.html");
	
	}
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../BStackImages/" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
	     
	    @AfterSuite
	    public void tearDown()
	    {
	        report.flush();
	    }
	@AfterMethod
	public void testmethod()
	{
		test = report.startTest("Demo");
	}
	
	@AfterTest
	public void driver_method_close()
	{
		 driver.quit();
	}
	
}
