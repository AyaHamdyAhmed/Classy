package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import objectRepo.RespositoryParser;

public class LoginPage extends PageBase {
//variables 
	String UserName;
	String Password;

// Keywords
	public LoginPage(WebDriver driver) {
		this.driver = driver;
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

	private void SetUserName(String username) {
		driver.findElement(parser.getbjectLocator("UserName")).sendKeys(username);
	}

	private void SetPassword(String Password) {
		driver.findElement(parser.getbjectLocator("Password")).sendKeys(Password);
	}

	private void ClickLogin() {
		ClickOnElement(driver, parser.getbjectLocator("SignIN"));
		//waitForElementToBeInteractable(driver, parser.getbjectLocator("SignIN"));
		//driver.findElement(parser.getbjectLocator("SignIN")).sendKeys(Keys.ENTER);
	}


}
