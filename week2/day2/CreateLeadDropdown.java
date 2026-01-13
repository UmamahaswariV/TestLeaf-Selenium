package week2.day2;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLeadDropdown {

	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("guest");
		
		ChromeDriver driver; 
		driver = new ChromeDriver(opt);
		
		// Load the URL http://leaftaps.com/opentaps/.
		driver.get("http://leaftaps.com/opentaps/");
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		//Enter a username and password.
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		
		// Click the "Login" button.
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// Click on the "CRM/SFA" link.
		driver.findElement(By.partialLinkText("CRM/SFA")).click(); 
		
		//Click on the "Leads" tab.
		driver.findElement(By.linkText("Leads")).click();
		
		//Click on the "Create Lead" button.
		driver.findElement(By.partialLinkText("Create Lead")).click();
		
		//Enter the mandatory fields on the web page. FirstName,LastName and CompanyName
		//Enter an First name. id="createLeadForm_firstName"
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Umamahaswari");
		
		//Enter an Last name. id="createLeadForm_lastName"
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("V");
		
		//Enter a Company Name. id="createLeadForm_companyName"
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HCLTech");
		
		//Enter title. id="createLeadForm_generalProfTitle"
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Senior Software Engineer");
		
		//Select Employee in the source dropdown (using index) id="createLeadForm_dataSourceId"
		WebElement sourceDropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		// select class -->  Choosing the option based on index
		Select option = new Select(sourceDropDown);
		option.selectByIndex(4);
		
		//Select Automobile in the Marketing Campaign (using visibleText) id="createLeadForm_marketingCampaignId"
		WebElement marketingCampDropDown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		// Choosing the option based on VisibleText as the attribute. 
		Select  marketingOption = new Select(marketingCampDropDown);
		marketingOption.selectByVisibleText("Automobile");
		
		//Select Corporation in Ownership (using value) id="createLeadForm_ownershipEnumId"
		WebElement owenershipDropDown = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		// Choosing the option based on value as the attribute value="OWN_CCORP"
		Select  ownershipOption = new Select(owenershipDropDown);
		ownershipOption.selectByValue("OWN_CCORP");
		
		//Click the "Create Lead" button. 
		driver.findElement(By.name("submitButton")).click();
		
		//Verify that the Title is displayed correctly.
		String titleOfTheCurrentWindow = driver.getTitle();
		//System.out.println(titleOfTheCurrentWindow);
		
	   if (titleOfTheCurrentWindow.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Title is verified successfully");
		}else {
			System.out.println("Title is mismatching");
		}
		
		// Close the browser
		driver.close();
		

	}

}
