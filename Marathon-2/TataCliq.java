package week5.day5.Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TataCliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver; 
		driver = new ChromeDriver();

		// Load the URL https://www.tatacliq.com/.
		driver.get("https://www.tatacliq.com/");
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		//MouseHover on 'Brands'
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.id("moe-dontallow_button"))).perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryAndBrand'])[2]"))).build().perform();
		Thread.sleep(1000);
		
		//MouseHover on 'Watches & Accessories'
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryDetailsValue'])[4]"))).perform();
		Thread.sleep(1000);
		
		//Choose the first option from the 'Featured brands'.
		action.click(driver.findElement(By.xpath("(//div[@class='DesktopHeader__brandsDetails'])[1]"))).perform();
		Thread.sleep(2000);
		
		//Select sortby: New Arrivals
		WebElement selectBox=driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select sort=new Select(selectBox);
		sort.selectByVisibleText("New Arrivals");
		Thread.sleep(1000);
		
		//choose men from catagories filter.
		action.click(driver.findElement(By.xpath("(//div[@class='FilterDesktop__newFilName'])[1]"))).perform();
		Thread.sleep(2000);
		
		//print all price of watches
		List<WebElement> productDescription=driver.findElements(By.xpath("(//h2[@class='ProductDescription__description  '])"));
		List<WebElement> priceElements=driver.findElements(By.xpath("//div[@class='ProductDescription__content']//h3"));
		List<String> products = new ArrayList<>();
		List<String> prices = new ArrayList<>();
        for (int i=0;i<productDescription.size();i++) {
        	 products.add(productDescription.get(i).getText().trim());
        	 prices.add(priceElements.get(i).getText().trim());
          }
        System.out.println("===Product Description and Prices " + products.size() +" ====");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("Product %d: %s | %s%n", 
                i+1, 
                products.get(i).trim(),
                prices.get(i));
        }
        Thread.sleep(2000);
		
		//click on the first resulting watch.
        action.click(driver.findElement(By.xpath("(//div[@class='Grid__element'])[1]"))).perform();
        Thread.sleep(2000);
        
        Set<String> currentlyActiveWindowIds = driver.getWindowHandles();
	    List<String> listOfCurrentlyActiveWindowsID= new ArrayList<String>(currentlyActiveWindowIds);
	    driver.switchTo().window(listOfCurrentlyActiveWindowsID.get(1));
        Thread.sleep(2000);
        System.out.println();
        
		//compare two price are similar 
        String firstProductprice=driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']")).getText();
        int Productprice =Integer.parseInt(firstProductprice.replaceAll("[^0-9]", ""));
        int listprice=Integer.parseInt(prices.get(0).replaceAll("[^0-9]", ""));
        if(listprice==Productprice)
        	System.out.println("Price of selected product is similar to 1st product in list");
        else
        	System.out.println("Price of selected product is not similar to 1st product in list");
        System.out.println();
        
		//click Add to cart and get count from the cart icon.
        action.click(driver.findElement(By.xpath("(//div[@class='Button__base'])[3]"))).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'The item has been added to your bag')]")));
		int cartItem=Integer.parseInt(driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText());
		System.out.println("Cart Item count : "+cartItem);
		Thread.sleep(2000);
		
		//Click on the cart
		action.click(driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']"))).perform();
		Thread.sleep(2000);
        
		//Take a snap of the resulting page.
		File src=driver.getScreenshotAs(OutputType.FILE);
		File Target=new File("./snap/TataCliqproduct.png");
		FileUtils.copyFile(src, Target);
		
		//Close All the opened windows one by one.
		driver.close();
		driver.quit();

	}

}
