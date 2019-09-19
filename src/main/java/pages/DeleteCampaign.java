package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteCampaign extends PageBase {
	WebElement elem;
	public DeleteCampaign(WebDriver driver) {
		this.driver = driver;

	}
	public void clearCreatedCampaigns(String CName) {
		Initialize();
		searchByCampaignName(CName);
		ClicktoOpenCampainDetailsPage();
		SwitchToNewTab(driver);
		SwitchToCamapaignDetailsTab();
	}
	
	
	private void searchByCampaignName(String Cname) {
		waitForElementToBeInteractable(driver, parser.getbjectLocator("CampaignSearchBox"));		
		SendkeysToElemnent(driver, parser.getbjectLocator("CampaignSearchBox"), Cname);
	}
	
	private void ClicktoOpenCampainDetailsPage() {
		//// need to get search result element locator
		elem = driver.findElement(parser.getbjectLocator(""));
		clickOnElementByJavaScript(driver, elem);
	}
	
    private void SwitchToCamapaignDetailsTab() {
    	waitForElementToAppear(driver, parser.getbjectLocator("DetailsTab"));
    	elem = driver.findElement(parser.getbjectLocator("DetailsTab"));
    	clickOnElementByJavaScript(driver, elem);
    }
    
    

}
