package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CampaignPage extends PageBase {
	public CampaignPage(WebDriver driver) {
		this.driver = driver;
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
		// ClickOnElement(driver, parser.getbjectLocator("CreateNew"));
	}

	private void ClickOnDonationItem() {
		implicitWaitUntilLoad(driver);
		WebElement elem = driver.findElement(parser.getbjectLocator("DonationListItem"));
		clickOnElementByJavaScript(driver, elem);
		//ClickOnElement(driver, parser.getbjectLocator("DonationListItem"));
		implicitWaitUntilLoadWithLongWait(driver);
	}
}
