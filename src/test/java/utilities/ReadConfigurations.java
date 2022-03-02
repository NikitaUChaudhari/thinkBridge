package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigurations {

Properties pro;
	
	public ReadConfigurations()
	{
		File src = new File("./Configurations/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getUrl() {
		String URL= pro.getProperty("url");
		return URL;
	}
	
	public String getUsername() {
		String Username= pro.getProperty("username");
		return Username;
	}
	
	public String getOrganisationName() {
		String orgName= pro.getProperty("organisationName");
		return orgName;
	}
	
	public String getMailId() {
		String Mail= pro.getProperty("email");
		return Mail;
	}
	
	public String getChromePath() {
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath() {
		String firefoxpath= pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
