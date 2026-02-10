package week5.day3;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Saleforce_ProjectSpecificMethod {
	RemoteWebDriver driver;
	Actions action;
	@Parameters({"username","password","url","browserName"})
	@BeforeMethod
	public void PreCondition(String uname,String pswd,String url,String executionenv) throws InterruptedException {
		switch(executionenv.toLowerCase())
		{
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--guest");
			driver= new ChromeDriver(options);
			break;
		case "firfox":
			driver=new FirefoxDriver();
			break;
		default:
			ChromeOptions defaultoptions = new ChromeOptions();
			defaultoptions.addArguments("--guest");
			driver= new ChromeDriver(defaultoptions);
			break;
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pswd);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(10000);
	}
	
	@AfterMethod
	public void PostCondition() {
		driver.quit();
	}

}
