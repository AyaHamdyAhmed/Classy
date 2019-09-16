package pages;

import org.openqa.selenium.WebDriver;

public class CampaignSetupPage extends PageBase {
	public CampaignSetupPage(WebDriver driver) {
		this.driver = driver;
	}

	public void SetUpCampaignData(String CName, String Fgoal) {
		Initialize();
		InsertCampaignName(CName);
		InsertFundRaisingGoal(Fgoal);
		ClickNextStep();
		openThemePage();

	}

	private void InsertCampaignName(String CName) {
		SendkeysToElemnent(driver, parser.getbjectLocator("CampaignName"), CName);
	}

	private void InsertFundRaisingGoal(String Fgoal) {
		SendkeysToElemnent(driver, parser.getbjectLocator("FundraisingGoal"), Fgoal);
	}

	private void ClickNextStep() {
		ClickOnElement(driver, parser.getbjectLocator("NextButn"));
	}
	
	private void openThemePage() {
		ClickOnElement(driver,parser.getbjectLocator("ThemeNextBtn"));
		ClickOnElement(driver, parser.getbjectLocator("ThemeNextBtn"));
		ClickOnElement(driver, parser.getbjectLocator("ThemeNextBtn"));
	}
}
