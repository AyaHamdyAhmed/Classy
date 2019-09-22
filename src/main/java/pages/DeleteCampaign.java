package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteCampaign extends PageBase {
	WebElement elem;

	public DeleteCampaign(WebDriver driver) {
		this.driver = driver;

	}

	public void clearCreatedCampaigns() {
		Initialize();
		// searchByCampaignName(CName);
		// ClicktoOpenCampainDetailsPage();
		// SwitchToNewTab(driver);
		SwitchToCamapaignDetailsTab();
		ClickOnDeleteCampaignBtn();
		confirmDeleteCampaignFromPopup();
		LonglongWait();
		AssertSuccessfulDeletionOfCampaign();
	}

	/*
	 * private void searchByCampaignName(String Cname) {
	 * waitForElementToBeInteractable(driver,
	 * parser.getbjectLocator("CampaignSearchBox")); SendkeysToElemnent(driver,
	 * parser.getbjectLocator("CampaignSearchBox"), Cname); }
	 * 
	 * private void ClicktoOpenCampainDetailsPage() { //// need to get search result
	 * element locator elem = driver.findElement(parser.getbjectLocator(""));
	 * clickOnElementByJavaScript(driver, elem); }
	 */
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
	}
	
	private void AssertSuccessfulDeletionOfCampaign() {
		assertEquals(driver.getCurrentUrl(), "https://www.classy.org/admin/17799/activity");
	}
}
