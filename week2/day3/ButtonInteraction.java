import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonInteraction {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver; 
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Load the URL https://leafground.com/checkbox.xhtml.
		driver.get("https://leafground.com/button.xhtml");
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on the button with the text ‘Click and Confirm title.’
		driver.findElement(By.xpath("//span[contains(text(),'Click')]")).click();
	    Thread.sleep(2000);
		
	    System.out.println("-------Title of the page is ‘dashboard’--------");
		//Verify that the title of the page is ‘dashboard.’
	    String titleOfTheCurrentWindow = driver.getTitle();
	    System.out.println("Title of Page :"+titleOfTheCurrentWindow);
		if (titleOfTheCurrentWindow.contains("Dashboard")) {
			System.out.println("Title is verified successfully");
		}else {
			System.out.println("Title is mismatching");
		}
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println();
		
		System.out.println("------Confirm if the button is disabled------");
		//Check if the button with the text ‘Confirm if the button is disabled’ is disabled.
		if(driver.findElement(By.xpath("(//div[@class='card']//button[@type='button'])[2]")).isEnabled())
			System.out.println("Button is Enabled");
		else
			System.out.println("Button is Disabled");
		System.out.println();
		
		System.out.println("------Position of the Submit Button------");
		//Find and print the position of the button with the text ‘Submit.’
		WebElement submitButton=driver.findElement(By.xpath("(//div[@class='card']//button[@type='button'])[3]"));
		Point ButtonPosition = submitButton.getLocation();
		System.out.println("X-Coord location: "+ButtonPosition.getX()+"  |  Y-Coord location: "+ButtonPosition.getY());
		System.out.println();
		
		System.out.println("------Find the Save button color------");
		//Find and print the background color of the button with the text ‘Find the Save button color.’
		WebElement saveButton=driver.findElement(By.xpath("(//div[@class='card']//button[@type='button'])[4]"));
		System.out.println("Text Colour of Save Button : "+saveButton.getCssValue("color"));
		System.out.println("Background Colour of Save Button : "+saveButton.getCssValue("background-color"));
		System.out.println();
		
		System.out.println("----Find the height and width of this button----");
		//Find and print the height and width of the button with the text ‘Find the height and width of this button.’
		WebElement submitButton2=driver.findElement(By.xpath("(//div[@class='card']//button[@type='button'])[5]"));
		Dimension Buttonsize = submitButton2.getSize();
		System.out.println("Height : "+Buttonsize.getHeight()+"  |  Width "+Buttonsize.getWidth());
		System.out.println();
		
		System.out.println("----Mouse Over to find Button Colour----");
		//Mouse over and confirm the color changed
		WebElement successButton=driver.findElement(By.xpath("(//div[@class='card']//button[@type='button'])[6]"));
		//System.out.println("Border Radius of the button : "+successButton.getCssValue("border-radius"));
		String normalColor = successButton.getCssValue("background-color");
        System.out.println("Normal Color of success Button : " + normalColor);
		Actions actions = new Actions(driver);
        actions.moveToElement(successButton).perform();
        Thread.sleep(1000); 
        String hoverColor = successButton.getCssValue("background-color");
        System.out.println("Hover Color of success Button : " + hoverColor);
        System.out.println();
        Thread.sleep(2000);
        
        System.out.println("-------Click Image Button Check image dispalyed------");
        //Click Image Button and Click on any hidden button
        driver.findElement(By.xpath("//div[@class='grid formgrid']//button[@type='button']")).click(); 
        WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-overlaypanel-content']/img")));
        if (image.isDisplayed()) {
            System.out.println("Image is DISPLAYED");
        } else {
            System.out.println("Image is HIDDEN");
        }
        System.out.println();
        Thread.sleep(2000);
        
        System.out.println("-------Click on any hidden button-------");
        driver.findElement(By.xpath("//div[@class='card ui-fluid']")).click();
        Thread.sleep(2000);
        if (image.isDisplayed()) {
            System.out.println("Image is DISPLAYED");
        } else {
            System.out.println("Image is HIDDEN");
        }
        System.out.println();
        Thread.sleep(2000);
        
        System.out.println("-------Find Rounded Buttons-------");
        //Find Which buttons have rounded corners
        int totalNoOfButtons=driver.findElements(By.xpath("(//div[@class='card'])[7]/button[@type='button']")).size();
        for(int i=1;i<=totalNoOfButtons;i++) {
        	WebElement buttonRadius=driver.findElement(By.xpath("(//div[@class='card'])[7]/button[@type='button']["+i+"]"));
        	String borderRadius=buttonRadius.getCssValue("border-radius");
        	String buttonName=buttonRadius.getText();        	
        	if(!borderRadius.equals("0px"))
        	{
        		 System.out.println(buttonName+" is "+borderRadius+" Button is ROUNDED!");
        	} else {
        	    System.out.println(buttonName+" Button is NOT rounded (square corners)");
        	}
        }
        
		//Close the browser window.
		driver.quit();

	}

}
