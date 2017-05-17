package project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConservationPlanning 




{
	
public static WebDriver driver;

String AppURL="https://www.nrcs.usda.gov/wps/portal/nrcs/main/az/technical/cp/";

public static Properties prop;



String title;
	
	@BeforeClass
	
	public void Arizona_home() throws FileNotFoundException, IOException{
		
		prop = new Properties();
		
		prop.load(new FileInputStream("./SharedUIMap/ConservationPlanning.properties"));
		
		driver = new FirefoxDriver();
		title();
		
		
	}
	
	public void title() {
		
		 driver.get(AppURL);	
		 
		 driver.manage().window().maximize();
		 
		 //validating browser title
		 
		 String title =driver.getTitle();
		 
       Assert.assertEquals(true, driver.getTitle().equalsIgnoreCase("Conservation Planning | NRCS Arizona"));
       
	   System.out.println("The browser title is : Conservation Planning | NRCS Arizona");
		
		String heading = driver.findElement(By.xpath(prop.getProperty("heading"))).getText();
		
		//validating heading
		
		Assert.assertEquals(true,heading.contentEquals("Conservation Planning"));
		
		System.out.println("The heading is "+ heading);
		
		//validating You Are Here items
		
		WebElement YouAreHere = driver.findElement(By.xpath(prop.getProperty("YouAreHere")));
		
		List<WebElement>YouAreHere_items = YouAreHere.findElements(By.tagName("p"));
		
		for(int i=0; i<=YouAreHere_items.size()-1;i++){
			
			System.out.print(YouAreHere_items.get(i).getText());
			
	}
		
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
}


public static void image() {
	
	
	
	WebElement ImageFile = driver.findElement(By.xpath(prop.getProperty("image")));
    
	Boolean ImagePresent = (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);    
 
	if (!ImagePresent)
    {
         System.out.println("Image not displayed.");
    }
    else
    {
        System.out.println("Image displayed.");
    }
		
		
		Dimension dimensions = driver.findElement(By.xpath(prop.getProperty("image"))).getSize();
		
		System.out.println("width is " + dimensions.width);
		
		System.out.println("height is " + dimensions.height);
		
		Point point = driver.findElement(By.xpath(prop.getProperty("image"))).getLocation();
		
System.out.println("x position is " +point.x);
System.out.println("y position is " +point.y);


}
	
	
	public void ConserPlan_links(){
		
		WebElement ele = driver.findElement(By.xpath(prop.getProperty("conservationPlanning_table")));
		
		List<WebElement>ele_items = ele.findElements(By.tagName("a"));
		
		System.out.println(" number of links in Cp are "+ ele_items.size()) ;
		
		System.out.println("");
		
		System.out.println("The links in the Conservation planning table are  : ");
		
		System.out.println("");

			for(int i=0; i<=ele_items.size()-1;i++){
				System.out.println(ele_items.get(i).getText());
			}		
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
			
	}	

	public void Check_links_InCp(){
		

		WebElement ele = driver.findElement(By.xpath(prop.getProperty("conservationPlanning_table")));
		
		List<WebElement>ele_items = ele.findElements(By.tagName("a"));
		
		System.out.println("Verifying links in the  Conservation planning table are  : ");
		
		System.out.println("");

			for(int i=0; i<=ele_items.size()-1;i++){
				
				WebElement element = ele_items.get(i);
				
				String url=element.getAttribute("href");
				verifyLinkActive(url);
				
	}
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	}

	public void verifyLinkActive(String linkUrl){
		
		try 
	    {
	       URL url = new URL(linkUrl);
	       
	       HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	       
	       httpURLConnect.setConnectTimeout(3000);
	       
	       httpURLConnect.connect();
	       
	       if(httpURLConnect.getResponseCode()==200)
	       {
	           System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	        }
	       
	       if(!(httpURLConnect.getResponseCode()==200)){
	    	   System.out.println(linkUrl+"-"+httpURLConnect.getResponseMessage());
	       }
	      if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
	       {
	           System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	        }
	    } catch (Exception e) {
	       
	    }
	} 

	

	@Test
	
	public void conserv_planning(){
	
		
		ConserPlan_links();
		Check_links_InCp();
	
		image();
	
		
	}
	

}
