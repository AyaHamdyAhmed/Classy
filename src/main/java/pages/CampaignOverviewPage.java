package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CampaignOverviewPage extends PageBase {
	WebElement elem;

	public CampaignOverviewPage(WebDriver driver) {
		this.driver = driver;
	}

	public void publishCampaign() {
		Initialize();
		clickPublishCamapaign();
		clickPublishFromPopup();
		implicitWaitUntilLoadWithLongWait(driver);
		LonglongWait();
		// AssertThatCampaignisPublished();
	}

	private void clickPublishCamapaign() {
		elem = driver.findElement(parser.getbjectLocator("PublishBtn"));
		waitForElementToAppear(driver, parser.getbjectLocator("PublishBtn"));
		clickOnElementByJavaScript(driver, elem);
		implicitWaitUntilLoad(driver);
	}

	private void clickPublishFromPopup() {
		elem = driver.findElement(parser.getbjectLocator("PublishPopup"));
		clickOnElementByJavaScript(driver, elem);
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
	/*
	 * public void assertThatCamapignPublished(String url) {
	 * assertEquals(driver.getCurrentUrl().replaceAll("[0-9]", ""), url); }
	 */

	public void AssertThatcampaignisnotpublished() {
		Initialize();
		elem = driver.findElement(parser.getbjectLocator("PreViewMenu"));
		assertEquals(elem.getText(), "PREVIEW");

	}
}
