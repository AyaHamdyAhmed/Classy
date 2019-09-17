package pages;

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
	}

	private void clickPublishCamapaign() {
		ClickOnElement(driver, parser.getbjectLocator("PublishBtn"));
		implicitWaitUntilLoad(driver);
	}

	private void clickPublishFromPopup() {
     elem= driver.findElement(parser.getbjectLocator("PublishPopup"));
     clickOnElementByJavaScript(driver, elem);
	}
}
