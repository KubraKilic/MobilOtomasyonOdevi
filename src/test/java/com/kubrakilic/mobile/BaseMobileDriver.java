package com.kubrakilic.mobile;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseMobileDriver {

    protected static AppiumDriver<MobileElement> driver;

    @BeforeScenario
    public void beforeScenario() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 27");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
        capabilities.setCapability("appPackage", "com.turkishairlines.mobile");
        capabilities.setCapability("appActivity", "com.turkishairlines.mobile.ui.main.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url, capabilities);
        Assert.assertNotNull("Driver null..", driver);

    }

    @AfterScenario
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
