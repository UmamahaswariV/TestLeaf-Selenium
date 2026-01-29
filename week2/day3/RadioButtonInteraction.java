import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonInteraction {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver; 
		driver = new ChromeDriver();

		// Load the URL https://leafground.com/checkbox.xhtml.
		driver.get("https://www.leafground.com/radio.xhtml");
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Select 'Your most favourite browser' from the radio buttons
		driver.findElement(By.xpath("(//label[contains(text(),'Firefox')])[1]")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']//input[@type='radio'])[13]")).isSelected())
			System.out.println("Favourite browser Radio Button is Selected");
		else
			System.out.println("Favourite browser Radio Button is Not Selected");	
		System.out.println();
		
		System.out.println("1st Click on Radio Button");
		//Click on a radio button, then click on the same radio button again to verify that it becomes ‘unselected’.
		driver.findElement(By.xpath("//label[contains(text(),'Chennai')]")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']//input[@type='radio'])[16]")).isSelected())
			System.out.println("Chennai Radio Button is Selected");
		else
			System.out.println("Chennai Radio Button is UnSelected");
		System.out.println();
		
		System.out.println("2nd Click on Radio Button");
		driver.findElement(By.xpath("//label[contains(text(),'Chennai')]")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("(//div[@class='ui-radiobutton ui-widget']//input[@type='radio'])[16]")).isSelected())
			System.out.println("Chennai Radio Button is Selected");
		else
			System.out.println("Chennai Radio Button is UnSelected");
		System.out.println();
		
		System.out.println("Initially selected by default Radio button");
		//Identify the radio button that is initially selected by default.
		int NoOfradioButton1=driver.findElements(By.xpath("(//table[@class='ui-selectoneradio ui-widget'])[6]//td")).size();
		for(int i=1;i<=NoOfradioButton1;i++)
		{
			String browser1=driver.findElement(By.xpath("(//table[@class='ui-selectoneradio ui-widget'])[6]//td["+i+"]")).getText();
			if(driver.findElement(By.xpath("((//table[@class='ui-selectoneradio ui-widget'])[6]//td//input)["+i+"]")).isSelected())
				System.out.println(browser1 +" is selected by default");
			else
				System.out.println(browser1 +" is not selected by default");
				
		}System.out.println();
			
		System.out.println("Check Age group (21-40 years) is Selected or not");
		//Check and select the age group (21-40 Years) if not already selected.
		if(driver.findElement(By.xpath("((//div[@class='grid formgrid'])[4]//input[@type='radio'])[2]")).isSelected())
			System.out.println("Age group 21-40 years is selected by default");
		else
		{
			driver.findElement(By.xpath("((//div[@class='grid formgrid'])[4]//input[@type='radio'])[2]")).click();
			System.out.println("Age group 21-40 years is selected as per the request");
		}
		
		/*
		int NoOfradioButton2=driver.findElements(By.xpath("(//div[@class='grid formgrid'])[4]//input[@type='radio']")).size();
		for(int i=1;i<=NoOfradioButton2;i++)
		{
			String browser2=driver.findElement(By.xpath("((//div[@class='grid formgrid'])[4]//label)["+i+"]")).getText();
			if(driver.findElement(By.xpath("((//div[@class='grid formgrid'])[4]//input[@type='radio'])["+i+"]")).isSelected())
				System.out.println(browser2 +" is selected by default");
			else
				System.out.println(browser2 +" is not selected by default");
		}
		*/		
		
		// Close the browser
		driver.close();

	}

}
