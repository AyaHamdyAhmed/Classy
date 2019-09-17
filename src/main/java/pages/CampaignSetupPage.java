package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CampaignSetupPage extends PageBase {
	WebElement elem;

	public CampaignSetupPage(WebDriver driver) {
		this.driver = driver;
	}

	public void SetUpCampaignData(String CName, String Fgoal) {
		Initialize();
		SwitchToNewTab(driver);
		InsertCampaignName(CName);
		InsertFundRaisingGoal(Fgoal);
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
		// ClickOnElement(driver, parser.getbjectLocator("NextButn"));
	}

	private void openThemePage() {
		elem = driver.findElement(parser.getbjectLocator("ThemeNextBtn"));
		for (int i = 0; i < 3; i++) {
			clickOnElementByJavaScript(driver, elem);
		}
	}
}
