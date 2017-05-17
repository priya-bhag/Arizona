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

public class Economics {
	
	public static WebDriver driver;

	String AppURL="https://www.nrcs.usda.gov/wps/portal/nrcs/main/az/technical/dma/econ/";

	
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
		 

	       Assert.assertEquals(true, driver.getTitle().equalsIgnoreCase("Economics | NRCS Arizona"));
		 
		
       System.out.println("The browser title is : Economics | NRCS Arizona");
       
		
       String heading = driver.findElement(By.xpath(".//*[@id='overview']/h2/a")).getText();
		
		//validating heading
		
		Assert.assertEquals(true,heading.contentEquals("Economics"));
		
		System.out.println("The heading is "+ heading);
		
		//validating You Are Here items
		
		WebElement YouAreHere = driver.findElement(By.xpath(".//*[@id='traversed']"));
		
		List<WebElement>YouAreHere_items = YouAreHere.findElements(By.tagName("p"));
		
		for(int i=0; i<=YouAreHere_items.size()-1;i++){
			
			System.out.print(YouAreHere_items.get(i).getText());
			
	}
		
	}
public void Economis_links(){
		
		WebElement ele = driver.findElement(By.xpath(".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr/td"));
		
		List<WebElement>ele_items = ele.findElements(By.tagName("a"));

		System.out.println("");
		
		System.out.println(" number of links in economics are "+ ele_items.size()) ;
	
		System.out.println("");
		
		System.out.println("The links in the economics table are  : ");
		
		System.out.println("");

			for(int i=0; i<=ele_items.size()-1;i++){
				System.out.println(ele_items.get(i).getText());
			}		
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
			
	}	

	public void Check_links_InEconomics(){
		

		WebElement ele = driver.findElement(By.xpath(".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr/td"));
		
		List<WebElement>ele_items = ele.findElements(By.tagName("a"));
		
		System.out.println("Verifying links in the  economics are  : ");
		
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
	
	public void economis(){
		Economis_links();
		Check_links_InEconomics();
	}

}
