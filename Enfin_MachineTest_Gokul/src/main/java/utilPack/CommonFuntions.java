package utilPack;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.sun.tools.javac.util.List;

import jdk.internal.vm.annotation.Hidden;

public class CommonFuntions 
{	 

		protected static WebDriver driver;
		WebElement webElement;
		List<WebElement> webElements;
		Assert asrt;
		JavascriptExecutor js;
		Select select;
		String data;
		int exitVal;
		public CommonFuntions(WebDriver driver) 
		{
			this.driver=driver;	
		}
		   
		public void buttonClick(By locator) {
			WebDriverWait wait = getWait();
		   wait.until(ExpectedConditions.elementToBeClickable(locator));
			webElement =driver.findElement(locator);
			highLighterMethod(driver, webElement);
			webElement.click();
		}

		

		public void setData(By locator, String text) {
			WebDriverWait wait = getWait();
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			webElement =driver.findElement(locator);
			highLighterMethod(driver, webElement);
			webElement.clear();
			webElement.sendKeys(text);
			
		}
	
		public String GetText(By locator) {
			WebDriverWait wait = getWait();
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			webElement =driver.findElement(locator);
			data = webElement.getText();
			return data;
		}		
		
		
		public void validateText(By locator,String expectedText) {
			WebDriverWait wait = getWait();
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			webElement = driver.findElement(locator);
			String actualText = webElement.getText();
			asrt.assertEquals(actualText, expectedText);	
			
		}
		
		
	   public boolean validateText(By locator) {
		    WebDriverWait wait = getWait();	    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			webElement = driver.findElement(locator);
			boolean status = webElement.isDisplayed();
			asrt.assertTrue(status);
			return status;		
		}


		public WebDriverWait getWait() {   //explicit wait
	 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			//	wait.pollingEvery(250,TimeUnit.MILLISECONDS);                //WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.ignoring(NoSuchElementException.class);                 // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return wait;
	 
		}	
	  
	   public void excuteJsClick(By locator) {
		   
		    js = (JavascriptExecutor)driver;
		    WebDriverWait wait = getWait();
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			webElement =driver.findElement(locator);
			highLighterMethod(driver, webElement);
		    js.executeScript("arguments[0].click();", webElement);
	   }	
	   
	   public void highLighterMethod(WebDriver driver, WebElement element)
	   {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   String bgColor = element.getCssValue("backgroundColor");
		   js.executeScript("arguments[0].setAttribute('style', 'background: "+bgColor+"; border: 2px solid red;');", element);
	   }

	        /// <summary>
	 		/// To create a random string without Numbers by passing number of characters
	 		/// </summary>
	 		public static String CreateRandomWithoutNumbers(int n)
	 		{
	 	
	 			// choose a Character random from this String
	 			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	 					+ "abcdefghijklmnopqrstuvxyz";
	 	
	 			// create StringBuffer size of AlphaNumericString
	 			StringBuilder sb = new StringBuilder(n);
	 	
	 			for (int i = 0; i < n; i++) {
	 	
	 				// generate a random number between
	 				// 0 to AlphaNumericString variable length
	 				int index
	 				= (int)(AlphaNumericString.length()
	 						* Math.random());
	 	
	 				// add Character one by one in end of sb
	 				sb.append(AlphaNumericString
	 						.charAt(index));
	 			}
	 	
	 			return sb.toString();
	 		}
	 		/// <summary>
	 		/// Get Value
	 		/// </summary>
	 		public String GetValue(By locator) {
	 			WebDriverWait wait = getWait();
	 			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 			webElement =driver.findElement(locator);
	 			data = webElement.getAttribute("value");
	 			return data;
	 		}
	 		
	 		/// <summary>
	 		/// isExists Validation
	 		/// </summary>
	 		public boolean isExists(By locator) {
	 			boolean status= false;
	 			WebDriverWait wait = getWait();
	 			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 	 
	 			try {
	 				webElement = driver.findElement(locator);
	 				if(webElement.isDisplayed())
	 					status=true;
	 				return status;
	 			}
	 			catch(Exception e) {
	 				e.printStackTrace();
	 				return status;
	 			}
	 	 
	 		}
	 	 
	
	 
}
