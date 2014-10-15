package com.target.login;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import junit.framework.TestCase;

public class LoginTest extends TestCase {

	static FirefoxDriver firefoxDriver = null;

	@BeforeClass
	public static void createAndStartService() throws Exception {
		firefoxDriver = new FirefoxDriver();
	}
		
	@AfterClass
	public static void createAndStopService() {
	   
	}
		
	@Test
	public static void testLogin() {
		firefoxDriver = new FirefoxDriver();
		firefoxDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		firefoxDriver.get("http://m.target.com");
	    WebElement elem=(new WebDriverWait(firefoxDriver, 10)) //added this line
	    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'prom_signin_icon')]")));
	    
	    
	    //driver.findElement(By.xpath("//a[contains(@class,'prom_signin_icon')]"));
	    System.out.println(elem.getAttribute("id"));
	    elem.click();
	    
	    WebElement elemSignin=(new WebDriverWait(firefoxDriver, 10)) //added this line
	    	    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'gam-login')]")));
	    
	    elemSignin.click();
	    WebElement elemUsername =(new WebDriverWait(firefoxDriver, 10)) //added this line
	    	    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'logonId')]")));
	    elemUsername.sendKeys("chanduv3@gmail.com");
	    
	    WebElement elemPassword =(new WebDriverWait(firefoxDriver, 10)) //added this line
	    	    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'logonPassword')]")));
	    elemPassword.sendKeys("chandu123");
	    
	    WebElement elemSigninBtn =(new WebDriverWait(firefoxDriver, 10)) //added this line
	    	    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name,'AccountSignIn')]")));
	    
	    elemSigninBtn.click();
	    //assert elem.isDisplayed();
	    System.out.println(firefoxDriver.getTitle());
	    
	    WebElement elemMyorder=(new WebDriverWait(firefoxDriver, 10)) //added this line
	    	    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'prom_signin_icon')]")));
	    //title="my orders
	    elemMyorder.click();
	    
	    WebElement elemSigninSucess =(new WebDriverWait(firefoxDriver, 10)) //added this line
	    	    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='my orders']")));
	    elemSigninSucess.click();
	    assert elemSigninSucess.getText() == "my orders";
	}
	@Before
	public void createDriver() {
		   
	}
		
	@After
	public void quitDriver() {
		   
	}

}
