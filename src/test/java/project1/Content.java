package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Content {
	
	
	public WebDriver driver;

	
@BeforeClass
	
	public void Arizona_home(){
		
		driver = new FirefoxDriver();
		load();
		
	}
	
	public void load() {
		
		 driver.get("https://www.nrcs.usda.gov/wps/portal/nrcs/main/az/air/");	
		 
		 driver.manage().window().maximize();
		 
      String old_content = driver.findElement(By.xpath(".//*[@id='overview']")).getText();
      System.out.println("The content is  : " +old_content);
      
    /*  String new_Content= "Air Information About Air Issues relating to agricultural emissions, carbon sequestration and production"
      		+" of crops for alternative bio-based fuel";

      String Test_Content= "Air Information About Air Issues relating to agricultural emissions, carbon sequestration and production of crops for alternative bio-based fuel";

      
      if(new_Content.equals(Test_Content)){
    	  
    	 System.out.println("both r equal");
      }
      else{
    	  System.out.println("not equals");
      }*/
}

	@Test
	
	public void content(){
		
	}
	
	

}
