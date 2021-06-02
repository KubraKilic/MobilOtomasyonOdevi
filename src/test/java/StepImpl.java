import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class StepImpl extends MobileThyImpl {

    @Step("allow a tıkla")
    public void clickAllow() throws InterruptedException {
        MobileElement allowElement = driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        allowElement.click();
    }

    @Step("no thanks a tıkla")
    public void noThanksClick() throws InterruptedException {
        MobileElement noThanksElement = driver.findElementById("android:id/button2");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        noThanksElement.click();
    }

    @Step("accept cookies e tıkla")
    public void acceptCookies() throws InterruptedException {
        MobileElement acceptCookiesElement = driver.findElementById("com.turkishairlines.mobile:id/frPrivacy_btnAccept");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        acceptCookiesElement.click();
    }

    @Step("book a flight a tıkla")
    public void bookFlightClick() throws InterruptedException {
        MobileElement bookFlightelement = driver.findElementById("com.turkishairlines.mobile:id/acMain_btnBooking");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        bookFlightelement.click();
    }

    @Step("one way a tıkla")
    public void oneWayClick() throws InterruptedException {
        MobileElement oneWayElement = driver.findElementById("com.turkishairlines.mobile:id/frDashboard_tvOneWay");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        oneWayElement.click();
    }

    @Step("from SJC ye tıkla")
    public void fromFly() throws InterruptedException {
        MobileElement fromFlyElement = driver.findElementById("com.turkishairlines.mobile:id/frDashboard_tvFromCode");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        fromFlyElement.click();
    }

    @Step("search bar da uçak kalkışı için arama yap ve arama sonucuna tıkla")
    public void findKeywordsInSearchBarAndForFlyClick() throws InterruptedException {
        String searchKeyword = "SAW";
        MobileElement searchInputElement = driver.findElementByXPath("//*[@text='Search airport']");
        searchInputElement.sendKeys(searchKeyword);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement sawClickElement = driver.findElementByXPath("//*[@resource-id='com.turkishairlines.mobile:id/frAirportSelection_lvList']/android.widget.RelativeLayout[2]");
        sawClickElement.click();
    }

    @Step("to Select e tıkla")
    public void toSelect() throws InterruptedException {
        MobileElement destinationElement = driver.findElementById("com.turkishairlines.mobile:id/frDashboard_llTo");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        destinationElement.click();
    }

    @Step("search bar da gidilecek yer için arama yap ve arama sonucuna tıkla")
    public void findKeywordsInSearchBarAndClickForDestination() throws InterruptedException {
        String searchKeyword = "ESB";
        MobileElement searchInputElement = driver.findElementByXPath("//*[@text='Search airport']");
        searchInputElement.sendKeys(searchKeyword);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement esbClickElement = driver.findElementByXPath("//*[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]");
        esbClickElement.click();
    }

    @Step("Departure Date alanına tıkla")
    public void departureDateClick() throws InterruptedException {
        MobileElement departureDateElement = driver.findElementById("com.turkishairlines.mobile:id/frDashboard_rlDeparture");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        departureDateElement.click();
    }


}
