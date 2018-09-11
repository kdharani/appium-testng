package com.android.test.e2e;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private AppiumDriverLocalService appiumService;


    @BeforeSuite(groups = {"config"})
    public void startAppium(){
        appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
        .withIPAddress("0.0.0.0")
        .usingPort(4723)
        );
        appiumService.start();
    }

    @AfterSuite(groups = {"config"})
    public void stopAppium(){
        if(appiumService.isRunning())
            appiumService.stop();
    }
}
