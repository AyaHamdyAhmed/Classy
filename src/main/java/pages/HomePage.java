package pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import objectRepo.RespositoryParser;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	// keyWords

	public void goToUrl(String url) {
		driver.get(url);
	}

	public void openLoginPage() {
		try {
			parser = new RespositoryParser("application.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		findHomeLoginBtn();
	}

	private void findHomeLoginBtn() {
		ClickOnElement(driver, parser.getbjectLocator("Login"));
		implicitWaitUntilLoad(driver);

	}
}
