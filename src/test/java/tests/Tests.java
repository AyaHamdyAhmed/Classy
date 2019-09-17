package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import pages.AdminDashBoard;
import pages.CampaignPage;
import pages.CampaignSetupPage;
import pages.HomePage;
import pages.LoginPage;

public class Tests extends TestBase{
	
	WebDriver driver;
	HomePage home;
	LoginPage login;
	AdminDashBoard admin;
	CampaignPage campaign;
	CampaignSetupPage cSetup;
	String url= "https://staging.stayclassy.org";
	@BeforeMethod
	public void navigation() {
		driver= driverManager.getWebDriver();
		home= new HomePage(driver);
		login= new LoginPage(driver);
		admin= new AdminDashBoard(driver);
		campaign= new CampaignPage(driver);
		cSetup = new CampaignSetupPage(driver);
		home.goToUrl(url);
	}
  @Test
  public void CreateNewDonationPageTest() {
	  home.openLoginPage();
	  login.Login("", "");
	  admin.OpenCampaignDashBoard();
	  campaign.createNewCampaign();
	  cSetup.SetUpCampaignData("TestDonation", "10000");
	  
  }
}
