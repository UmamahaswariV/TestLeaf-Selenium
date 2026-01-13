package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//A web page that contains various fields, dropdowns and buttons. 
//Your task is to automate interactions with these WebElement using Selenium WebDriver.
public class CreateLead {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		// Hide automation indicators
		options.addArguments("guest");
		
		//Initialize the WebDriver (ChromeDriver).
		ChromeDriver driver; 
		driver = new ChromeDriver(options);
		
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
		
		//Enter an First name. id="createLeadForm_firstName"
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Umamaheswari");
		
		//Enter an Last name. id="createLeadForm_lastName"
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("V");
		
		//Enter a Company Name. id="createLeadForm_companyName"
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HCLTech");
		
		//Enter title. id="createLeadForm_generalProfTitle"
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Senior Software Engineer");
		
		//Click the "Create Lead" button. name="submitButton"
		driver.findElement(By.name("submitButton")).click();
		
		//Verify that the Title is displayed correctly.
		String titleOfTheCurrentWindow = driver.getTitle();
		System.out.println(titleOfTheCurrentWindow);
		
	   if (titleOfTheCurrentWindow.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Title is verified successfully");
		}else {
			System.out.println("Title is mismatching");
		}
		
		//Close the browser
		driver.close();
		
	}
}
