import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
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
		
		//Click "Find leads."
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Click on the "Phone" tab.
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		
		//Enter the phone number.
		driver.findElement(By.name("phoneCountryCode")).clear();
		driver.findElement(By.name("phoneAreaCode")).clear();
		driver.findElement(By.name("phoneNumber")).sendKeys("9999900000",Keys.ENTER);
		
		//Click the "Find leads" button.
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		
		//Capture the lead ID of the first resulting lead.
		String LeadID=driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr/td[1]//a)[1]")).getText();
		System.out.println("The First Resulting Lead ID is "+LeadID);
		Thread.sleep(2000);
		
		//Click the first resulting lead.
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr/td[1]//a)[1]")).click();
		
		//Click the "Delete" button.
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		Thread.sleep(2000);
		
		//Click "Find leads" again.
		driver.findElement(By.linkText("Find Leads")).click();

		//Enter the captured lead ID.
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@type='text'])[13]")).sendKeys(LeadID,Keys.ENTER);
		
		//Click the "Find leads" button.
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		//Verify the presence of the message "No records to display" in the Lead List.
		//This message confirms the successful deletion.
		String LeadID1=driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		if(LeadID1.equals("No records to display"))
			System.out.println("Record Not Found");
		else
			System.out.println("Record Found Successfully");
		
		//Close the browser.
		driver.quit();

	}

}
