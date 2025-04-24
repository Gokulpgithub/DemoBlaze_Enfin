package objectRepository;

import org.openqa.selenium.By;
import java.util.*;


public class LoginPage_Obj
{
	public By SignIn(){return By.xpath("//a[@id='signin2']");}
	public By SignInPopup(){return By.xpath("//h5[@id='signInModalLabel']");}	 
	public By UserName(){return By.xpath("//input[@id='sign-username']");}
	public By password(){return By.xpath("//input[@id='sign-password']");}
	public By SignUp(){return By.xpath("//button[text()='Sign up']");}	
	public By UserLogin(){return By.xpath("//a[@id='login2']");}
	public By LoginUsername(){return By.xpath("//input[@id='loginusername']");}
	public By LoginPassword(){return By.xpath("//input[@id='loginpassword']");}
	public By BtnLogin(){return By.xpath("//button[text()='Log in']");}
	public By SuccessMessage() {return By.xpath("//a[text()='Welcome Gokul']");} 	
	public By BtnaddToCart(){return By.xpath("//a[text()='Add to cart']");}
	public By Btn_CartLogin(){return By.xpath("//button[text()='Log in']");}	
	public By TxtProduct() {return By.xpath("//a[text()='Samsung galaxy s6']");}
	public By Btn_PlaceOrder() {return By.xpath("//button[text()='Place Order']");}	
	public By TxtOrderField(String idName) {return By.xpath("//input[@id='"+idName+"']");}
    public By BtnPurchase() {return By.xpath("//button[text()='Purchase']");}    
    public By Success(String username) {return By.xpath("//a[contains(text(),'"+username+"')]");}		
	public By CartPage(){return By.xpath("//h2[text()='Samsung galaxy s6']");}
 
}
