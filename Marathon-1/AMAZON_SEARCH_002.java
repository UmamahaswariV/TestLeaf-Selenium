import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AMAZON_SEARCH_002 {

	public static void main(String[] args) throws InterruptedException {
		//Launch the browser
		WebDriver driver = new ChromeDriver();
		//Add Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        // Load the URL
        driver.get("https://www.amazon.in");
        
        // Search "Bags for boys"
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Bags for boys",Keys.ENTER);
       
        //Capture and print the total number of search results displayed
        String TotalSearch=driver.findElement(By.xpath("//div[@class='a-section a-spacing-none s-breadcrumb-header-text']")).getText();
        System.out.println(TotalSearch);
       
        //Select the first two brands from the left-side filter menu
        driver.findElement(By.xpath("(//div[@id='brandsRefinements']//i[@class='a-icon a-icon-checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//div[@id='brandsRefinements']//i[@class='a-icon a-icon-checkbox'])[2]")).click();
       
        //Apply sorting by selecting "New Arrivals"
        driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
        driver.findElement(By.xpath("//li/a[contains(text(),\"Newest Arrivals\")]")).click();
       
        //Capture and print the first product details (name and discounted price)
        String ProductName=driver.findElement(By.xpath("((//div[@class='a-section a-spacing-base desktop-grid-content-view'])[1]//h2)[1]")).getText();
        System.out.println("Product Name : "+ProductName);
        String ProductDetail=driver.findElement(By.xpath("((//div[@class='a-section a-spacing-base desktop-grid-content-view'])[1]//h2)[2]")).getText();
        System.out.println("Product Details : "+ProductDetail);
        String ProductPrice=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base desktop-grid-content-view'])[1]//span[@class='a-price']")).getText();
        System.out.println("Discounted Price : "+ProductPrice);
       
        //Capture and print the page title
        String PageTitle=driver.getTitle();
        System.out.println("Title of current page : "+PageTitle);
        
        //Close the browser
        driver.quit();
        
	}

}
