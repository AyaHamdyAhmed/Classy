package Config;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager extends DriverManager {
	@Override
	public void createWebDriver() {
		EdgeOptions options = new EdgeOptions();
		this.driver = new EdgeDriver(options);
	}
}
