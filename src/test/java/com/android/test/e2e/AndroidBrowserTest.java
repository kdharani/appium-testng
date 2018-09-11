package com.android.test.e2e;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class AndroidBrowserTest extends BaseTest{
    private AppiumDriver driver;
    private DesiredCapabilities caps = new DesiredCapabilities();
    private String serverUrl = "http://0.0.0.0:4723/wd/hub";

   @BeforeTest
   public void setup() throws MalformedURLException {
       caps.setCapability("platformName", "Android");
       caps.setCapability("deviceName", "Samsung A7");
       caps.setCapability("browserName", "chrome");

       driver = new AndroidDriver(new URL(serverUrl), caps);
       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
   }

   @AfterTest
   public void terdown(){
       driver.quit();
   }


    @Test(groups = {"e2e"})
    public void doGoogleSearch(){

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Appium");
        driver.findElement(By.xpath("//button[@aria-label = 'Google Search']")).click();
        Boolean isPresent = driver.findElementByXPath("//div[contains(text(), 'Appium: Mobile App')]").isDisplayed();
        Assert.assertTrue(isPresent,"Search text is not present");
    }
}
