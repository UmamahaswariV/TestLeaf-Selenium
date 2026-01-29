import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesInteraction {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver; 
		driver = new ChromeDriver();

		// Load the URL https://leafground.com/checkbox.xhtml.
		driver.get("https://leafground.com/checkbox.xhtml");
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Click on the "Basic Checkbox”
		driver.findElement(By.xpath("(//span[@class='ui-chkbox-label'])[1]")).click();
		Thread.sleep(2000);
		
		//Click on the "Notification Checkbox"
		driver.findElement(By.xpath("(//span[@class='ui-chkbox-label'])[2]")).click();
		Thread.sleep(2000);
		
		System.out.println("---------------------------------------");
		System.out.println("-----   Notification Checkbox   -------");
		System.out.println("---------------------------------------");
		// Verify that the expected message is displayed.
		String AlertMessage1=driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText();
		if(AlertMessage1.equals("Checked"))
			System.out.println("Expected Message is Displayed in Alert");
		else
			System.out.println("Expected Message is Not Displayed in Alert");
		Thread.sleep(3000);
		System.out.println();
		
		//Click on your favorite language (assuming it's related to checkboxes).
		driver.findElement(By.xpath("(//label[contains(text(),'Java')])[1]")).click();
		Thread.sleep(3000);
		
		//Click on the "Tri-State Checkbox." 
		driver.findElement(By.xpath("(//div[@class='ui-chkbox ui-widget'])[6]")).click();
		
		System.out.println("---------------------------------------");
		System.out.println("-----  Tri-State Checkbox   -------");
		System.out.println("---------------------------------------");
		//Verify which tri-state option has been chosen.
		String AlertMessage2=driver.findElement(By.xpath("//div[@class='ui-growl-message']//p")).getText();
		System.out.println(AlertMessage2+" is choosen");
		Thread.sleep(2000);
		System.out.println();
		
		//Click on the "Toggle Switch."
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch ui-widget']")).click();
		Thread.sleep(2000);
		
		System.out.println("---------------------------------------");
		System.out.println("-----------  Toggle Switch  -----------");
		System.out.println("---------------------------------------");
		//Verify that the expected message is displayed.
		String AlertMessage3=driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText();
		if(AlertMessage3.equals("Checked"))
			System.out.println("Expected Message is Displayed in Alert");
		else
			System.out.println("Expected Message is Not Displayed in Alert");
		Thread.sleep(3000);
		System.out.println();
		
		System.out.println("---------------------------------------");
		System.out.println("------  Not Selectable CheckBox  ------");
		System.out.println("---------------------------------------");
		//Verify if the Checkbox is disabled.
		boolean Check=driver.findElement(By.xpath("//span[@class='ui-chkbox-label ui-state-disabled']")).isSelected();
		if(Check)
			System.out.println("CheckBox is Enabled");
		else
			System.out.println("CheckBox is Disabled");
		Thread.sleep(2000);
		System.out.println();
		
		//Select multiple options on the page (details may be needed).
		driver.findElement(By.xpath("//ul[@class='ui-selectcheckboxmenu-multiple-container ui-widget ui-inputfield ui-state-default ui-corner-all']")).click();
		Thread.sleep(1000);
		
		String[] Places={"Miami","Rome","Amsterdam","Paris"};		
		for(int i=0;i<=Places.length-1;i++)
		{
			driver.findElement(By.xpath("(//label[contains(text(),'"+Places[i]+"')])[2]")).click();
		}	
		driver.findElement(By.xpath("//a[@aria-label='Close']")).click();
		
		System.out.println("-----------------------------------------");
		System.out.println("------Select Multiple CheckBox list------");
		System.out.println("-----------------------------------------");
		//Perform any additional actions or verifications required.
		for(int i=0;i<=Places.length-1;i++)
		{
			boolean check1=driver.findElement(By.xpath("//li[@data-item-value='"+Places[i]+"']/span[2]")).isDisplayed();
			if(check1)
				System.out.println(Places[i]+" is Displayed");
			else
				System.out.println(Places[i]+" is Not Displayed");
		}
		
		Thread.sleep(4000);
		
		//Close the web browser when done.
		driver.quit();
	
	}

}
