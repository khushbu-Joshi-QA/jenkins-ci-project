package com.assignment.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
public void setup() throws MalformedURLException {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--headless=new");

    driver = new RemoteWebDriver(
            new URL("http://selenium:4444/wd/hub"),
            options
    );

    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/login");
}


    @Test
    public void validLoginTest() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button")).click();

        WebElement success = driver.findElement(By.cssSelector(".flash.success"));
        Assert.assertTrue(success.isDisplayed());
    }

    @Test
    public void invalidLoginTest() {
        driver.findElement(By.id("username")).sendKeys("wrong");
        driver.findElement(By.id("password")).sendKeys("wrong");
        driver.findElement(By.cssSelector("button")).click();

        WebElement error = driver.findElement(By.cssSelector(".flash.error"));
        Assert.assertTrue(error.isDisplayed());
    }

    @Test
    public void emptyFieldsTest() {
        driver.findElement(By.cssSelector("button")).click();
        WebElement error = driver.findElement(By.cssSelector(".flash.error"));
        Assert.assertTrue(error.isDisplayed());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
