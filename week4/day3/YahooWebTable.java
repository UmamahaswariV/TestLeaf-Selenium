import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooWebTable {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		  options.addArguments("--guest");
		ChromeDriver driver;
		driver = new ChromeDriver();
		WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		// Load the URL https://finance.yahoo.com/
		driver.get("https://finance.yahoo.com/");
				
		// Maximize the browser window
		driver.manage().window().maximize();

		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		//Click on “Crypto” tab
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//button[@aria-label='More']"))).build().perform();
		//driver.findElement(By.xpath("//button[@aria-label='More']")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Finance: Crypto']")));
		driver.findElement(By.xpath("//a[@aria-label='Finance: Crypto']")).click();
		//action.click(driver.findElement(By.xpath("//a[@aria-label='Finance: Crypto']"))).build().perform();

		Thread.sleep(2000);
		//Locate the table in the dom page
		int TotalNoofColumns=driver.findElements(By.xpath("//table//th")).size();
		System.out.println("Total Number of Columns :"+TotalNoofColumns);
		int TotalNoofRows=driver.findElements(By.xpath("//table//tbody/tr")).size();
		System.out.println("Total Number of Rows :"+TotalNoofRows);
		String Rows=driver.findElement(By.xpath("//div[contains(@class,'total')]")).getText();
		String[] split=Rows.split(" ");
		int TotalNoofRows1=Integer.valueOf(split[2]);
		System.out.println("Total Number of Rows Pagination :"+TotalNoofRows1);		
		
		Thread.sleep(2000);
		//Locate the cryptocurrency names in the table using specific row and column.
		Set<String> CryptoNameSet=new LinkedHashSet<String>();
		for (int i=1;i<=TotalNoofRows;i++) 
		{
			//Use loop to iterate the cryptocurrency names
			String CryptoName=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText();
			//System.out.println(CryptoName);
			if (CryptoName != null && !CryptoName.isEmpty() && CryptoName!="") {
				CryptoNameSet.add(CryptoName);
		    }
		}
				
		//Print the cryptocurrency names
		System.out.println();
		System.out.println("===CRYPTO NAMES " + CryptoNameSet.size() +" ====");
		CryptoNameSet.forEach(crypto->System.out.println("→ " +crypto));
		
		//Close the browser
		driver.quit();
	}
}
