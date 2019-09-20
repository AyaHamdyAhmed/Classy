package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CampaignSetupPage extends PageBase {
	WebElement elem;

	public CampaignSetupPage(WebDriver driver) {
		this.driver = driver;
	}

	public void SetUpCampaignData() {
		Initialize();
		initializeData();
		SwitchToNewTab(driver);
		InsertCampaignName(dataparser.getData("CamapaignName"));
		InsertFundRaisingGoal(dataparser.getData("FundGoal"));
		ClickNextStep();
		openThemePage();
	}

	private void InsertCampaignName(String CName) {
		SendkeysToElemnent(driver, parser.getbjectLocator("Campaignname"), CName);
	}

	private void InsertFundRaisingGoal(String Fgoal) {
		SendkeysToElemnent(driver, parser.getbjectLocator("FundraisingGoal"), Fgoal);
	}

	private void ClickNextStep() {
		elem = driver.findElement(parser.getbjectLocator("NextButn"));
		clickOnElementByJavaScript(driver, elem);
	}

	private void openThemePage() {

		for (int i = 0; i < 3; i++) {
			implicitWaitUntilLoad(driver);
			elem = driver.findElement(parser.getbjectLocator("SkipBtn"));
			LongWait();
			waitForElementToBeInteractable(driver, parser.getbjectLocator("SkipBtn"));
			clickOnElementByJavaScript(driver, elem);
			LongWait();
		}
	}
}
