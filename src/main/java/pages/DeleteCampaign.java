package pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteCampaign extends PageBase {
	WebElement elem;
	private Logger logger = Logger.getLogger(PageBase.class);

	public DeleteCampaign(WebDriver driver) {
		this.driver = driver;
		LogConfig();

	}

	public void clearCreatedCampaigns() {
		Initialize();
		SwitchToCamapaignDetailsTab();
		ClickOnDeleteCampaignBtn();
		confirmDeleteCampaignFromPopup();
		LonglongWait();
		AssertSuccessfulDeletionOfCampaign();
	}

	private void SwitchToCamapaignDetailsTab() {
		waitForElementToAppear(driver, parser.getbjectLocator("DetailsTab"));
		elem = driver.findElement(parser.getbjectLocator("DetailsTab"));
		clickOnElementByJavaScript(driver, elem);
	}

	private void ClickOnDeleteCampaignBtn() {
		waitForElementToBeInteractable(driver, parser.getbjectLocator("DeleteCampaignBtn"));
		elem = driver.findElement(parser.getbjectLocator("DeleteCampaignBtn"));
		clickOnElementByJavaScript(driver, elem);
	}

	private void confirmDeleteCampaignFromPopup() {
		waitForElementToAppear(driver, parser.getbjectLocator("DeleteForEverPopup"));
		elem = driver.findElement(parser.getbjectLocator("DeleteForEverPopup"));
		clickOnElementByJavaScript(driver, elem);
		logger.info("data genereted by test is cleaned");
	}

	private void AssertSuccessfulDeletionOfCampaign() {
		assertEquals(driver.getCurrentUrl(), "https://www.classy.org/admin/17799/activity");
	}
}
