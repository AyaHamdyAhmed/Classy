package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminDashBoard extends PageBase {
	private Logger logger = Logger.getLogger(AdminDashBoard.class);

	public AdminDashBoard(WebDriver driver) {
		this.driver = driver;
		LogConfig();

	}

	public void OpenCampaignDashBoard() {
		Initialize();
		ClickOnCampaignsTab();
	}

	private void ClickOnCampaignsTab() {
		implicitWaitUntilLoad(driver);
		WebElement elem = driver.findElement(parser.getbjectLocator("CampaignTab"));
		clickOnElementByJavaScript(driver, elem);
		logger.info("campaign tab is clicked");
		implicitWaitUntilLoad(driver);
		logger.info("campaign page is openned");
	}
}
