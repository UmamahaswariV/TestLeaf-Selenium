package week5.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Saleforce_LegalEntities extends Saleforce_ProjectSpecificMethod {
	
	@Test
	@Parameters({"CompanyName","Description"})
	public void runLegalEntities(String cname,String desc) throws InterruptedException {
		action = new Actions(driver);
		//Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		
		//Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities",Keys.ENTER);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']")))
	       .pause(1000)
	       .click()
	       .build().perform();
		Thread.sleep(1000);
		
		//Click on the Dropdown icon in the legal Entities tab
		driver.findElement(By.xpath("(//lightning-icon[@icon-name='utility:chevrondown'])[14]")).click();
		Thread.sleep(1000);
		
		//Click on New Legal Entity
		driver.findElement(By.xpath("(//one-app-nav-bar-menu-item[@class='slds-dropdown__item'])[1]")).click();
		Thread.sleep(1000);
		
		//Enter the Company name as 'TestLeaf'.
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(cname);
		Thread.sleep(1000);
		
		//Enter Description as 'Salesforces'.
		driver.findElement(By.xpath("(//textarea[@part='textarea'])[2]")).sendKeys(desc);
		Thread.sleep(1000);
		
		//Select Status as 'Active'
		action.scrollToElement(driver.findElement(By.xpath("//records-form-footer"))).perform();
		Thread.sleep(1000);
		action.click(driver.findElement(By.xpath("(//lightning-icon[@icon-name='utility:down'])[5]"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Active']")).click();
		
		//Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(500);
		
		//Verify the Alert message (Complete this field) displayed for Name
		String Alert="We hit a snag.";
		String DisplayedAlert=driver.findElement(By.xpath("//header[@class='pageErrorHeader slds-popover__header']")).getText();
		if(Alert.equals(DisplayedAlert)) {
			action.click(driver.findElement(By.xpath("//div[@class='fieldLevelErrors']//ul/li[1]"))).pause(1000).sendKeys("Uma").perform();
			System.out.println("Fields is Identified and Filled");
		}
		else
		{
			System.out.println("Fields is Not Identified and Filled");
		}
		
	
	}
}
