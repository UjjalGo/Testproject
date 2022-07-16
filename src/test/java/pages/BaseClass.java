package pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utlity.DataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass{
	
	public static WebDriver driver=null;
	DataReader dr;
	public static ExtentReports extent;
	ExtentSparkReporter spark;
	
	
	
	@BeforeMethod
	@BeforeSuite
	public void setUp() throws IOException{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
	   
		if(driver==null){
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--window-size=1920,1080");
//			opt.addArguments("--start-maximized");
           opt.setHeadless(false);//For CI server it should be true
			
			driver=new ChromeDriver(opt);
			dr=new DataReader();
			driver.get(dr.getUrl());
			System.out.println("Application launched successfully");
			extent = new ExtentReports();
			 spark = new ExtentSparkReporter("index.html");
//			spark.config().setTheme(Theme.);
//			 final File CONF = new File("Data//spark-config.json");
//			 ExtentSparkReporter spark = new ExtentSparkReporter("target/spark/spark.html");
//			 spark.loadJSONConfig(CONF);
		    extent.attachReporter(spark);
		    
			
		}
		
		
		}
	
	
	
	
	@AfterMethod
	
	
	public void tearDown(ITestResult result)
	{
	 
	// Here will compare if test is failing then only it will enter into if condition
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
	// Create refernce of TakesScreenshot
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	// Call method to capture screenshot
	File source=ts.getScreenshotAs(OutputType.FILE);
	 
	// Copy files to specific location here it will save all screenshot in our project home directory and
	// result.getName() will return name of test case so that screenshot name will be same
	FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
	 
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	}
	}
	
	
	
	@AfterSuite
public void tearDown(){
//	driver.quit();
	driver=null;
	extent.flush();
}

	

	
	}
