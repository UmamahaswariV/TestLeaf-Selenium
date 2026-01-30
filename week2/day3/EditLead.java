import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

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
		
		//Click on the "Create Lead" button.
		driver.findElement(By.partialLinkText("Create Lead")).click();
		
		//Enter the CompanyName Field Using Xpath.
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("HCLTech pvt Ltd",Keys.ENTER);
		
		//Enter the FirstName Field Using Xpath.
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Test Subject2");
		Thread.sleep(2000);
		
		//Enter the LastName Field Using Xpath.
		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("V");
		Thread.sleep(2000);
		
		//Enter the FirstName (Local) Field Using Xpath.
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys("Uma");
		Thread.sleep(2000);
		
		//Enter the Department Field Using any Locator of Your Choice.
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("IT");
		Thread.sleep(2000);
		
		//Enter the Description Field Using any Locator of your choice.
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("IT Department");
		Thread.sleep(2000);
		
		//Enter your email in the E-mail address Field using the locator of your choice.
		driver.findElement(By.xpath("(//input[@name='primaryEmail'])[4]")).sendKeys("test345@gmail.com");
		Thread.sleep(2000);
		
		//Select State/Province as NewYork Using Visible Text.
		Select State=new Select((WebElement) driver.findElement(By.xpath("(//select[@class='inputBox'])[6]")));
		State.selectByVisibleText("New York");
		Thread.sleep(2000);	
		
		//Click on the Create Button.
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		Thread.sleep(2000);
		
		//Click on the edit button.
		driver.findElement(By.xpath("(//a[@class='subMenuButton'])[3]")).click();
		Thread.sleep(2000);
		
		//Clear the Description Field.
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();
		Thread.sleep(2000);
		
		//Fill the Important Note Field with Any text.
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Updated Without Description");
		Thread.sleep(2000);
		
		//Click on the update button.
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		Thread.sleep(4000);
		
		//Get the Title of the Resulting Page.
		String titleOfTheCurrentWindow = driver.getTitle();
		System.out.println(titleOfTheCurrentWindow);
	   if (titleOfTheCurrentWindow.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Title is verified successfully");
		}else {
			System.out.println("Title is mismatching");
		}
	   
		//Close the browser window.
		driver.quit();

	}

}
