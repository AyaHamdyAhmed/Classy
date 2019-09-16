package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	// keyWords

	public void goToUrl(String url) {
		driver.get(url);
	}

	public void openLoginPage() {
		Initialize();
		findHomeLoginBtn();
	}

	private void findHomeLoginBtn() {
		ClickOnElement(driver, parser.getbjectLocator("Login"));
		implicitWaitUntilLoad(driver);

	}
}
