import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErailWebTable {

	public static void main(String[] args) {
		
		ChromeDriver driver;
		driver = new ChromeDriver();
		WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		// Load the URL http://leaftaps.com/opentaps/control/login.
		driver.get("https://erail.in/");
				
		// Maximize the browser window
		driver.manage().window().maximize();

		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter "MAS" as the "From" station. 
		WebElement From=driver.findElement(By.id("txtStationFrom"));
		From.clear();
		From.sendKeys("MAS",Keys.ENTER);
		
		//Enter "MDU" as the "To" station. 
		WebElement To=driver.findElement(By.id("txtStationTo"));
		To.clear();
		To.sendKeys("MDU",Keys.ENTER);
		
		//Uncheck the "Sort on Date" checkbox. 
		driver.findElement(By.id("chkSelectDateOnly")).click();
				
		int totalNoOfRows = driver.findElements(By.xpath("//table[contains(@class,'DataTable')]/tbody/tr")).size();
		System.out.println("====Trains From MAS to MDU " + (totalNoOfRows-1) + " with duplicate.======");
		
		Set<String> TrainNameSet=new LinkedHashSet<String>();
		//Retrieve the train names from the web table. 
		for (int i=2;i<=totalNoOfRows;i++) 
		{
			String TrainName=driver.findElement(By.xpath("//table[contains(@class,'DataTable')]/tbody/tr["+i+"]/td[2]")).getText();
			//System.out.println(TrainName);
			if (TrainName != null && !TrainName.isEmpty() && TrainName!="") {
		        TrainNameSet.add(TrainName);
		    }
		}
		
		//Verify if there are any duplicate train names in the web table.
		System.out.println("===UNIQUE TRAIN NAMES " + TrainNameSet.size() +" ====");
		TrainNameSet.forEach(train->System.out.println("→ " +train));
		
		//Close the browser
		driver.quit();

	}

}
