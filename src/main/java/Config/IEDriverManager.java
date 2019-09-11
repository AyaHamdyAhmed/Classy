package Config;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEDriverManager extends DriverManager {
	@Override
	public void createWebDriver() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		this.driver = new InternetExplorerDriver(options);
		driver.manage().window().maximize();
	}
}
