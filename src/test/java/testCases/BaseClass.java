package testCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.Logs;
import utilities.ReadConfigurations;


public class BaseClass {

	WebDriver driver;

	ReadConfigurations rf = new ReadConfigurations();
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		DOMConfigurator.configure("log4j.xml");
		
		if(br.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver",
				rf.getChromePath());
		driver= new ChromeDriver();
		}
		
		if(br.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",rf.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		Logs.info("Driver launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void screenShot(String testname) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\"+ testname + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		Logs.info("Screenshot is taken");
		
	}
}


