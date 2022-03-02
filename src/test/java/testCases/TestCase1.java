package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.SignInObjects;
import utilities.Logs;
import utilities.ReadConfigurations;

public class TestCase1 extends BaseClass {

	ReadConfigurations rf = new ReadConfigurations();
	String url= rf.getUrl();
	String name= rf.getUsername();
	String oname= rf.getOrganisationName();
	String email= rf.getMailId();
	
	@Test
	public void test1() {
		Logs.startTestCase("Test case 1");
		driver.get(url);
		
		SignInObjects si = new SignInObjects(driver);
		
		si.selectLanguage();
		List<WebElement> e = SignInObjects.select.getOptions();
		int count = e.size();
		for(int i=0; i<=count; i++) {
			if(e.get(i).getText().equals("English") || e.get(i).getText().equals("Dutch")) {
				System.out.println("The dropdown is validated");
			}
		}
		
		si.setUsername(name);
		
		si.setOrgName(oname);
		
		si.setMailId(email);
		
		si.clickBox();
		
		si.signInButton();
		
		screenShot("LoginTest");
		
		Logs.info("Logged in successfully");
		Logs.endTestCase("Test case 1");
		
	}
	
}
