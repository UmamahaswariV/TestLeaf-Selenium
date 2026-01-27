import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlesLeaftaps {
	public static void WindowSwitch(ChromeDriver driver) {
		 Set<String> WindowIds = driver.getWindowHandles();
	    List<String> listOfActiveWindowsID= new ArrayList<String>(WindowIds);
	    driver.switchTo().window(listOfActiveWindowsID.get(1));
	    driver.manage().window().maximize();    
	}
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		// Hide automation indicators
		options.addArguments("guest");
		ChromeDriver driver;
		driver = new ChromeDriver(options);
		WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		// Load the URL http://leaftaps.com/opentaps/control/login.
		driver.get("http://leaftaps.com/opentaps/control/login");
				
		// Maximize the browser window
		driver.manage().window().maximize();

		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter a username and password.
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		
		// Click the "Login" button.
		driver.findElement(By.className("decorativeSubmit")).click();
				
		// Click on the "CRM/SFA" link.
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		//Click on the Contacts button.
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Click on Merge Contacts.
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		String parentWindowId = driver.getWindowHandle();
		//Click on the widget of the "From Contact".
		driver.findElement(By.xpath("(//a/img[@alt='Lookup'])[1]")).click();
		waits.until(ExpectedConditions.numberOfWindowsToBe(2));
		WindowSwitch(driver);
		Thread.sleep(2000);
		
		//Click on the first resulting contact.
		String inputText1=driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
		driver.close();
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.xpath("(//td/input[@class='XdijitInputField dijitInputFieldValidationNormal'])[1]")).sendKeys(inputText1,Keys.ENTER);
		Thread.sleep(2000);
		
		//Click on the widget of the "To Contact".
		driver.findElement(By.xpath("(//a/img[@alt='Lookup'])[2]")).click();
		waits.until(ExpectedConditions.numberOfWindowsToBe(2));
		WindowSwitch(driver);
		Thread.sleep(2000);
		
		//Click on the second resulting contact.
		String inputText2=driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).getText();
		driver.close();
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.xpath("(//td/input[@class='XdijitInputField dijitInputFieldValidationNormal'])[2]")).sendKeys(inputText2,Keys.ENTER);
		Thread.sleep(2000);
		
		//Click on the Merge button.	
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Thread.sleep(2000);
		
		//Accept the alert.
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		//Verify the title of the page.
		String titleOfTheCurrentWindow = driver.getTitle();
		System.out.println(titleOfTheCurrentWindow);
		
		if (titleOfTheCurrentWindow.equalsIgnoreCase("View Contact | opentaps CRM")) {
			System.out.println("Title is verified successfully");
		}else {
			System.out.println("Title is mismatching");
		}
		
		//Close the browser
		driver.quit();	

	}

}
