package steps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionSaleforce {
	ChromeDriver driver;
	String Name="Uma";
	@Given("user launch the Web browser.")
	public void Salesforce_login_page() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@Given("user is on Salesforce login page.")
	public void user_is_on_salesforce_login_page() {
		driver.get("https://login.salesforce.com");
	}
	@Given("user logs into Salesforce")
	public void user_logs_into_salesforce() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("uma12051989.799173caca9e@agentforce.com");
		driver.findElement(By.id("password")).sendKeys("Uma@Sale#12");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(10000);
	}
	@Given("user clicks toggle menu button from left corner")
	public void user_clicks_toggle_menu_button_from_left_corner_div_class() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
	}
	@Given("user clicks View All and selects Sales from App Launcher")
	public void user_clicks_and_selects_from_app_launcher() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(2000);
	}
	@Given("user navigates to Accounts tab")
	public void user_navigates_to_accounts_tab() throws InterruptedException {
		driver.findElement(By.xpath("(//lightning-icon[@icon-name='utility:chevrondown'])[5]")).click();
		Thread.sleep(1000);
	}
	@Given("user clicks New button")
	public void user_clicks_new_button() throws InterruptedException {
		driver.findElement(By.xpath("(//one-app-nav-bar-menu-item[@class='slds-dropdown__item'])[1]")).click();
		Thread.sleep(2000);
	}
	@Given("user enters Your Name as account name")
	public void user_enters_as_account_name() {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(Name);
	}
	@Given("user selects Ownership as Public")
	public void user_selects_ownership_as() throws InterruptedException {
		driver.findElement(By.xpath("(//lightning-icon[@icon-name='utility:down'])[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Public']")).click();   
	}
	@When("user clicks Save button")
	public void user_clicks_button() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}
	@Then("account name Your Name is displayed successfully")
	public void account_name_is_displayed_successfully() {
		String AccountName=driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		Assert.assertEquals(Name, AccountName);
	}
	


}
