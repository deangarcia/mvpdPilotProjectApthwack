package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.CapabilityType;

import testCases.MVPD;
import testCases.jsonRead;

public abstract class IOSLaunch {
	public static AppiumDriver driver;
	public static WebDriverWait wait;
	public static ArrayList<MVPD>mvpd = new ArrayList<MVPD>();
	public static jsonRead jsonReader =  new jsonRead("/Users/ramyar/Documents/workspace/New/mvpdPilotProjectApthwack/resource/read.json"); 
	
	@BeforeClass
	public static void launchDriver() throws Throwable 
	{
		jsonReader.readJsonFromFile();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Raj Bangaru Samy’s iPhone");
		capabilities.setCapability("platformName", "ios"); 
		capabilities.setCapability("platformVersion", "7.1");
		//iphone4s
		//capabilities.setCapability("platformVersion", "7.0");
		//capabilities.setCapability("udid", "aa18c45a49bcea5055be2e894748ccb25665e1c6");
		//iphone5
		capabilities.setCapability("udid", "ce7d4a568c96f9886ed561d6aad36007e13fe0ff");
		capabilities.setCapability("bundleId", "com.uie.foxsports.foxsportsgo");
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//wait = new WebDriverWait(driver, 60);
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
