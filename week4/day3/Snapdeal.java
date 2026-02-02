import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver; 
		driver = new ChromeDriver();

		// Load the URL https://leafground.com/checkbox.xhtml.
		driver.get("https://www.snapdeal.com/");
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Go to "Men's Fashion". //Go to "Sports Shoes".
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("tab-category-0"))).click().build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//div[contains(text(),'Sports')])[2]"))).click().build().perform();		
		
		//Get the count of sports shoes.
		System.out.println("Total Count of Sport Shoes :"+driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText().replace("(","").replace(")",""));
		
		//Click on "Training Shoes".
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]"))).click().build().perform();
		Thread.sleep(2000);
		
		//Sort the products by "Low to High".
		action.click(driver.findElement(By.xpath("//div[@class='sort-drop clearfix']"))).build().perform();
		action.click(driver.findElement(By.xpath("//ul[@class='sort-value']/li[@data-index='1']"))).build().perform();
		Thread.sleep(2000);
		
		//Check if the displayed items are sorted correctly.
		String PriceXpath="//span[@class='lfloat product-price']";
		verifyLowToHighSorting(driver,PriceXpath);
		
		//Select any price range ex:(500-700).
		action.scrollToElement(driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"))).perform();
		Thread.sleep(2000);
		action.dragAndDropBy(driver.findElement(By.xpath("//div[@class='filter-inner']//a[1]")),2,0).build().perform();
		Thread.sleep(2000);
		String FromPrice=driver.findElement(By.xpath("//div[@class='clear']/span[@class='from-price-text']")).getText();
		action.scrollToElement(driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"))).perform();
		Thread.sleep(2000);
		action.dragAndDropBy(driver.findElement(By.xpath("//div[@class='filter-inner']//a[2]")),-200,0).build().perform();
		Thread.sleep(2000);
		String ToPrice=driver.findElement(By.xpath("//div[@class='clear']/span[@class='to-price-text']")).getText();

		//Filter by any colour.
		action.scrollToElement(driver.findElement(By.xpath("(//div[@class='filter-name-section filter-type clearfix'])[6]"))).perform();
		Thread.sleep(2000);
		action.click(driver.findElement(By.xpath("(//a[@class='filter-name'])[11]"))).build().perform();
		Thread.sleep(2000);
		action.scrollToElement(driver.findElement(By.xpath("(//div[@class='filter-name-section filter-type clearfix'])[6]"))).perform();

		//Verify all the applied filters.
		String FilterFromPrice=driver.findElement(By.xpath("//div[@class='clear']/span[@class='from-price-text']")).getText();
		String FilterToPrice=driver.findElement(By.xpath("//div[@class='clear']/span[@class='to-price-text']")).getText();
		WebElement CheckBox=driver.findElement(By.xpath("//div[@data-name='Color_s']//input"));
		if((FromPrice.equals(FilterFromPrice))&&(ToPrice.equals(FilterToPrice))&&CheckBox.isSelected()) {
			System.out.println("All Filters Verified");
		//	System.out.println(FromPrice+" "+FilterFromPrice+" "+ToPrice+" "+FilterToPrice);
		}
		else {
			System.out.println("Changes in Filter applied");
		//	System.out.println(FromPrice+" "+FilterFromPrice+" "+ToPrice+" "+FilterToPrice);
		}		
		
		//Mouse hover on the first resulting "Training Shoes".
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='product-tuple-image '])[1]"))).build().perform();
		
		//Click the "Quick View" button.
		action.click(driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]"))).build().perform();
		Thread.sleep(2000);
		
		//Print the cost and the discount percentage.
		String OriginalCostofProduct=driver.findElement(By.xpath("//span[@class='strikee ']")).getText();
		String DiscountedPrice=driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
		System.out.println("Original Price of the Product   : "+OriginalCostofProduct);
		System.out.println("Discounted Price of the Product : "+DiscountedPrice);
		
		//Take a snapshot of the shoes.
		File src=driver.getScreenshotAs(OutputType.FILE);
		File Target=new File("./snap/snapdealsportsshoe.png");
		FileUtils.copyFile(src, Target);
		Thread.sleep(2000);
		
		//Close the current window.
		action.click(driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]"))).build().perform();
		
		//Close the main window.
		driver.quit();
		

	}
	public static boolean isAscendingOrder(List<Integer> prices) {
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;  // Found decreasing pair
            }
        }
        return true;
    }
	public static void verifyLowToHighSorting(WebDriver driver,String Xpath) {
		List<WebElement> priceElements=driver.findElements(By.xpath(Xpath));
        List<Integer> prices = new ArrayList<>();
        for (WebElement priceEl : priceElements) {
            String priceText = priceEl.getText().replaceAll("Rs. ", "").replaceAll("[,\\s]", "").trim();
            prices.add(Integer.parseInt(priceText));
        }
        boolean isSorted = isAscendingOrder(prices);
        if(isSorted)
           	System.out.println("Prices displayed from Low to High is Verified");
        else
           	System.out.println("Prices not displayed from Low to High");

	}

}
