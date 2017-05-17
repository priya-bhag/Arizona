package project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Home_Page {
	
public WebDriver driver;

public Properties prop;

String Appurl ="https://www.nrcs.usda.gov/wps/portal/nrcs/site/az/home/";
	
	
	@BeforeClass
	
	public void Arizona_home() throws FileNotFoundException, IOException{
		
		driver = new FirefoxDriver();
		load();
		
	}
	
	public void load() throws FileNotFoundException, IOException {
		

		prop = new Properties();
		
		prop.load(new FileInputStream("./SharedUIMap/Home_Page.properties"));
		
		 driver.get(Appurl);	
		 
		 driver.manage().window().maximize();
		 
       Assert.assertEquals(true, driver.getTitle().equalsIgnoreCase("Home | NRCS Arizona"));
       
	   System.out.println("On the Home Arizona Page");
}

	
	
	public void Validate_menu(){
		
		String Topics =  driver.findElement(By.xpath(prop.getProperty("Topics"))).getText();

		System.out.println("The menu topic is " + Topics);
		
		String Programs  = driver.findElement(By.xpath(prop.getProperty("Programs"))).getText();
		
		System.out.println("The menu Programs is " + Programs);
		
		
		String NewsRoom = driver.findElement(By.xpath(prop.getProperty("NewsRoom"))).getText();
		
		System.out.println("The menu newsRoom is " + NewsRoom);
		
		
		String contactUS = driver.findElement(By.xpath(prop.getProperty("contactUS"))).getText();
		
		System.out.println("The menu contactUS is " + contactUS );
		
		String AboutUs = driver.findElement(By.xpath(prop.getProperty("AboutUs"))).getText();
		
		System.out.println("The menu AboutUs is " + AboutUs);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	

		
		
	}
	
	
public void mouseOverTopics(){
		
		//mouse over Topics 
		
		Actions builder=new Actions(driver);
		WebElement Topics = driver.findElement(By.xpath(prop.getProperty("Topics")));
		builder.moveToElement(Topics).build().perform();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	}
	
	
	public void Validate_TopicsMainMenu(){
		
		 mouseOverTopics();
		 
		WebElement Topics_table = driver.findElement(By.xpath(prop.getProperty("Topics_table")));
		
List<WebElement>Topics_MainMenu= Topics_table.findElements(By.tagName("li"));
		

		System.out.println("Main menu items under Topics are : =");
		
		System.out.println(" " );
		
		for(int i=0; i<=Topics_MainMenu.size()-1 ; i++)
		{
			
			System.out.println(Topics_MainMenu.get(i).getText());
		}
		
		
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);	
		
		
		
	}
		
		//expanding all the main links 
		

		public void ExpandTopics_Items(){
			
	


		
				driver.findElement(By.id("level1_hitarea_101000000000000")).click();
				
				driver.findElement(By.id("level1_hitarea_102000000000000")).click();

				driver.findElement(By.id("level1_hitarea_121000000000000")).click();

				driver.findElement(By.id("level1_hitarea_651000000000000")).click();
				driver.findElement(By.id("level1_hitarea_122000000000000")).click();

				driver.findElement(By.id("level1_hitarea_123000000000000")).click();
				driver.findElement(By.id("level1_hitarea_124000000000000")).click();
				driver.findElement(By.id("level1_hitarea_103000000000000")).click();
				
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	}
	
	public void get_text_Topics(){
		
		List<String> inputArray = new ArrayList<String>();
		
		inputArray.add("Technical Resources");
		
		
		

		List<String>  outputArray = new ArrayList<String>();
		
		//topics table webelement 
		
	WebElement Topics_table=driver.findElement(By.xpath(prop.getProperty("Topics_table")));
				
				//list out all the elements inside the table

				List<WebElement>links_Topics = Topics_table.findElements(By.tagName("li"));
				
				
				//retrieve the text 
				
				
				System.out.println("\nSub menu items under Topics are : =");
				
				System.out.println(" " );
				
			for (int j=0; j<=links_Topics.size()-1; j=j+1)
				 
			{
			
				System.out.println(links_Topics.get(j).getText());
				
				String Text = links_Topics.get(j).getText();
				
				 outputArray.add(Text);

			}
System.out.println("The output array values are " +outputArray);


//comapring content of input array and output array 


//if(inputArray.equals(o)

driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		
	}
	
	public void MouseOverPrograms(){
		
		Actions builder=new Actions(driver);
		WebElement Programs = driver.findElement(By.xpath(prop.getProperty("Programs")));
		builder.moveToElement(Programs).build().perform();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	}
	
	public void get_text_Programs(){
		
		
		WebElement Programs_table = driver.findElement(By.xpath(prop.getProperty("Programs_table")));
		List<WebElement>linksProgramTable= Programs_table.findElements(By.tagName("li"));
		

		System.out.println("Sub menu items under Programs are : =");
		
		System.out.println(" " );
		
		for(int i=0; i<=linksProgramTable.size()-1 ; i++){
			System.out.println(linksProgramTable.get(i).getText());
		}
		
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	}
	
public void MouseOverNewsRoom(){
		
		Actions builder=new Actions(driver);
		WebElement NewsRoom = driver.findElement(By.xpath(prop.getProperty("NewsRoom")));
		builder.moveToElement(NewsRoom).build().perform();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	}
	

public void get_text_NewswRoom(){
	
	
	WebElement NewsRoom_table = driver.findElement(By.xpath(prop.getProperty("NewsRoom_table")));
	
	List<WebElement>LinksNewsRoom_table= NewsRoom_table.findElements(By.tagName("li"));
	

	System.out.println("Sub menu items under NewsRoom are : =");
	
	System.out.println(" " );
	
	for(int i=0; i<=LinksNewsRoom_table.size()-1 ; i++){
		System.out.println(LinksNewsRoom_table.get(i).getText());
	}
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	
}
	
	
public void MouseOverContactUs(){
	Actions builder=new Actions(driver);
	
	WebElement ContactUs = driver.findElement(By.xpath(prop.getProperty("contactUS")));
	builder.moveToElement(ContactUs).build().perform();
	
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	
}

public void get_text_Contactus(){
	
	
	WebElement get_text_Contactus = driver.findElement(By.xpath(prop.getProperty("get_text_Contactus")));
	
	List<WebElement>LinksContactUs= get_text_Contactus.findElements(By.tagName("li"));
	

	System.out.println("Sub menu items under Contact Us are : =");
	
	System.out.println(" " );
	
	for(int i=0; i<=LinksContactUs.size()-1 ; i++){
		System.out.println(LinksContactUs.get(i).getText());
	}
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
}


public void AboutUs_validation(){
	
	driver.findElement(By.xpath(prop.getProperty("AboutUs"))).click();
	
	Assert.assertEquals(true, driver.getTitle().equalsIgnoreCase("About Us | NRCS Arizona"));
	System.out.println(" ");
	
	System.out.println("we are in the about us page");
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	
}

@Test
(priority=1)
public void check() throws InterruptedException{
	
	 Validate_menu();

	 Validate_TopicsMainMenu();
	mouseOverTopics();
	ExpandTopics_Items();
	Thread.sleep(20);
	get_text_Topics();
	MouseOverPrograms();
	get_text_Programs();
	Thread.sleep(20);
	MouseOverNewsRoom();
	Thread.sleep(20);
	get_text_NewswRoom();
	Thread.sleep(20);
	MouseOverContactUs();
	Thread.sleep(20);
	get_text_Contactus();
	AboutUs_validation();


}
}
