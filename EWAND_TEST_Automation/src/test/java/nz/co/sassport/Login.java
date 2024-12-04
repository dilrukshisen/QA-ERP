package nz.co.sassport;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.http.WebSocket;

public class Login {
    public static void main(String[] args) throws InterruptedException {
        // Automatically manage the ChromeDriver binary
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
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

            //Define login URL and Xpath
            String loginUrl = "http://127.0.0.1";
            String usernamexpath = "//*[@id=\"email\"]";
            String password = "//*[@id=\"password\"]";
            String submitbutton = "//button[@type=\"submit\"]";

            //Test credentials
            String[][] credentials = {
                    {"test@example.com", "Test"},
                    {"admin@example.com", "Test"},
                    {"Ytt@example.com", "secret"},
                    {"admin@example.com", "secret"} //correct credentials

            };

            //open login
            driver.get(loginUrl);

            //Loop through each set of credentials and attempt login
            for (int i = 0; i < credentials.length; i++) {
                driver.findElement(By.xpath(usernamexpath)).clear();
                driver.findElement(By.xpath(usernamexpath)).sendKeys(credentials[i][0]);
                driver.findElement(By.xpath(password)).clear();
                driver.findElement(By.xpath(password)).sendKeys(credentials[i][1]);

                //click login button using xpath
                driver.findElement(By.xpath(submitbutton)).click();

                //Page response
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //check login outcome
                if (i < credentials.length - 1) {
                    if (driver.getPageSource().contains("error")) {
                        System.out.println("Login with incorrect credentials:" + credentials[i][0] + "/" + credentials[i][1]);
                    } else {
                        System.out.println("Unexpected result:" + credentials[i][0] + "/" + credentials[i][1]);
                    }
                } else {
                    if (driver.getPageSource().contains("success")) {
                        System.out.println("Login successfully");
                    } else {
                        System.out.println("Login fail");
                    }

                }

                if (i < credentials.length - 1) {
                    driver.navigate().refresh();
                }


            }


        }

//                driver.findElement(By.id("email")).sendKeys("admin@example.com");
//                driver.findElement(By.id("password")).sendKeys("secret");
//
//                Thread.sleep(2000);
//
//
//                driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//                Thread.sleep(2000);

        //driver.findElement(By.cssSelector("input[type='submit']"));


        // Close the browser
        //driver.quit(); // Ensures the browser is closed properly
    }
}





