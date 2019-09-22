package Config;

public class DriverManagerFactory {
	public static DriverManager getDriverManager(DriverType type) {
		DriverManager driverManager = null;
		switch (type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FireFoxDriverManager();
		case EDGE:
			driverManager = new EdgeDriverManager();
		case IE:
			driverManager = new IEDriverManager();
		default:
			driverManager = new ChromeDriverManager();
			break;
		}
		return driverManager;
	}
}
