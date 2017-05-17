package project1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CIGProjectSearch {
	public static WebDriver driver;

	String AppURL="https://www.nrcs.usda.gov/wps/portal/nrcs/ciglanding/az/programs/financial/cig/cigsearch/";


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
		 

	       Assert.assertEquals(true, driver.getTitle().equalsIgnoreCase("CIG Project Search | NRCS Arizona"));
		 
		
	   System.out.println("The browser title is :CIG Project Search | NRCS Arizona");
	   
		
	   String heading = driver.findElement(By.xpath(".//*[@id='cigSearch']/h2")).getText();
		
		//validating heading
		
		Assert.assertEquals(true,heading.contentEquals("CIG Project Search"));
		
		System.out.println("The heading is "+ heading);
		
		//validating You Are Here items
		
		WebElement YouAreHere = driver.findElement(By.xpath(".//*[@id='traversed']"));
		
		List<WebElement>YouAreHere_items = YouAreHere.findElements(By.tagName("p"));
		
		for(int i=0; i<=YouAreHere_items.size()-1;i++){
			
			System.out.print(YouAreHere_items.get(i).getText());
			
			
	}
		
	}

	
	public void Ui_elements(){
		List<WebElement>el=driver.findElements(By.xpath(".//*[@id='cigSearch']/table/tbody/tr[4]/td[2]/div")) ;
		
		for(int i=0; i<=el.size()-1; i++){
			System.out.println("Search By Grant Type are " + el.get(i).getText());
		}
	}
		
		public void text(){
WebElement el1=driver.findElement(By.xpath(".//*[@id='cigSearch']/table/tbody/tr[10]/td[2]/ul")) ;

List<WebElement>items  = el1.findElements(By.tagName("li"));
		
		for(int i=0; i<=items.size()-1; i++){
			System.out.println("SResource Concern(s) are " +items.get(i).getText());
		}
		
		
		
		
		
		
		
		}
		
		public void drop_down(){
			Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='projState']")));
			List<WebElement>e2=dropdown.getOptions();
			for(int i=0;i<=e2.size()-1;i++){
				System.out.println("Project Activity State/Territory "+e2.size());
				System.out.println("Project Activity State/Territory "+e2.get(i).getText());
			}
			
		}

		public void drop_down1(){
			Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='projEcoReg']")));
			List<WebElement>e2=dropdown.getOptions();
			for(int i=0;i<=e2.size()-1;i++){
				System.out.println("Project Ecoregion(s) "+e2.size());
				System.out.println("Project Ecoregion(s)  "+e2.get(i).getText());
			}
			
		}
	

		public void drop_down2(){
			Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='awardYear']")));
			List<WebElement>e2=dropdown.getOptions();
			for(int i=0;i<=e2.size()-1;i++){
				System.out.println("Award Year  "+e2.size());
				
				System.out.println("Award Year  "+e2.get(i).getText());
			}
			
		}
	


	
	public void CIGProjectSearch_links(){
		
		WebElement ele = driver.findElement(By.xpath(".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td"));
		
		List<WebElement>ele_items = ele.findElements(By.tagName("a"));

		System.out.println("");
		
		System.out.println(" number of links in CIGProjectSearch are "+ ele_items.size()) ;

		System.out.println("");
		
		System.out.println("The links in the CIGProjectSearch table are  : ");
		
		System.out.println("");

			for(int i=0; i<=ele_items.size()-1;i++){
				System.out.println(ele_items.get(i).getText());
			}		
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
			
	}	

	public void Check_links_InCIGProjectSearch(){
		

		WebElement ele = driver.findElement(By.xpath(".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td"));
		
		List<WebElement>ele_items = ele.findElements(By.tagName("a"));
		
		System.out.println("Verifying links in the CIGProjectSearch are  : ");
		
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

	public void NationsRes(){
		Ui_elements();
		text();
		drop_down();
		drop_down1();
		drop_down2();
		CIGProjectSearch_links();
		Check_links_InCIGProjectSearch();
		driver.close();
	}
	}




