package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CampaignPage extends PageBase {
	private Logger logger = Logger.getLogger(CampaignPage.class);
	public CampaignPage(WebDriver driver) {
		this.driver = driver;
		LogConfig();
	}

	public void createNewCampaign() {
		Initialize();
		ClickCreateNewButton();
		ClickOnDonationItem();
	}

	private void ClickCreateNewButton() {
		implicitWaitUntilLoad(driver);
		WebElement elem = driver.findElement(parser.getbjectLocator("CreateNew"));
		clickOnElementByJavaScript(driver, elem);
		logger.info("Create New drob down is oppened");
	}

	private void ClickOnDonationItem() {
		implicitWaitUntilLoad(driver);
		WebElement elem = driver.findElement(parser.getbjectLocator("DonationListItem"));
		clickOnElementByJavaScript(driver, elem);
		logger.info("donation item list is selected");
		implicitWaitUntilLoadWithLongWait(driver);
		logger.info("Camapign setup page is oppened");
	}
}
