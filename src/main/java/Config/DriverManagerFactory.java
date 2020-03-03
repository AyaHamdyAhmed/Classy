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
			break;
		case EDGE:
			driverManager = new EdgeDriverManager();
			break;
		case IE:
			driverManager = new IEDriverManager();
			break;
		default:
			driverManager = new ChromeDriverManager();
			break;
		}
		return driverManager;
	}
}
