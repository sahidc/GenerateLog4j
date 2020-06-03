package com.qa.Test;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class loginTest {
	public WebDriver d;
	Logger log=Logger.getLogger(loginTest.class);
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        d=new ChromeDriver();
        log.info("Launching Chrome Browser");
        d.manage().window().maximize();
        d.manage().deleteAllCookies();
        d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        d.get("https://classic.freecrm.com/index.html");
        log.info("Site is opening");
        log.warn("This is a warning");
        log.fatal("This is a fatal messege");
	}
	@AfterMethod
	public void tearDown() {
		d.quit();
		log.info("Closing browser");
	}
	@Test(priority=1)
	public void TitleTextTest() throws InterruptedException {
		String title=d.getTitle();
		log.info("Getting Title");
		Assert.assertEquals(title, "CRMPRO CRM Software for customer relationship management, sales and support.");
		Thread.sleep(3000);
	}
   @Test(priority=1)
   public void isDisplayedLogo() {
	   boolean b=d.findElement(By.xpath("/html/body/div[2]/div/div[1]/a/img")).isDisplayed();
	   Assert.assertTrue(b);
	   
   }
}
