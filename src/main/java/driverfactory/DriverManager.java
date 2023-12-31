package driverfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.dsalgoproject.utility.CommonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
private static WebDriver driver=null;
//public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
private static final Logger LOG=LogManager.getLogger(DriverManager.class);

	
	public static WebDriver launchBrowser() {
		try {
			String browser_Name = CommonUtils.BROWSER;
			switch (browser_Name) {
			
			case "chrome":
				WebDriverManager.chromedriver().driverVersion("114.0.5735.90").setup();
				driver= new ChromeDriver();
			//	tlDriver.set(new ChromeDriver());
				LOG.info("Launching browser:" +browser_Name);
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				//tlDriver.set(new EdgeDriver());
				LOG.info("Launching browser:" +browser_Name);
				break;
				
			default:
				WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			LOG.info("Launching browser:" +browser_Name);
			break;
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return driver;
	}
	
	//public static synchronized WebDriver getDriver()
	//{
	//	return tlDriver.get();
	//}
	public WebDriver getDriver() {
	return driver;
	}
}

	


