package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends TestBase{
	
	WebDriver driver;
  @Test
  public void LoginTest() {
	  driver= driverManager.getWebDriver();
	  driver.get("https://login.classy.org/");
	  WebElement UserName = driver.findElement(parser.getbjectLocator("UserName"));
	  WebElement Password = driver.findElement(parser.getbjectLocator("Password"));
	  UserName.sendKeys("dhalawa@classy.org");
	  Password.sendKeys("12345678@A");
	 // Assert.assertEquals(driver.getTitle(), "Google");
  }
}
