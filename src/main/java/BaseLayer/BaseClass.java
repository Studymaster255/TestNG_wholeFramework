package BaseLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;

public class BaseClass {
	String filepath=System.getProperty("user.dir")+"\\src\\main\\java\\ConfigLayer\\Config.properties";
	public static Properties prop;
	public static WebDriver driver;
	public static FileInputStream fis;
//	public static WebeventListener eventListner;
//	public static EventFiringWebDriver e_event;
	public BaseClass()
	{
		prop=new Properties();
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ConfigLayer\\Config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void initilization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) 
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("incognito");
//		options.addArguments("start-maximized");
		options.addArguments("--headless");
		driver=new ChromeDriver(options);
		}
		else if(browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		//for ie and opera support is removed by WebDriverManager dependency
//		else if(browsername.equals("ie"))
//		{
//			WebDriverManager.iedriver().setup();
//			driver=new InternetExplorerDriver();
//		}
//		else if(browsername.equals("opera"))
//		{
//			WebDriverManager.operadriver().setup();
//			driver=new OperaDriver();
//		}
		
//		eventListner =new Webevent •stener();
//		e_event=new EventFiringWebDriv r(driver) ;
//		e_event. register(eventListner) ;
//		driver=e event;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
}
