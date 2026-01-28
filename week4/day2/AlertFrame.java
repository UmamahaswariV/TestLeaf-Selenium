import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
public class AlertFrame {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver; 
		driver = new ChromeDriver();

		// Load the URL https://leafground.com/checkbox.xhtml.
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		//Switch to the frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
		
		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click the "Try It" button inside the frame
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		
		//Click OK/Cancel in the alert that appears
		driver.switchTo().alert().accept();
		
		//Confirm the action is performed correctly by verifying the text displayed
		System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());
		
		//Take ScreenShot
		File src=driver.getScreenshotAs(OutputType.FILE);
		File Target=new File("./snap/framess.png");
		FileUtils.copyFile(src, Target);
		driver.quit();

	}

}
