package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CampaignSetupPage extends PageBase {
	WebElement elem;
	private Logger logger = Logger.getLogger(CampaignSetupPage.class);

	public CampaignSetupPage(WebDriver driver) {
		this.driver = driver;
		LogConfig();
	}

	public void SetUpCampaignData() {
		Initialize();
		initializeData();
		SwitchToNewTab(driver);
		logger.info("new tab is oppend");
		InsertCampaignName(dataparser.getData("CamapaignName"));
		InsertFundRaisingGoal(dataparser.getData("FundGoal"));
		ClickNextStep();
		openThemePage();
	}

	private void InsertCampaignName(String CName) {
		try {
			if (CName != null) {
				SendkeysToElemnent(driver, parser.getbjectLocator("Campaignname"), CName);
				logger.info("Camapign Name is Entered");
			} else {
				logger.error("campaign name is empty");
			}
		} catch (Exception e) {
			logger.error("something want wrong", e);
			//driver.close();
		}
	}

	private void InsertFundRaisingGoal(String Fgoal) {
		SendkeysToElemnent(driver, parser.getbjectLocator("FundraisingGoal"), Fgoal);
		logger.info("Campaign Goal is Entered");
	}

	private void ClickNextStep() {
		try {
			
			elem = driver.findElement(parser.getbjectLocator("NextButn"));
			clickOnElementByJavaScript(driver, elem);
			 
			//ClickOnElement(driver, parser.getbjectLocator("NextButn"));
			logger.info("Next Step button is clicked");
		} catch (Exception e) {
			logger.error("something went wrong! ", e);
			//driver.close();
		}
	}

	private void openThemePage() {
		try {
			for (int i = 0; i < 3; i++) {
				implicitWaitUntilLoad(driver);
				elem = driver.findElement(parser.getbjectLocator("SkipBtn"));
				LongWait();
				waitForElementToBeInteractable(driver, parser.getbjectLocator("SkipBtn"));
				clickOnElementByJavaScript(driver, elem);
				LongWait();
			}
			logger.info("skip button is clicked");
		} catch (Exception e) {
			logger.error("can't locate an element", e);
			//driver.close();
		}
	}
}
