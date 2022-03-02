package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignInObjects {

	WebDriver driver;
	
	@FindBy(id="language")
	WebElement dropdown;
	
	@FindBy(id="name")
	WebElement username;
	
	@FindBy(id="orgName")
	WebElement orgname;
	
	@FindBy(id="singUpEmail")
	WebElement emailId;
	
	@FindBy(className="ui-checkbox")
	WebElement checkbox;
	
	@FindBy(linkText="Get Started")
	WebElement signIn;
	
	public SignInObjects(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
	}
	
	public static Select select;
	public void selectLanguage() {
		select = new Select(dropdown);
		select.selectByIndex(0);
		List<WebElement> e = select.getOptions();
		int count = e.size();
		for(int i=0; i<=count; i++) {
			if(e.get(i).getText().equals("English") || e.get(i).getText().equals("Dutch")) {
				System.out.println("The dropdown is validated");
			}
		}
	}
	
	public void setUsername(String uname) {
		username.sendKeys(uname);
	}
	
	public void setOrgName(String orgName) {
		orgname.sendKeys(orgName);
	}
	
	public void setMailId(String mailid) {
		emailId.sendKeys(mailid);
	}
	
	public void clickBox() {
		checkbox.click();
	}
	
	public void signInButton() {
		signIn.click();
	}
}
