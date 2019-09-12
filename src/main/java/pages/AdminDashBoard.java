package pages;

import org.openqa.selenium.WebDriver;

public class AdminDashBoard extends PageBase{
     public AdminDashBoard(WebDriver driver) {
    	 this.driver=driver;
    	 
     }
     
     public void OpenCampaignDashBoard() {
    	 ClickOnCampaignsTab();
     }
     
     private void ClickOnCampaignsTab() {
    	 ClickOnElement(driver, parser.getbjectLocator("CampaignTab"));
    	implicitWaitUntilLoad(driver);
     }
}
