package testCommon;

import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import utils.PropertiesFileReader;


public class TestBase{

	public static ThreadLocal<WebDriver> dr1 = new ThreadLocal<WebDriver>();
	static WebDriver driver;
	static PropertiesFileReader obj = new PropertiesFileReader();
	static Properties properties = obj.getProperty();
	
	public static WebDriver getDriver() {
		return dr1.get();
	}
	
	public static void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver_87");
		dr1.set(new ChromeDriver());
		getDriver().get(properties.getProperty("browser-url"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
	}
	

	@BeforeClass
	public static void init() {
		initializeBrowser();
	}

	@AfterClass
	public static void close(){
		closeBrowser();
	}
	
	public void getInputFile() {
		getDriver().get(properties.getProperty("input_file"));
		 
	}

	public static void closeBrowser() {
		getDriver().quit();
	}
	
	
}
