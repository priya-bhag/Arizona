package project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Technical_Resources {
	
	
	public WebDriver driver;
	
	String content;
	
	public Properties prop;
	
	String Appurl="https://www.nrcs.usda.gov/wps/portal/nrcs/main/az/technical/";
	
	@BeforeClass
	
	public void Arizona_home() throws FileNotFoundException, IOException{
		
		driver = new FirefoxDriver();
		
	Home();
		
	}
	
	
	public void Home() throws FileNotFoundException, IOException{
		
		 driver.get(Appurl);
		 
		 prop = new Properties();
			
			prop.load(new FileInputStream("./SharedUIMap/Technical_Resources.properties"));
			
		 
		 driver.manage().window().maximize();
		 
		 //Validate browser title
		 
       Assert.assertEquals(true, driver.getTitle().equalsIgnoreCase("Technical Resources | NRCS Arizona"));
       
	   System.out.println("The browser title is Technical Resources | NRCS Arizona");
	   
		//validate browser heading 
	   
		String title = driver.findElement(By.xpath(prop.getProperty("title"))).getText();
		
		if(title.contentEquals("Technical Resources")){
			
			System.out.println("The heading is " + title);
		}
		
		//validating You Are Here items
		
		WebElement YouAreHere = driver.findElement(By.xpath(prop.getProperty("YouAreHere")));
		
		List<WebElement>YouAreHere_items = YouAreHere.findElements(By.tagName("p"));
		
		for(int i=0; i<=YouAreHere_items.size()-1;i++){
			System.out.print(YouAreHere_items.get(i).getText());
			
		}		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		
}
	
public void TechnicalResources_table() throws InterruptedException{
	
	driver.findElement(By.xpath(".//*[@id='firstElement']/div")).click();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
	driver.findElement(By.xpath(".//*[@id='selectedTree']/ul/li[2]/div")).click();
	Thread.sleep(10);
	driver.findElement(By.xpath(".//*[@id='selectedTree']/ul/li[3]/div")).click();
	Thread.sleep(10);
	driver.findElement(By.xpath(".//*[@id='selectedTree']/ul/li[5]/div")).click();
	Thread.sleep(10);
	driver.findElement(By.xpath(".//*[@id='selectedTree']/ul/li[6]/div")).click();
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	
	
}

public void TechnicalResources_TableElements(){
	
	WebElement Table_elements = driver.findElement(By.xpath(prop.getProperty("Table_elements")));
	
List<WebElement>Table_elements_items = Table_elements.findElements(By.tagName("li"));

//System.out.println("");

System.out.println("\nThe Technical Resources table elements are  : ");

	for(int i=0; i<=Table_elements_items.size()-1;i++){
		System.out.println(Table_elements_items.get(i).getText());
	}
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	
}

public void content_text(){
	
	String content = driver.findElement(By.xpath(".//*[@id='overview']")).getText();
	
}




public void TechResLinkText(){
	
	WebElement ele = driver.findElement(By.xpath(prop.getProperty("ele")));
	
	List<WebElement>ele_items = ele.findElements(By.tagName("a"));
	
	System.out.println(" number of links in TEchREs are "+ ele_items.size()) ;
	
	System.out.println("");
	
	System.out.println("The links in the Technical Research  table are  : ");
	
	System.out.println("");

		for(int i=0; i<=ele_items.size()-1;i++){
			
			System.out.println(ele_items.get(i).getText());
		}		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		
}


public void TechResLinks(){
	
	WebElement ele = driver.findElement(By.xpath(prop.getProperty("ele")));
	
	List<WebElement>ele_items = ele.findElements(By.tagName("a"));
	
	System.out.println("The links in the Technical Research table are  : ");
	
	System.out.println("");

		for(int i=0; i<=ele_items.size()-1;i++){
			
			WebElement element = ele_items.get(i);
			
			String url=element.getAttribute("href");
			verifyLinkActive(url);
			
}
	
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
	(priority=1)
	public void check() throws InterruptedException{

		TechnicalResources_table();
		TechnicalResources_TableElements();
		TechResLinkText();
		TechResLinks();
		
	}
	
	
}
