package testExecution.Demoblaze;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Test.Login;
import TestData.CommonData;
import utilPack.Driver;
import org.testng.annotations.*;

public class TestPage extends Driver
{
    @Test()
    public void TC01_Login()
    {
    	Login loginpage=new Login(driver);
    	loginpage.Demoblaze_Login();
    }
}
