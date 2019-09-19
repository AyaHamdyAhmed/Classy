package tests;

import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import pages.AdminDashBoard;
import pages.CampaignOverviewPage;
import pages.CampaignPage;
import pages.CampaignSetupPage;
import pages.HomePage;
import pages.LoginPage;
import data.ExcelReader;

public class Tests extends TestBase{
	
	WebDriver driver;
	HomePage home;
	LoginPage login;
	AdminDashBoard admin;
	CampaignPage campaign;
	CampaignSetupPage cSetup;
	CampaignOverviewPage cOverview;
	String url= "https://www.classy.org";
	@BeforeMethod
	public void navigation() {
		driver= driverManager.getWebDriver();
		home= new HomePage(driver);
		login= new LoginPage(driver);
		admin= new AdminDashBoard(driver);
		campaign= new CampaignPage(driver);
		cSetup = new CampaignSetupPage(driver);
		cOverview = new CampaignOverviewPage(driver);
		home.goToUrl(url);
	}
	  @DataProvider
		public Object[][] DP() throws IOException {
			 ExcelReader reader = new ExcelReader();
		      return reader.getExcelData();
		}
	  
  @Test(dataProvider = "DP")
  public void CreateNewDonationPageTest(String userName, String password, String CName, String Fgoal){
	  home.openLoginPage();
	  login.Login(userName,password);
	  admin.OpenCampaignDashBoard();
	  campaign.createNewCampaign();
	  cSetup.SetUpCampaignData(CName,Fgoal);
	  cOverview.AssertThatcampaignisnotpublished();
	  cOverview.publishCampaign();
	  
  }
  

}
