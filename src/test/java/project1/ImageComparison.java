package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ImageComparison {
	
	public static WebDriver driver;
	
	@Test


	
		public static void image(By By) {
			
			
			WebElement ImageFile = driver.findElement(image1);
		    
			Boolean ImagePresent = (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);    
		 
			if (!ImagePresent)
		    {
		         System.out.println("Image not displayed.");
		    }
		    else
		    {
		        System.out.println("Image displayed.");
		    }
				
				
				Dimension dimensions = driver.findElement(By).getSize();
				
				System.out.println("width is " + dimensions.width);
				
				System.out.println("height is " + dimensions.height);
				
				Point point = driver.findElement(By).getLocation();
				
		System.out.println("x position is " +point.x);
		System.out.println("y position is " +point.y);


		}
	}

}