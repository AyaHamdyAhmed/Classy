package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminDashBoard extends PageBase {
	public AdminDashBoard(WebDriver driver) {
		this.driver = driver;

	}

	public void OpenCampaignDashBoard() {
		Initialize();
		ClickOnCampaignsTab();
	}

	private void ClickOnCampaignsTab() {
		implicitWaitUntilLoad(driver);
		WebElement elem = driver.findElement(parser.getbjectLocator("CampaignTab"));
		clickOnElementByJavaScript(driver, elem);
		implicitWaitUntilLoad(driver);
	}
}
