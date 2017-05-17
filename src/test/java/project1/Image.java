package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Image extends ArizonaHeader {
	
	
	
	public WebDriver driver;
	
	@Test
	
	public void imageCheck(){
		

	driver= new FirefoxDriver();
	
	driver.get("https://www.nrcs.usda.gov/wps/portal/nrcs/site/az/home/");
	
	mouseOverTopics();
	
	driver.findElement(By.xpath(".//*[@id='topics']/li[7]/a/span")).click();
	
	
	
	
	}

}
