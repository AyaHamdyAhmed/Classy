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
		SwitchToNewTab(driver);
		clickPublishCamapaign();
		clickPublishFromPopup();
	}

	private void clickPublishCamapaign() {
		ClickOnElement(driver, parser.getbjectLocator("PublishBtn"));
		implicitWaitUntilLoad(driver);
	}

	private void clickPublishFromPopup() {
		elem = driver.findElement(parser.getbjectLocator("PublishPopup"));
		clickOnElementByJavaScript(driver, elem);
		implicitWaitUntilLoadWithLongWait(driver);
	}
	
	/*public void AssertThatCampaignisPublished() {
		elem = driver.findElement(parser.getbjectLocator("PublishBtn"));
		assertEquals(elem.getText(), "Unpublish");
		
	}*/
	public void AssertThatMenuItemisChanged() {
	   elem = driver.findElement(parser.getbjectLocator("PreViewMenu"));
	   assertEquals(elem.getText(), "View");
	}
}
