package Project.Makemytrip;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class browserInitialisation {
	//Initializing driver
	public WebDriver driver;
	
	public WebDriver intializedriver() throws IOException 
	{
	//String browsername =System.getProperty("browser");// for parameterizing from jenkins
	String browsername = "chrome";
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\webDrivers\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		if(browsername.contains("headless"))
		options.addArguments("headless");
		driver = new ChromeDriver(options);
	}
	else if(browsername.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\webDrivers\\geckodriver.exe");
		FirefoxOptions options= new FirefoxOptions();
		if(browsername.contains("headless"))
		options.addArguments("headless");
		driver = new FirefoxDriver(options);
	}
	else if(browsername.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\webDrivers\\IEDriverServer.exe");
		InternetExplorerOptions options= new InternetExplorerOptions();
		if(browsername.contains("headless"))
		options.addCommandSwitches("headless");
		driver = new InternetExplorerDriver(options);
	}
	else if(browsername.equals("edge"))
	{
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\webDrivers\\msedgedriver.exe");
		EdgeOptions options= new EdgeOptions();
		if(browsername.contains("headless"))
		options.setPageLoadStrategy("headless");
		driver = new EdgeDriver(options);
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
	}
	
}
