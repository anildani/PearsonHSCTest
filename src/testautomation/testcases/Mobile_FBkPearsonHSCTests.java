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
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
public class Mobile_FBkPearsonHSCTests {
	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
		
	public static int index=0;
	private static String browserchoice;
//	@RunWith(Parameterized.class)
//	public class TestGoogleBase extends SeleneseTestBase {
	   
	public Mobile_FBkPearsonHSCTests(String opt){
		//index++;
		browserchoice=opt;
		 // System.out.println("index"+index);

	  // System.out.println("opt"+opt);
	  }
	 
	  @Parameters
	   public static Collection<Object[]> data() {
	   
		//Object[][] data = new Object[][] {{"1"},{"2"},{"3"},{"4"},{"5"},{"6"}};
		 //Object[][] data = new Object[][] {{"2"},{"3"},{"4"}};
		   Object[][] data = new Object[][] {{"5"},{"6"}};
		//Object[][] data = new Object[][] {{"6"}};
	    return Arrays.asList(data);

	   }
	
	
		private String baseUrl;
		
	private RemoteWebDriver driver = null;
		//static WebDriver driver;}
		
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
		
			//Launch 
			baseUrl ="http://p-pearson-hsc.herokuapp.com/";
			//baseUrl ="https://www.facebook.com/login.php?api_key=443347489063227&skip_api_login=1&display=popup&cancel_url=http%3A%2F%2Fstatic.ak.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D18%23cb%3Df14611479b1713e%26origin%3Dhttp%253A%252F%252Fp-pearson-hsc.herokuapp.com%252Ff3d89c9a4f464c6%26domain%3Dp-pearson-hsc.herokuapp.com%26relation%3Dopener%26frame%3Df33c0754db684c4%26error_reason%3Duser_denied%26error%3Daccess_denied%26error_description%3DThe%2Buser%2Bdenied%2Byour%2Brequest.&fbconnect=1&next=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Fpermissions.request%3F_path%3Dpermissions.request%26app_id%3D443347489063227%26redirect_uri%3Dhttp%253A%252F%252Fstatic.ak.facebook.com%252Fconnect%252Fxd_arbiter.php%253Fversion%253D18%2523cb%253Df14611479b1713e%2526origin%253Dhttp%25253A%25252F%25252Fp-pearson-hsc.herokuapp.com%25252Ff3d89c9a4f464c6%2526domain%253Dp-pearson-hsc.herokuapp.com%2526relation%253Dopener%2526frame%253Df33c0754db684c4%26sdk%3Djoey%26display%3Dpopup%26response_type%3Dtoken%252Csigned_request%26domain%3Dp-pearson-hsc.herokuapp.com%26perms%3Demail%252Cuser_likes%26fbconnect%3D1%26from_login%3D1%26client_id%3D443347489063227&rcount=1";
			//baseUrl="http://m.facebook.com/login.php?app_id=443347489063227&sdk=joey&skip_api_login=1&cancel=http%3A%2F%2Fstatic.ak.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D18%23cb%3Df3d17f4384%26origin%3Dhttp%253A%252F%252Fp-pearson-hsc.herokuapp.com%252Ff20db6c63%26domain%3Dp-pearson-hsc.herokuapp.com%26relation%3Dopener%26frame%3Df391549ab4%26error_reason%3Duser_denied%26error%3Daccess_denied%26error_description%3DThe%2Buser%2Bdenied%2Byour%2Brequest.&fbconnect=1&next=https%3A%2F%2Fm.facebook.com%2Fdialog%2Fpermissions.request%3F_path%3Dpermissions.request%26app_id%3D443347489063227%26redirect_uri%3Dhttp%253A%252F%252Fstatic.ak.facebook.com%252Fconnect%252Fxd_arbiter.php%253Fversion%253D18%2523cb%253Df3d17f4384%2526origin%253Dhttp%25253A%25252F%25252Fp-pearson-hsc.herokuapp.com%25252Ff20db6c63%2526domain%253Dp-pearson-hsc.herokuapp.com%2526relation%253Dopener%2526frame%253Df391549ab4%26sdk%3Djoey%26display%3Dtouch%26response_type%3Dtoken%252Csigned_request%26domain%3Dp-pearson-hsc.herokuapp.com%26perms%3Demail%252Cuser_likes%26fbconnect%3D1%26from_login%3D1%26client_id%3D443347489063227&rcount=1&_rdr";
			
			driver.get(baseUrl + "/#/home");	
			//driver.get(baseUrl);
			//String title = driver.getTitle();
			//System.out.println("Windows Name = "+title);
			
			 //Store the current window handle
			//String winHandleBefore = driver.getWindowHandle();
						
			
			   //Perform the click operation that opens new window
			driver.findElement(By.xpath("//button[@id=\"facebook-login\"]")).click();
			   synchronized (driver) {
					driver.wait(8000);
					
				}
			   
			   Set <String> handles =driver.getWindowHandles();
			   Iterator<String> it = handles.iterator();
			   //iterate through your windows
			   while (it.hasNext()){
			   String parent = it.next();
			   String newwin = it.next();
			  // String title = driver.getTitle();
			  // System.out.println("Title for multi window="+title);
			   
			   driver.switchTo().window(parent);
			   
			
			   
			 //Switch to new window opened
			/*
		    for(String winHandle1 : driver.getWindowHandles()){
	           driver.switchTo().window(winHandle1);}
	           */
		    //String title2= driver.getTitle();
		    //System.out.println("Windows Title 2="+title2);
		    
		//	driver.switchTo().window("Log In | Facebook");
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys("comprodelhi@gmail.com ");
			driver.findElement(By.name("pass")).clear();
			driver.findElement(By.name("pass")).sendKeys("pearsonhsc");
			driver.findElement(By.name("login")).click();
			//driver.close();
			synchronized (driver) {
				driver.wait(8000);
				
			}
		     //Switch back to original browser (first window)

	      // driver.switchTo().window(winHandleBefore);
	       
	        //continue with original browser (first window)
			//String title1 = driver.getTitle();
			//System.out.println("Title for multi window aftre facebook loing="+title1);
			driver.switchTo().window(newwin);}
		
		
	        synchronized (driver) {
				driver.wait(4000);
				
			}
			//Verify discipline page has launched
			//Verify 1st Discipline
			WebElement Discipline1 = driver.findElement(By.xpath("//span[text()=\"Criminal Justice\"]"));
			String str_disc1 = Discipline1.getText();
			System.out.println("Discipline 1 = "+str_disc1);
		
			assertEquals("Criminal Justice", str_disc1);
			
			//Verify Last Discipline
			WebElement Discipline2 = driver.findElement(By.xpath("//span[text()=\"Trades\"]"));
			String str_disc2 = Discipline2.getText();
			System.out.println("Discipline 2 = "+str_disc2);
		
			assertEquals("Trades", str_disc2);
			
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
		
			assertEquals("CJ Today, 12/e", str_prd1);
			
			//Verify Last Product
			WebElement Product2 = driver.findElement(By.xpath("//span[text()=\"Criminal Law Today, 5/e\"]"));
			String str_prod2 = Product2.getText();
			System.out.println("Product 2 = "+str_prod2);
		
			assertEquals("Criminal Law Today, 5/e", str_prod2);
			
			//Open book "Criminal Justice Today, 12e" 
			WebElement flash2 = driver.findElement(By.xpath("//span[text()=\"CJ Today, 12/e\"]"));
			flash2.click();

			
			synchronized (driver) {
				driver.wait(4000);
				
			}
			//Verify that product page has launched.
			WebElement audio3 = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[4]/div/div[3]/div[2]/ul/li[3]/a"));
			String str_aud3 = audio3.getText();
			System.out.println("Audio 3 = "+str_aud3);
		
			assertEquals("3 Driving Sell Thru", str_aud3);
			
			
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
	
			assertEquals("btn radio-control active correct-ans", str);
						
			//Click on Next button to move Q#2
			
			WebElement flash5 = driver.findElement(By.xpath("//button[text()=\"Next\"]"));
			flash5.click();

				//Clicking on Profile Icon
				WebElement flash1 = driver.findElement(By.xpath("//i[@class=\"icon-user\"]"));
				flash1.click();
				synchronized (driver) {
					driver.wait(9000);
					
				}
				//Verify the user name
				WebElement username = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/div[2]/div/div/div/div/div/div[2]/p"));
				String User = username.getText();
				System.out.println("User Name="+User);
				//assertEquals("Compro Delhi", User);
				AssertionTest.assertjob(driver, User, "Compro Delhi");
				//Verify the email id
				WebElement emailid = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/div[2]/div/div/div/div/div/div[2]/p[2]"));
				String email = emailid.getText();
				System.out.println("Email ID ="+email);
				AssertionTest.assertjob(driver, email, "comprodelhi1@gmail.com");
				//assertEquals("comprodelhi@gmail.com", email);
				
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





