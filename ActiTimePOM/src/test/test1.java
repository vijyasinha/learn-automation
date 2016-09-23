package test;

import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import pages.HomePage;
import pages.LoginPage;
import utils.Excel;

public class test1 {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	
	@BeforeTest
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://online.actitime.com/vaditya/login.do");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyTitlePage() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		lp=new LoginPage(driver);
		String PageTitle=lp.getTitle();
		
		Excel excl=new Excel();
		String Username=excl.getExcelData("Sheet1",1,0);
		String Pwd=excl.getExcelData("Sheet1",1,1);
		lp.loginToActiTime(Username,Pwd);
		hp=new HomePage(driver);
		
		//enter into the Users section
		String tab="USERS";
		hp.section(tab);
		Thread.sleep(1000);
		
		
		/*
		//Assert.assertEquals(hp.logout(), "Logout","user is not loggedin properly.");
		//System.out.println("log in passed !!");
		String User=excl.getExcelData("Sheet2",0,0);
		String username=hp.selectUser(User);
		//Assert.assertEquals(username,"Me");
		hp.addTask();
	*/
		System.out.println("Test Case passed !!");
	}
	@AfterTest
	public void exit()
	{
		driver.close();
	}	

}
