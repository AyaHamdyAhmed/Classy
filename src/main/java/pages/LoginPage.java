package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
//variables 
	String UserName;
	String Password;

// Keywords
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Login(String userName, String pass) {
		Initialize();
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
		implicitWaitUntilLoad(driver);
	}

}
