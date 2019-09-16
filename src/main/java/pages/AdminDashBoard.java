package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepo.RespositoryParser;

public class AdminDashBoard extends PageBase {
	public AdminDashBoard(WebDriver driver) {
		this.driver = driver;

	}

	public void OpenCampaignDashBoard() {
		try {
			parser = new RespositoryParser("application.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ClickOnCampaignsTab();
	}

	private void ClickOnCampaignsTab() {
		implicitWaitUntilLoad(driver);
		WebElement elem= driver.findElement(parser.getbjectLocator("CampaignTab"));
		clickOnElementByJavaScript(driver, elem);
		//ClickOnElement(driver, parser.getbjectLocator("CampaignTab"));
		implicitWaitUntilLoad(driver);
	}
}
