package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import objectRepo.RespositoryParser;

public class LoginPage extends PageBase{
//variables 
	String UserName;
	String Password;
	WebDriver driver;
	protected RespositoryParser parser;

//locators 
// Keywords
	public LoginPage(WebDriver driver) {
		//super(driver);
		this.driver= driver;
	}

	public void Login(String userName, String pass) {
		try {
			parser = new RespositoryParser("application.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SetUserName(userName);
		SetPassword(pass);
		ClickLogin();

	}

	public void SetUserName(String username) {
		driver.findElement(parser.getbjectLocator("UserName")).sendKeys(username);
	}

	public void SetPassword(String Password) {
		driver.findElement(parser.getbjectLocator("Password")).sendKeys(Password);
	}

	public void ClickLogin() {
		waitForElementToBeInteractable(driver,parser.getbjectLocator("SignIN"));
		driver.findElement(parser.getbjectLocator("SignIN")).sendKeys(Keys.ENTER);
	}

	public void goTo(String url) {
	driver.get(url);
		
	}

}
