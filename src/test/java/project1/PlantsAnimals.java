package project1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlantsAnimals {
	
	public static WebDriver driver;

	String AppURL="https://www.nrcs.usda.gov/wps/portal/nrcs/main/az/plantsanimals/";

	
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
		 

	       Assert.assertEquals(true, driver.getTitle().equalsIgnoreCase("Plants & Animals | NRCS Arizona"));
		 
		
       System.out.println("The browser title is : Plants & Animals | NRCS Arizona");
       
	
		//validating You Are Here items
		
		WebElement YouAreHere = driver.findElement(By.xpath(".//*[@id='traversed']"));
		
		List<WebElement>YouAreHere_items = YouAreHere.findElements(By.tagName("p"));
		
		for(int i=0; i<=YouAreHere_items.size()-1;i++){
			
			System.out.print(YouAreHere_items.get(i).getText());
			
	}
		
	}
	@Test
	public void Agri(){
driver.close();
	
	}
	}

