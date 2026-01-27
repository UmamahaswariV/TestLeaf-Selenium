import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC_WindowHandle {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
	     // Launch & Load URL
	     driver.get("https://www.irctc.co.in/");
	     
	     //Maximize the browser window
	     driver.manage().window().maximize();
	    
	     //Add an implicit wait to ensure the webpage elements are fully loaded
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	     driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
	     System.out.println(driver.getTitle());
	    
	     //Load the IRCTC webpage and click on the "FLIGHTS" link.
	     driver.findElement(By.xpath("//li[@id='flight']/a/label")).click();
	     
	     //Capture the title of the new window that opens (flights window - AirTicket).
	     Set<String> currentlyActiveWindowIds = driver.getWindowHandles();
	     List<String> listOfCurrentlyActiveWindowsID= new ArrayList<String>(currentlyActiveWindowIds);
	     driver.switchTo().window(listOfCurrentlyActiveWindowsID.get(1));
	     System.out.println(driver.getTitle());
	     
	     //Close the parent tab (Train ticket booking) alone
	     driver.switchTo().window(listOfCurrentlyActiveWindowsID.get(0));
	     driver.close();
	    

	}

}
