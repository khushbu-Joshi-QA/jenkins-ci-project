package tests;
 
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.remote.RemoteWebDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.testng.Assert;
  import org.testng.annotations.Test;
 
 import java.net.URL;

 public class LoginTest {

     @Test
     public void validLoginTest() throws Exception {

         // ⭐ IMPORTANT: Connect to Selenium Grid inside Docker (USE THIS URL)
         ChromeOptions options = new ChromeOptions();
         WebDriver driver = new RemoteWebDriver(
                 new URL("http://selenium:4444"),   // <-- THIS IS THE CORRECT URL
                 options
         );

         // Open website
         driver.get("https://the-internet.herokuapp.com/login");

         // Enter username
         driver.findElement(By.id("username")).sendKeys("tomsmith");

         // Enter password
         driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

         // Click Login button
         driver.findElement(By.cssSelector("button")).click();

         // Validate success message
         String message = driver.findElement(By.id("flash")).getText();
         Assert.assertTrue(message.contains("You logged into a secure area!"));

         // Close browser
         driver.quit();
     }
 }
