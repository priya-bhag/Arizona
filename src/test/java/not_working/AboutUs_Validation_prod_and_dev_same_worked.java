package not_working;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AboutUs_Validation_prod_and_dev_same_worked {


	public static WebDriver driver;

	String AppURL1="https://www.nrcs.usda.gov/wps/portal/nrcs/main/az/about/";
    String AppURL2="https://www.nrcs.usda.gov/wps/portal/nrcs/main/az/about/";
	
    public static By heading1 = By.xpath(".//*[@id='overview']/h2/a");
    public static By heading2 = By.xpath(".//*[@id='overview']/h2/a");

    
    public static By YouAreHere1 =By.xpath(".//*[@id='traversed']");
    public static By YouAreHere2 =By.xpath(".//*[@id='traversed']");

  String verify_body1=".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr/td";
  String verify_body2=".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr/td";
  
  String title;
  String title1;
  String url;
	
	public Collection<?> inputArray;
	public Collection<?> outputArray;
	int i;
	int j;
	
	String a;

	@BeforeMethod

	public void Home(){
		
		driver = new FirefoxDriver();
	}


	
	@Test(priority=1)
	public void title() throws InterruptedException{
		
	 driver.get(AppURL1);	
		 
	 
		 driver.manage().window().maximize();
		 
		 //validating browser title
		 
		 String title =driver.getTitle();
		 

	       Assert.assertEquals(true, driver.getTitle().equalsIgnoreCase("About Us | NRCS Arizona"));
		 
		
	   System.out.println("The browser title is :About Us | NRCS Arizona");
	   
		
	   String heading = driver.findElement(heading1).getText();
		
		//validating heading
		
		Assert.assertEquals(true,heading.contentEquals("About Us"));
		
		System.out.println("The heading is "+ heading);
		
	List<String> outputArray = new ArrayList<String>();


		//validating You Are Here items
		
		WebElement YouAreHere = driver.findElement(YouAreHere1);
		
		List<WebElement>YouAreHere_items = YouAreHere.findElements(By.tagName("p"));
		
		for(int i=0; i<=YouAreHere_items.size()-1;i++){
			
			System.out.print(YouAreHere_items.get(i).getText());

			String Text = YouAreHere_items.get(i).getText();
			
			 outputArray.add(Text);

		}
System.out.println("The output array values are " +outputArray);
	
			driver.navigate().to(AppURL2);
		 
			 driver.manage().window().maximize();
			 
			 //validating browser title
			 
			 String title1 =driver.getTitle();
			 
			 System.out.println("The title of url2 is "+title1);
			 
			 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 

			 Assert.assertEquals(title,title1);
			 
			 System.out.println("title are equal");
			 
			 
			String heading3 = driver.findElement(heading2).getText();
			
			
			 Assert.assertEquals(heading, heading3);
			 
			 System.out.println("heading are same");
			
			 
			 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS); 

			 
				WebElement YouAreHere1 = driver.findElement(YouAreHere2);
				List<String> inputArray = new ArrayList<String>();
				List<WebElement>YouAreHere_items1 = YouAreHere1.findElements(By.tagName("p"));
				
				for(int j=0; j<=YouAreHere_items1.size()-1;j++){
					
					System.out.print(YouAreHere_items1.get(j).getText());

					String Text = (YouAreHere_items1.get(j).getText());
					
					 inputArray.add(Text);

				}
				
				 String[] arrayA = null;
				 String[] arrayB = null;
				
				if (inputArray.size() > 0 )
				{
			    arrayA =inputArray.toArray(new String[inputArray.size()]);
			   	}
				if ( outputArray.size() > 0 )
				{
				arrayB =  outputArray.toArray(new String[outputArray.size()]);
				}
		      
				
		        boolean foundSwitch = false;
		    
		      try {
		          if (arrayA != null )
		           {
		            for(int K = 0; K < arrayA.length; K++)
		            {
		             	if(arrayB!=null)
		    	       {
		                 for (int j = 0; j < arrayB.length;j++)
		                 {
		                   if( arrayA[K].equals(arrayB[j]))
		                    {
		                    foundSwitch = true;
		                    System.out.println("elements in both array YOU ARE HERE are same " + foundSwitch);
		                     }
		                  }
		    	       }
		            }
		         
		           }
		      }catch(Exception e){
		    	  
		      }
			    

	WebElement ele = driver.findElement(By.xpath(verify_body1));
	
	List<WebElement>ele_items = ele.findElements(By.tagName("a"));
		
		System.out.println("\n number of links in the first url1 are "+ ele_items.size()) ;
		
		List<String> inputArray2 = new ArrayList<String>();
		
		
		ele_items.addAll(ele.findElements(By.tagName("img")));
		
	
			for(int i=0; i<=ele_items.size()-1;i++){
				
				WebElement element = ele_items.get(i);
				
				String url=element.getAttribute("href");
				
				
				  if(element.getAttribute("href") != null){
					  
						inputArray2.add(url);
				
						verifyLinkActive(url);

				  }
					


			}
			
			System.out.println("elements in array url1 are" +inputArray2);
			
			
	
	


	  
				 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS); 
				 
		

					driver.navigate().to(AppURL1);
					
					
					 driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
					 
					 
					WebElement ele1 = driver.findElement(By.xpath(verify_body2));
					
					List<WebElement>ele_items1 = ele1.findElements(By.tagName("a"));
						
						System.out.println("\n number of links in the second url2 are "+ ele_items1.size()) ;
						
						List<String> outputArray2 = new ArrayList<String>();
						
						ele_items1.addAll(ele1.findElements(By.tagName("img")));
						
					
							for(int j=0; j<=ele_items1.size()-1;j++){
								
								WebElement element1 = ele_items1.get(j);
								
								String url1=element1.getAttribute("href");
								
								
								
								  if(element1.getAttribute("href") != null){
					
										outputArray2.add(url1);

								verifyLinkActive(url1);
								

								}
							}
								  
									System.out.println("elements in array url2 are" +outputArray2);

								  
									 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS); 

							
							 String[] arrayC = null;
							 String[] arrayD = null;
							
							if (inputArray2.size() > 0 )
							{
						    arrayC =inputArray2.toArray(new String[inputArray2.size()]);
						   	}
							if ( outputArray2.size() > 0 )
							{
							arrayD =  outputArray2.toArray(new String[outputArray2.size()]);
							}
					      
							
					        boolean foundSwitch1 = false;
					    
					      try {
					          if (arrayC != null )
					           {
					            for(int K = 0; K < arrayC.length; K++)
					            {
					             	if(arrayD!=null)
					    	       {
					                 for (int j = 0; j < arrayD.length;j++)
					                 {
					                   if( arrayC[K].equals(arrayD[j]))
					                    {
					                    foundSwitch1 = true;
					                     }
					                  
					                 }
					                    System.out.println("elements in both array URL are  " + foundSwitch1);

					    	       }
					            }
					         
					           }
					      }catch(Exception e){
					    	  
					      }
						    
				

}

	
	
	public void verifyLinkActive(String linkUrl) throws InterruptedException{
		
		try 
	    {
			//System.setProperty("java.net.preferIPv4Stack" , "true");
			
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
		Thread.sleep(10);
	} 
	
	@AfterClass
	
	public void test(){
		
		//driver.close();
	}
}
