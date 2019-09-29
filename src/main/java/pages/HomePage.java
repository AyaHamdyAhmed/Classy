package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

private Logger logger = Logger.getLogger(HomePage.class);
	public HomePage(WebDriver driver) {
		this.driver = driver;
		LogConfig();
	}
	// keyWords

	public void goToUrl(String url) {
		driver.get(url);
		logger.info("URL redirected");
	}

	public void openLoginPage() {
		Initialize();
		findHomeLoginBtn();
	}

	private void findHomeLoginBtn() {
		ClickOnElement(driver, parser.getbjectLocator("Login"));
		implicitWaitUntilLoad(driver);
		logger.info("Login page is oppened");

	}
}
