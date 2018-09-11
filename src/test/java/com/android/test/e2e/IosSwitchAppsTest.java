package com.android.test.e2e;

import io.appium.java_client.ios.IOSDriver;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class IosSwitchAppsTest extends BaseTest {


    private String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.3.0/TheApp-v1.3.0.app.zip";
    private String PHOTOS_BUNDLE_ID = "com.apple.mobileslideshow";
    private String BUNDLE_ID = "io.cloudgrey.the-app";

    @Test(groups = {"Regression"})
    public void testMultiApps() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.4");
        capabilities.setCapability("deviceName", "iPhone X");
        capabilities.setCapability("app", APP);

        IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

        try {
            HashMap<String, Object> args = new HashMap<>();
            args.put("bundleId", PHOTOS_BUNDLE_ID);
            driver.executeScript("mobile: launchApp", args);

            // Here is where we would navigate the Photos UI to get the number of Camera Roll photos
            Thread.sleep(1000);

            // Now reactivate our AUT
            args.put("bundleId", BUNDLE_ID);
            driver.executeScript("mobile: activateApp", args);

            // Here is where we would cause the new photo to be taken, edited, and saved
            Thread.sleep(1000);

            // Now reactivate the Photos app
            args.put("bundleId", PHOTOS_BUNDLE_ID);
            driver.executeScript("mobile: activateApp", args);

            // Here is where we would get the new number of Camera Roll photos, and assert that it
            // has increased by the appropriate number
            Thread.sleep(1000);
        } finally {
            driver.quit();
        }
    }
}
