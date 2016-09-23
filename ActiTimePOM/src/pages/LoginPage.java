package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	
	WebDriver driver;
	By actiUsername = By.name("username");
	By actiPwd = By.name("pwd");
	By loginBtn = By.id("loginButton");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setUserName(String strUserName)
	{
		driver.findElement(actiUsername).sendKeys(strUserName);
	}
	
	public void setPwd(String strPwd)
	{
		driver.findElement(actiPwd).sendKeys(strPwd);
	}
	public void clickLogin()
	{
		driver.findElement(loginBtn).click();
	}
	
	public String getTitle()
	{
		String pageTitle=driver.getTitle();
		return pageTitle;
	}
	
	public void loginToActiTime(String strUserName,String strPwd)
	{
		this.setUserName(strUserName);
		this.setPwd(strPwd);
		this.clickLogin();
	}

}
