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

	public void Login() {
		Initialize();
		initializeData();
		SetUserName(dataparser.getData("UserName"));
		SetPassword(dataparser.getData("Password"));
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
