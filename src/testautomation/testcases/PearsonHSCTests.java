package testautomation.testcases;



import junit.framework.TestCase;  
import org.openqa.selenium.*;  
import org.openqa.selenium.remote.*;  
import java.net.URL;  
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
//import static org.testng.Assert.*;
import java.awt.AWTException;
import java.awt.Choice;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.server.SeleniumServer;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;


import testautomation.framework.AssertionTest;
import testautomation.framework.CaptureScreenshot;
import testautomation.framework.LogGenerator;
import testautomation.framework.SetupDriver;

import org.junit.Assume.*;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;





@RunWith(Parameterized.class)
public class PearsonHSCTests {
	
	
	
	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
		
	public static int index=0;
	private String browserchoice;
//	@RunWith(Parameterized.class)
//	public class TestGoogleBase extends SeleneseTestBase {
	   
	public PearsonHSCTests(String opt){
		//index++;
		browserchoice=opt;
		 // System.out.println("index"+index);

	  // System.out.println("opt"+opt);
	  }
		 
 
		 
	  @Parameters
	   public static Collection<Object[]> data() {
	   
	  //Object[][] data = new Object[][] {{"1"},{"2"},{"3"},{"4"},{"5"},{"6"}};
	//Object[][] data = new Object[][] {{"2"},{"3"},{"4"},{"6"}};
	  Object[][] data = new Object[][] {{"2"}};
	    return Arrays.asList(data);

	   }
	
	
		private String baseUrl;
		
	private RemoteWebDriver driver = null;
		//static WebDriver driver;
		
	   Process process=null;
		
		@Before
		public void setUp() 
		{
			
			SetupDriver swd = new SetupDriver(browserchoice);
			driver = swd.setDriver();
			System.out.println("ss");
			Assume.assumeTrue(swd.valid==true);
			System.out.println("after assume");
			LogGenerator lg = new LogGenerator(driver);
			
			
			
			
		}
				
		@After
		public void tearDown() throws Exception 
		{
			
			
			//SetupDriver.exit();
			if(driver!=null)
			driver.quit();
			
			System.out.println("Driver ShutDown");
			//process.destroy();
		}
			
		@Test
		public void HSCTest_Test() throws Exception {
		
			//Launch and Login
			//baseUrl ="http://d1-pearson-hsc.herokuapp.com/";
			baseUrl ="http://p-pearson-hsc.herokuapp.com/";
			driver.get(baseUrl + "/#/home");		
			driver.findElement(By.name("j_username")).clear();
			driver.findElement(By.name("j_username")).sendKeys("hsc");
			driver.findElement(By.name("j_password")).clear();
			driver.findElement(By.name("j_password")).sendKeys("breakthrough");
			driver.findElement(By.id("login-button")).click();
			
			synchronized (driver) {
				driver.wait(4000);
				
			}
			//Verify discipline page has launched
			//Verify 1st Discipline
			WebElement Discipline1 = driver.findElement(By.xpath("//span[text()=\"Criminal Justice\"]"));
			String str_disc1 = Discipline1.getText();
			System.out.println("Discipline 1 = "+str_disc1);
			AssertionTest.assertjob(driver, str_disc1, "Criminal Justice");
			//assertEquals("Criminal Justice", str_disc1);
			
			//Verify Last Discipline
			WebElement Discipline2 = driver.findElement(By.xpath("//span[text()=\"Trades\"]"));
			String str_disc2 = Discipline2.getText();
			System.out.println("Discipline 2 = "+str_disc2);
		
			AssertionTest.assertjob(driver, str_disc2, "Trades");
			//assertEquals("Trades", str_disc2);
			
			//Open discipline "Criminal Justice"
			
			WebElement flash = driver.findElement(By.xpath("//span[text()=\"Criminal Justice\"]"));
			flash.click();
			
			synchronized (driver) {
				driver.wait(4000);
				
			}	
			//Verify that product page has launched
			//Verify 1st Product
			WebElement Product1 = driver.findElement(By.xpath("//span[text()=\"CJ Today, 12/e\"]"));
			String str_prd1 = Product1.getText();
			System.out.println("Product1 = "+str_prd1);
			AssertionTest.assertjob(driver, str_prd1, "CJ Today, 12/e");
			//assertEquals("CJ Today, 12/e", str_prd1);
			
			//Verify Last Product
			WebElement Product2 = driver.findElement(By.xpath("//span[text()=\"Criminal Law Today, 5/e\"]"));
			String str_prod2 = Product2.getText();
			System.out.println("Product 2 = "+str_prod2);
			AssertionTest.assertjob(driver, str_prod2, "Criminal Law Today, 5/e");
			//assertEquals("Criminal Law Today, 5/e", str_prod2);
			
			
			
			//Open book "Criminal Justice Today, 12e" 
			WebElement flash2 = driver.findElement(By.xpath("//span[text()=\"CJ Today, 12/e\"]"));
			flash2.click();
			
			synchronized (driver) {
				driver.wait(4000);
				
			}
			//Verify that product page has launced.
			WebElement audio3 = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[4]/div/div[3]/div[2]/ul/li[3]/a"));
			String str_aud3 = audio3.getText();
			System.out.println("Audio 3 = "+str_aud3);
			AssertionTest.assertjob(driver, str_aud3, "3 Driving Sell Thru");
			//assertEquals("3 Driving Sell Thru", str_aud3);
			
			
			//Launch FlashCards
			
			WebElement flash3 = driver.findElement(By.cssSelector("div.span8 > button"));
			flash3.click();
						
			//Select Correct Option in Q#1 
			
			WebElement flash4 = driver.findElement(By.xpath("//span[text()=\"MyCJLab\"]"));
			flash4.click();

			
			synchronized (driver) {
				driver.wait(4000);
				
			}
			//Verify that green check mark is appearing for correct answer.
			
			WebElement CorrectAns = driver.findElement(By.xpath("//span[text()=\"MyCJLab\"]/.."));
			String str = CorrectAns.getAttribute("class");
			AssertionTest.assertjob(driver, str, "btn radio-control active correct-ans");
			//assertEquals("btn radio-control active correct-ans", str);
						
			//Click on Next button to move Q#2
			
			WebElement flash5 = driver.findElement(By.xpath("//button[text()=\"Next\"]"));
			flash5.click();

			
			
				//Clicking on Profile Icon
				
				WebElement flash1 = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/ul/li[4]/a/i[@class=\"icon-user\"]"));
				flash1.click();

				
				//Searching Logout Button
				synchronized (driver) {
					driver.wait(15000);
					
				}
				
				//Click on Logout Button
				driver.findElement(By.xpath("//*[@id=\"logout-button\"]")).click();
				
				synchronized (driver) {
					driver.wait(4000);}
				
			}
			
			
				}





