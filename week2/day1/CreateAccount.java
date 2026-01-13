package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//A web page that contains various fields, dropdowns and buttons. 
//Your task is to automate interactions with these WebElement using Selenium WebDriver.
public class CreateAccount {

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
		
		//Click on the "Accounts" tab. 
		driver.findElement(By.linkText("Accounts")).click();
		
		//Click on the "Create Account" button. 
		driver.findElement(By.partialLinkText("Create Account")).click();
		
		//Enter an account name. id="accountName"
		WebElement accountName = driver.findElement(By.id("accountName"));
		accountName.sendKeys("Umamahaswari V");
		
		//Enter a description as "Selenium Automation Tester." - Enter a Number Of Employees. name="description"
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester - 50 Employees");
		
		//Enter a Site Name as “LeafTaps” id="officeSiteName"
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		
		//Click the "Create Account" button. class="smallSubmit"
		driver.findElement(By.className("smallSubmit")).click();
		
		//Verify that the Title is displayed correctly.
		String titleOfTheCurrentWindow = driver.getTitle();
		//System.out.println(titleOfTheCurrentWindow);
		
	   if (titleOfTheCurrentWindow.equalsIgnoreCase("Account Details | opentaps CRM")) {
			System.out.println("Title is verified successfully");
		}else {
			System.out.println("Title is mismatching");
		}
		
		// Close the browser
		driver.close();
		
	}
}
