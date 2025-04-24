package Test;
 
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
 
import TestData.CommonData;
import objectRepository.LoginPage_Obj;
import objectRepository.LoginPage_Obj;
import utilPack.CommonFuntions;
 
 
public class Login extends CommonFuntions {
	 
	CommonFuntions CommonPage;
	 Assert asrt;
	
	 public Login(WebDriver driver)
	 {
		super(driver);
		CommonPage = new CommonFuntions(driver);
	 }
	 
	 public void Demoblaze_Login() 
	 {
		 Login loginpage=new Login(driver);	 
		 LoginPage_Obj loginPageObj=new LoginPage_Obj();
		 CommonFuntions commonfunctions=new CommonFuntions(driver); 
		 
			//Sign Up with user credentials
		 commonfunctions.buttonClick(loginPageObj.SignIn());
			asrt.assertTrue(commonfunctions.isExists(loginPageObj.SignInPopup()), "User is not able to view  sign up popup on clicking sign up button");
	 
			commonfunctions.setData(loginPageObj.UserName(), "Gokul"+commonfunctions.CreateRandomWithoutNumbers(4));
			String username= commonfunctions.GetValue(loginPageObj.UserName());
	 
			commonfunctions.setData(loginPageObj.password(), "P"+commonfunctions.CreateRandomWithoutNumbers(4));
			String password= commonfunctions.GetValue(loginPageObj.password());
			commonfunctions.buttonClick(loginPageObj.SignUp());
			Alert alert=driver.switchTo().alert();		
			String AlertText=alert.getText();
			Assert.assertEquals("Sign up successful.", AlertText);
			alert.accept();
	 
			//
			commonfunctions.buttonClick(loginPageObj.UserLogin());
			asrt.assertTrue(commonfunctions.isExists(loginPageObj.UserLogin()), "User is not able to view the Login up popup on clicking login button");
			commonfunctions.setData(loginPageObj.LoginUsername(), username);
			commonfunctions.setData(loginPageObj.LoginPassword(), password);
			commonfunctions.buttonClick(loginPageObj.BtnLogin());
			asrt.assertTrue(commonfunctions.isExists(loginPageObj.Success(username)), "User is not able to login to the application");
		
	 
			//product selection
			commonfunctions.buttonClick(loginPageObj.TxtProduct());
			asrt.assertTrue(commonfunctions.isExists(loginPageObj.CartPage()), "User is not able to navigate to cart page after clicking add to cart.");
			commonfunctions.buttonClick(loginPageObj.BtnaddToCart());
			Alert alert2=driver.switchTo().alert();		
			String AlertText2=alert2.getText();
			Assert.assertEquals("Product added.", AlertText);
			alert.accept();
		 
	 }
	  
	 
	 
		 
	 }
