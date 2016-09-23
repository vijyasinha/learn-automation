package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	
	By user=By.id("ext-comp-1001");
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getUser()
	{
		String User=driver.findElement(user).getText();
		return User;
	}
	
	public void section(String sectionname) throws InterruptedException {
		
		if(sectionname.equalsIgnoreCase("USERS"))
		{
			Thread.sleep(2000);
			//sdriver.findElement(By.xpath("//*[@class='content selected users']")).click();
			driver.findElement(By.xpath("//div[contains(text(),'USERS')]")).click();
			Thread.sleep(1000);
			
			//verifying the page title
			WebElement title = driver.findElement(By.xpath("//div[@class='pagetitle']"));
			String pagetitle= title.getText();
			Assert.assertEquals(pagetitle, "User List");
			System.out.println("Admin is in user section.");
			
			driver.findElement(By.xpath("//*[@id='tabAccountSettings' and @class='tab selected']")).click();
			List<WebElement> row = driver.findElements(By.xpath("//span[@id='userListTableContainer']/table/tbody/tr"));
			int rowCount=row.size();
			//System.out.println(rowCount);
			for(int i=1;i<=rowCount;i++){
				System.out.println("Row No: "+i);
				List<WebElement> col = driver.findElements(By.xpath("//span[@id='userListTableContainer']/table/tbody/tr["+i+"]/td"));
				int colCount= col.size();
				
					String UserName = driver.findElement(By.xpath("//span[@id='userListTableContainer']/table/tbody/tr["+i+"]/td[1]//span[@class='userNameSpan']")).getText();
					System.out.println(UserName);
					
					String department = driver.findElement(By.xpath("//span[@id='userListTableContainer']/table/tbody/tr["+i+"]/td[1]//div[@class='groupName']")).getText();
					System.out.println(department);
					
					String timeZone = driver.findElement(By.xpath("//span[@id='userListTableContainer']/table/tbody/tr["+i+"]/td[1]//div[@class='timeZoneGroupName']")).getText();
					System.out.println(timeZone);
					
					System.out.println("==========================");
					
				
			}
			
		}
		else if(sectionname.equalsIgnoreCase("TASKS"))
		{
			driver.findElement(By.xpath("//div[contains(text(),'TASKS')]")).click();
			
		}
		else if(sectionname.equalsIgnoreCase("REPORTS"))
		{
			driver.findElement(By.xpath("//div[contains(text(),'REPORTS')]")).click();
			
		}

		else if(sectionname.equalsIgnoreCase("TIME-TRACK"))
		{
			driver.findElement(By.xpath("//div[contains(text(),'TIME-TRACK')]")).click();
			
		}		
		
	}
	
	public String selectUser(String name) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='ext-comp-1001']")).clear();
		driver.findElement(By.id("ext-gen7")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]")).click();
		
		Thread.sleep(10000);
		String username=driver.findElement(By.xpath("//input[@id='ext-comp-1001']")).getText();
		System.out.println(username);
		return username;
		
		/*List<WebElement> userlist = driver.findElements(By.xpath("//span[@class='userName']"));
		for(WebElement list:userlist)
		{
			if(list.getText().equalsIgnoreCase("Aditya, Vijya"))
			{
				list.click();
				break;
			}
		}*/
		
		/*driver.findElement(By.id("ext-gen7")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='ext-gen34']/div/div/span[text()='Gibson, Maurice']")).click();
		Thread.sleep(10000);*/
		
	}
	public void addTask() throws InterruptedException
	{
		//driver.findElement(By.xpath("//table[@id='recentTasksControl']/tbody/tr/td/div/span[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id='spent_29_0']")).sendKeys("8");
		driver.findElement(By.xpath("//input[@id='spent_29_1']")).sendKeys("8");
		driver.findElement(By.xpath("//input[@id='spent_29_2']")).sendKeys("8");
		driver.findElement(By.xpath("//input[@id='spent_29_3']")).sendKeys("8");
		driver.findElement(By.xpath("//input[@id='SubmitTTButton']")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='SuccessMessages']/tbody/tr/td/span['Your changes were successfully saved.']")));
				
	}
	public String logout() {
		WebElement logout = driver.findElement(By.id("logoutLink"));
		
		String logoutButton = logout.getText();
		
		return logoutButton;
	}
	

	public String username()
	{
		WebElement name = driver.findElement(By.partialLinkText("Vijya"));
		String loggedInUser=name.getText();
		return loggedInUser;
	}
}
