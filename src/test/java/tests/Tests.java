package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Tests extends TestBase{
	
	WebDriver driver;
	LoginPage login;
	String url= "https://login.classy.org/";
	@BeforeMethod
	public void navigation() {
		driver= driverManager.getWebDriver();
		login= new LoginPage(driver);
		login.goTo(url);
	}
  @Test
  public void LoginTest() {
	  
	 // driver.get("https://login.classy.org/");
	 // WebElement UserName = driver.findElement(parser.getbjectLocator("UserName"));
	  //WebElement Password = driver.findElement(parser.getbjectLocator("Password"));
	  //UserName.sendKeys("dhalawa@classy.org");
	  //Password.sendKeys("12345678@A");
	 // Assert.assertEquals(driver.getTitle(), "Google");
	  login.Login("dhalawa@classy.org", "12345678@A");
	  
  }
}
