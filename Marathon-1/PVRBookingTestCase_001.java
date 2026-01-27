import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class PVRBookingTestCase_001 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
            // Launch & Load URL
            driver.get("https://www.pvrcinemas.com/");
            System.out.println("Launched PVR Cinemas");
            
            //Location dropdown is selected
            driver.findElement(By.xpath("//div[@class='p-dropdown-trigger'][contains(@aria-label,'[object Object]')]")).click(); 
            
            //Searched Chennai in Search Box
            driver.findElement(By.xpath("//span[@id='city']/input")).sendKeys("Chennai",Keys.ENTER);
            
            //Selected Chennai in search Box list
            driver.findElement(By.xpath("//ul[@id='city_list']/li")).click();
          
            //Click Cinema under Quick Book
            driver.findElement(By.xpath("(//div[@class='date-show']/span)[2]")).click();
            Thread.sleep(2000);        
            
            //Select a cinema
            driver.findElement(By.id("cinema")).click();
            WebElement firstCinema = driver.findElement(By.xpath("(//li[@class='p-dropdown-item'])[1]"));
            System.out.println("Cinema :"+firstCinema.getText());
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//li[@class='p-dropdown-item'])[1]")).click();
            Thread.sleep(1000);
           
            //Select Tomorrow's date
            WebElement Date = driver.findElement(By.xpath("//li[2]/span[contains(text(),'Tomorrow')]"));
            Thread.sleep(1000);
            //driver.findElement(By.id("date")).click();
            driver.findElement(By.xpath("//li[2]/span[contains(text(),'Tomorrow')]")).click();
            System.out.println("Date :"+Date.getText());
            Thread.sleep(1000);
            
            //Select movie
            //driver.findElement(By.id("movie")).click();
            //WebElement Movie = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[1]")); 
            WebElement Movie = driver.findElement(By.xpath("(//div[@class='p-dropdown-panel p-component p-ripple-disabled p-connected-overlay-enter-done']//li[@class='p-dropdown-item'])[1]"));
            System.out.println("Movie Name : "+Movie.getText());
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//div[@class='p-dropdown-panel p-component p-ripple-disabled p-connected-overlay-enter-done']//li[@class='p-dropdown-item'])[1]")).click();
            Thread.sleep(1000);   
            
            //Select show time
            //driver.findElement(By.xpath("//div[@id='time']")).click();
            WebElement Time = driver.findElement(By.xpath("(//li[@class='p-dropdown-item']//span[@class='mx-2'])[1]"));
            driver.findElement(By.xpath("(//li[@class='p-dropdown-item']//span[@class='mx-2'])[1]")).click();
            System.out.println("Time : "+Time.getText());
            Thread.sleep(1000);
            
            //Click on Book button
            driver.findElement(By.xpath("//button[@class='p-button p-component sc-hjsuWn kDwaXw bgColor filter-btn']")).click();
            Thread.sleep(2000);
            
            //Accept Terms and Conditions
            driver.findElement(By.xpath("//button[@class='sc-kCuUfV iBvycX reject-terms']")).click();
            Thread.sleep(1000);
            
            //Select any one available seat
            driver.findElement(By.xpath("//span[@class='seat-current-pvr']")).click();
            Thread.sleep(1000);
            
            //Click on Proceed button
            driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
            Thread.sleep(3000);
           
            //Capture and print Seat info from Booking Summary
            WebElement SeatInfo = driver.findElement(By.xpath("//div[@class='seat-info']"));
            System.out.println(SeatInfo.getText());
            Thread.sleep(1000);
           
            //Capture and print Grand Total from Booking Summary
            WebElement GrandTotal = driver.findElement(By.xpath("//div[@class='grand-tota col-md-3']"));
            System.out.println(GrandTotal.getText());
            Thread.sleep(1000);
            
            //Click on Continue button
            driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
            Thread.sleep(2000);
            
            //Close the popup if displayed
            driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
            Thread.sleep(1000);
           
            //Capture and print current page title
            String PageTitle=driver.getTitle();
            System.out.println("Title of current page : "+PageTitle);
            
            //Close the browser
            driver.quit();  
       
    }
}
