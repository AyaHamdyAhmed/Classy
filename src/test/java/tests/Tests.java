package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import pages.AdminDashBoard;
import pages.HomePage;
import pages.LoginPage;

public class Tests extends TestBase{
	
	WebDriver driver;
	HomePage home;
	LoginPage login;
	AdminDashBoard admin;
	String url= "https://www.classy.org";
	@BeforeMethod
	public void navigation() {
		driver= driverManager.getWebDriver();
		home= new HomePage(driver);
		login= new LoginPage(driver);
		admin= new AdminDashBoard(driver);
		home.goToUrl(url);
	}
  @Test
  public void CreateNewDonationPageTest() {
	  home.openLoginPage();
	  login.Login("dhalawa@classy.org", "12345678@A");
	  admin.OpenCampaignDashBoard();
	  
  }
}
