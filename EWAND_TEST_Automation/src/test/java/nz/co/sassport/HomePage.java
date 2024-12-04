package nz.co.sassport;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    //Check main menu available for the admin users
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        try {
            // Open the specified URL
            driver.get("http://127.0.0.1");
            driver.manage().window().maximize();

            // Your additional code here

        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions
        } finally {

            Thread.sleep(2000);

            //check the logo
            driver.findElement(By.xpath(""));
        }
    }
}
