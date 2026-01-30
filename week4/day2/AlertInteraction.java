import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertInteraction {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver; 
		driver = new ChromeDriver();

		// Load the URL https://leafground.com/checkbox.xhtml.
		driver.get("https://www.leafground.com/alert.xhtml");
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(30));
		Thread.sleep(2000);
		
		System.out.println("----------Simple Prompt Box---------------");
		//Click on the "Prompt Box" button to trigger the alert.
		driver.findElement(By.xpath("(//button[@role='button'])[6]")).click();
		Thread.sleep(2000);
		
		//Switch to the alert and type a message in the alert box.
		Alert prompt = waits.until(ExpectedConditions.alertIsPresent());
		prompt.sendKeys("Hello");
		//prompt.accept();
		Thread.sleep(2000);
		
		//Dismiss the alert.
		prompt.dismiss();
		Thread.sleep(2000);
		
		//Retrieve the typed text from the alert and verify it.
		String promptMessage=driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(promptMessage);
		if(promptMessage.equals("User cancelled the prompt."))
			System.out.println("Expected Message is displayed");
		else
			System.out.println("Expected Message is Not displayed");
		System.out.println();
		
		System.out.println("----------Simple Dialog Box---------------");
		//Alert Simple Dialog Box
		driver.findElement(By.xpath("(//button[@role='button'])[1]")).click();
		Thread.sleep(2000);
		prompt.accept();
		System.out.println(driver.findElement(By.xpath("//span[@id='simple_result']")).getText());
		System.out.println();
		
		System.out.println("----------Confirm Dialog Box---------------");
		//Alert Confirm Dialog Box
		driver.findElement(By.xpath("(//button[@role='button'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("--Accepting Confirm Dialog Box---");
		prompt.accept();
		System.out.println(driver.findElement(By.xpath("//span[@id='result']")).getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@role='button'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("--Cancelling Confirm Dialog Box---");
		prompt.dismiss();
		System.out.println(driver.findElement(By.xpath("//span[@id='result']")).getText());
		Thread.sleep(2000);
		System.out.println();
		
		System.out.println("--------SweetAlert Simple Dialog Box----------");
		//Sweet Alert Simple Dialog Box
		driver.findElement(By.xpath("(//button[@role='button'])[3]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("(//div[@class='ui-dialog-content ui-widget-content'])[1]/p")).getText());
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(2000);
		System.out.println();
		
		System.out.println("--------Sweet Modal Dialog Box----------");
		//Sweet Modal Dialog Box
		driver.findElement(By.xpath("(//button[@role='button'])[5]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("(//div[@class='ui-dialog-content ui-widget-content'])[2]/p")).getText());
		driver.findElement(By.xpath("(//a[@aria-label='Close'])[2]")).click();
		System.out.println();
		Thread.sleep(2000);
		
		System.out.println("--------Sweet Alert Confirmation Box----------");
		//Sweet Alert Confirmation Box
		driver.findElement(By.xpath("(//button[@role='button'])[7]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//span[@class='ui-confirm-dialog-message']")).getText());
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		System.out.println("1st time Confirmation : YES button is Clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@role='button'])[7]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		System.out.println("2nd time Confirmation : NO button is Clicked");
		System.out.println();
		Thread.sleep(2000);
		
		System.out.println("--------Minimize & Maximize----------");
		driver.findElement(By.xpath("(//button[@role='button'])[8]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("(//div[@class='ui-dialog-content ui-widget-content'])[3]/p")).getText());
		driver.findElement(By.xpath("(//a[@role='button'])[5]")).click();
		System.out.println("Minimized Button in Alert is clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@role='button'])[4]")).click();
		System.out.println("Maximized Button in Alert is clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@role='button'])[3]")).click();
		System.out.println("Closed Button in Alert is clicked");
		Thread.sleep(2000);
		
		//Close the browser
		driver.quit();		

	}

}
