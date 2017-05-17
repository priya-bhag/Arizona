package project1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
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

public class TeachersandStudents {
public static WebDriver driver;
	
	String image1 =".//*[@id='anch_115']/div/img";
	String image2=".//*[@id='overview']/table/tbody/tr[2]/td[2]/div/img";
	String image3=".//*[@id='anch_121']/div/img";
			String image4=".//*[@id='overview']/table/tbody/tr[5]/td[2]/div/img";
			
			String image5=".//*[@id='overview']/table/tbody/tr[6]/td[2]/div/img";
			String image6=".//*[@id='overview']/table/tbody/tr[7]/td[2]/div/img";
			String image7=".//*[@id='overview']/table/tbody/tr[8]/td[2]/div/img";
			
			
	String AppURL="https://www.nrcs.usda.gov/wps/portal/nrcs/main/az/people/teachers/#";

	
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
		 

	       Assert.assertEquals(true, driver.getTitle().equalsIgnoreCase("Teachers and Students | NRCS Arizona"));
		 
		
       System.out.println("The browser title is : Teachers and Students | NRCS Arizona");
       
		
       String heading = driver.findElement(By.xpath(".//*[@id='overview']/h2/a")).getText();
		
		//validating heading
		
		Assert.assertEquals(true,heading.contentEquals("Teachers and Students"));
		
		System.out.println("The heading is "+ heading);
		
		//validating You Are Here items
		
		WebElement YouAreHere = driver.findElement(By.xpath(".//*[@id='traversed']"));
		
		List<WebElement>YouAreHere_items = YouAreHere.findElements(By.tagName("p"));
		
		for(int i=0; i<=YouAreHere_items.size()-1;i++){
			
			System.out.print(YouAreHere_items.get(i).getText());
			
	}
		
	}
	
	
	public static void image(String img) {
		
		
		
		WebElement ImageFile = driver.findElement(By.xpath(img));
	    
		Boolean ImagePresent = (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);    
	 
		if (!ImagePresent)
	    {
	         System.out.println("Image not displayed.");
	    }
	    else
	    {
	        System.out.println("Image displayed.");
	    }
			
			
			Dimension dimensions = driver.findElement(By.xpath(img)).getSize();
			
			System.out.println("width is " + dimensions.width);
			
			System.out.println("height is " + dimensions.height);
			
			Point point = driver.findElement(By.xpath(img)).getLocation();
			
	System.out.println("x position is " +point.x);
	System.out.println("y position is " +point.y);


	}
		
		
	
	
public void Teachers_links(){
		
		WebElement ele = driver.findElement(By.xpath(".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr/td"));
		
		List<WebElement>ele_items = ele.findElements(By.tagName("a"));
		
		System.out.println(" number of links in LandUse are "+ ele_items.size()) ;
	
		System.out.println("");
		
		System.out.println("The links in the LandUse table are  : ");
		
		System.out.println("");

			for(int i=0; i<=ele_items.size()-1;i++){
				System.out.println(ele_items.get(i).getText());
			}		
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
			
	}	

	public void Teachers_verify(){
		

		WebElement ele = driver.findElement(By.xpath(".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr/td"));
		
		List<WebElement>ele_items = ele.findElements(By.tagName("a"));
		
		System.out.println("Verifying links in the landUse  are  : ");
		
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
	
	public void CTA(){
		
		Teachers_links();
		Teachers_verify();
		image(image1);
		image(image2);
		image(image3);
		image(image4);
		image(image5);
		image(image6);
		image(image7);
		
		driver.close();
	}
	
	
	
}

