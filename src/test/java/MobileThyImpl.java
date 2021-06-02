import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class MobileThyImpl {

    protected static AndroidDriver<MobileElement> driver;

    @BeforeScenario
    public void beforeScenario()throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Pixel 4 API 27");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("appPackage","com.turkishairlines.mobile");
        capabilities.setCapability("appActivity", "com.turkishairlines.mobile.ui.main.MainActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("fullReset","false");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }

    @AfterScenario
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }

}
