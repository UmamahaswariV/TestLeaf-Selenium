import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {
	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver; 
		driver = new ChromeDriver();

		// Load the URL https://leafground.com/checkbox.xhtml.
		driver.get("https://www.amazon.in/");
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Search for "oneplus 9 pro".
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("oneplus 9 pro",Keys.ENTER);
        
		//Get the price of the first product.
        String FirstProductName=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base'][1]")).getText();
        double FirstProductPrice=Double.parseDouble(driver.findElement(By.xpath("//span[@class='a-price-whole'][1]")).getText());
        
		//Print the number of customer ratings for the first displayed product.
        String FirstProductRating=driver.findElement(By.xpath("//span[@class='a-icon-alt'][1]")).getText();
        
        System.out.println("--------------Firtst Product Details--------------");
        System.out.println("Product Name	:"+FirstProductName);
        System.out.println("Product Price	:"+FirstProductPrice);
        System.out.println("Product Rating	:"+FirstProductRating);
		System.out.println("---------------------------------------------------");
		System.out.println();
        
		//Click the first text link of the first image.
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("(//a/h2/span)[1]"))).pause(1000).click().perform();
        
        Set<String> currentlyActiveWindowIds = driver.getWindowHandles();
	    List<String> listOfCurrentlyActiveWindowsID= new ArrayList<String>(currentlyActiveWindowIds);
	    driver.switchTo().window(listOfCurrentlyActiveWindowsID.get(1));
        Thread.sleep(2000);
         
		//Take a screenshot of the product displayed.
	    File src=driver.getScreenshotAs(OutputType.FILE);
		File Target=new File("./snap/amazonOneplus.png");
		FileUtils.copyFile(src, Target);
	    
		//Click the 'Add to Cart' button.
		driver.findElement(By.xpath("//input[@name='submit.add-to-cart']")).click();
		System.out.println("Selected Product is Added to the Cart");
		Thread.sleep(2000);
		
		//Get the cart subtotal and verify if it is correct. 
		double ProductSubtotalValue=Double.parseDouble(driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText());
		if(FirstProductPrice==ProductSubtotalValue) {
			System.out.println("Cart SubTotal Value is same as Selected Product Value");
			System.out.println("Cart Value : "+ProductSubtotalValue);
		}
		else
		{
			System.out.println("Cart SubTotal Value is not same as Selected Product Value");
			System.out.println("Cart Value : "+ProductSubtotalValue);
		}
		
		//Close the browser.
		driver.quit();

	}

}
