package pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CampaignOverviewPage extends PageBase {
	WebElement elem;
	private Logger logger = Logger.getLogger(PageBase.class);
	public CampaignOverviewPage(WebDriver driver) {
		this.driver = driver;
		LogConfig();
	}

	public void publishCampaign() {
		Initialize();
		clickPublishCamapaign();
		clickPublishFromPopup();
		implicitWaitUntilLoadWithLongWait(driver);
		LonglongWait();
	}

	private void clickPublishCamapaign() {
		elem = driver.findElement(parser.getbjectLocator("PublishBtn"));
		waitForElementToAppear(driver, parser.getbjectLocator("PublishBtn"));
		clickOnElementByJavaScript(driver, elem);
		logger.info("publish button is clicked");
		implicitWaitUntilLoad(driver);
        logger.info("puplish popup is appeared");
	}

	private void clickPublishFromPopup() {
		elem = driver.findElement(parser.getbjectLocator("PublishPopup"));
		clickOnElementByJavaScript(driver, elem);
		logger.info("confirm publish campaign is clicked");
	}

	public void AssertThatCampaignisPublished() {
		elem = driver.findElement(parser.getbjectLocator("PublishBtn"));
		assertEquals(elem.getText(), "Unpublish");

	}

	public void AssertThatMenuItemisChanged() {
		Initialize();
		elem = driver.findElement(parser.getbjectLocator("PreViewMenu"));
		assertEquals(elem.getText(), "VIEW");
	}

	public void AssertThatcampaignisnotpublished() {
		Initialize();
		elem = driver.findElement(parser.getbjectLocator("PreViewMenu"));
		assertEquals(elem.getText(), "PREVIEW");

	}
}
