package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnterTimeTrackPage {
	WebDriver driver;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void selectName()
	{
		driver.findElement(By.id("ext-gen7")).click();
		
		List<WebElement> listname = driver.findElements(By.xpath("//span[@class='userName']"));
		Iterator<WebElement> itr = listname.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
	

}
