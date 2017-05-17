package project1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EcologicalScience {

	
	
	public static WebDriver driver;

String AppURL="https://www.nrcs.usda.gov/wps/portal/nrcs/main/az/technical/ecoscience/";


String title;

@BeforeClass

public void Home(){
	
	driver = new FirefoxDriver();
	title();
	
}


public void title(){
	
 driver.get(AppURL);	
	 
	 driver.manage().window().maximize();
	 
	 //validating browser title
	 
	 String title =driver.getTitle();
	 

       Assert.assertEquals(true, driver.getTitle().equalsIgnoreCase("Ecological Science | NRCS Arizona"));
	 
	
   System.out.println("The browser title is : Ecological Science | NRCS Arizona");
   
	
  
	
	//validating You Are Here items
	
	WebElement YouAreHere = driver.findElement(By.xpath(".//*[@id='traversed']"));
	
	List<WebElement>YouAreHere_items = YouAreHere.findElements(By.tagName("p"));
	
	for(int i=0; i<=YouAreHere_items.size()-1;i++){
		
		System.out.print(YouAreHere_items.get(i).getText());
		
}
	
}

@Test

public void Gis(){
	
}

}



