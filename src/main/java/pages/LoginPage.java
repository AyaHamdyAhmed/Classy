package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
//variables 
	String UserName;
	String Password;
	private Logger logger = Logger.getLogger(LoginPage.class);
// Keywords
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		LogConfig();
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
		logger.info("UserName Entered");
	}

	private void SetPassword(String Password) {
		driver.findElement(parser.getbjectLocator("Password")).sendKeys(Password);
		logger.info("Password Entered");
	}

	private void ClickLogin() {
		ClickOnElement(driver, parser.getbjectLocator("SignIN"));
		implicitWaitUntilLoad(driver);
		logger.info("Login Clicked and Admin DashBoard Is oppened");
	}

}
