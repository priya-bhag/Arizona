package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ArizonaHeaderPage extends ArizonaHeader{
	 
		
		public static By Topics = By.xpath(".//*[@id='nav']/li[2]/a");
		

		public static By Programs = By.xpath(".//*[@id='nav']/li[4]/a");

		public static By NewsRoom = By.xpath(".//*[@id='nav']/li[2]/a");

		public static By ContactUs = By.xpath(".//*[@id='nav']/li[2]/a");

		public static By AboutUs = By.xpath(".//*[@id='top_nav']/ul/li[1]/a");
		
		
				
		public ArizonaHeaderPage(WebDriver driver) {
			super(driver);
			
		}
		
		protected boolean isLoaded() {
			System.out.println(driver.getTitle());
			return driver.getTitle().equalsIgnoreCase("Home | NRCS Arizona");
		}
		
		
		
		protected void load() {
			 driver.get("https://www.nrcs.usda.gov/wps/portal/nrcs/site/az/home/");			
				   driver.getTitle().equalsIgnoreCase("Home | NRCS Arizona");	 
				   Assert.assertEquals(true,
						  driver.getTitle().equalsIgnoreCase("Home | NRCS Arizona"));
		 System.out.println("on the Home Arizona Page");
}
		
		public boolean isElementPresent(By by) {
			  try {
			   driver.findElement(by);
			   return true;
			  } catch (org.openqa.selenium.NoSuchElementException e) {
			   return false;
			  }
	}
		public void checkPageIsReady() { 
		 	JavascriptExecutor js = (JavascriptExecutor)driver; 
		 	if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		 	
		 	for (int i=0; i<25; i++){ try { Thread.sleep(1000); }catch (InterruptedException e) {} 
		 	if (js.executeScript("return document.readyState").toString().equals("complete"))
		 	{ break; 
		 	}
		 	} } }
	 
	}
	

