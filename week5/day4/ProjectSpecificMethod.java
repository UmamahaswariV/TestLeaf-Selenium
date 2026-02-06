import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod {
	RemoteWebDriver driver;//null
	public String fileName;// null
	
	@Parameters({"username","password","url","browserName"})  // Same attribute value in the xml file  should be called here, order doesn't matter
	@BeforeMethod
	public void preCondition(String uname,String pword, String appUrl,String executionEnv) { // Same order in the pipeline should be maintained here
		switch (executionEnv.toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--guest");
			driver = new ChromeDriver(options);
			break;
		case "firefox" :
			driver = new FirefoxDriver();
			break;

		default:
			ChromeOptions defaultOptions = new ChromeOptions();
			defaultOptions.addArguments("--guest");
			driver = new ChromeDriver(defaultOptions);
			break;
		}
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@AfterMethod
	public void postCondition() {
		driver.quit();
	}
	
	@DataProvider(name = "extractData")
	public String[][] dataLibrary() throws IOException {
            return ReadExcelData.extractDataFromExcel(fileName) ;  
            		}

}
