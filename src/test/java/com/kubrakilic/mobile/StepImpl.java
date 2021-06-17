package com.kubrakilic.mobile;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.Assert;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class StepImpl extends BaseMobileDriver {

    @Step("Wait <second> seconds")
    public void waitGivenSeconds(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    @Step("click allow")
    public void clickAllow() {
        MobileElement allowElement = driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
        allowElement.click();
    }

    @Step("click no thanks")
    public void clickNoThanks() {
        MobileElement noThanksElement = driver.findElementById("android:id/button2");
        noThanksElement.click();
    }

    @Step("click on accept cookies")
    public void acceptCookies() {
        MobileElement acceptCookiesElement = driver.findElementById("com.turkishairlines.mobile:id/frPrivacy_btnAccept");
        acceptCookiesElement.click();
    }

    @Step("click on book a flight")
    public void clickBookFlight() {
        MobileElement bookFlightElement = driver.findElementById("com.turkishairlines.mobile:id/acMain_btnBooking");
        Assert.assertTrue("book a flight button is not displayed!", bookFlightElement.isDisplayed());
        bookFlightElement.click();
    }

    @Step("click one way")
    public void clickOneWay() {
        MobileElement oneWayElement = driver.findElementById("com.turkishairlines.mobile:id/frDashboard_tvOneWay");
        Assert.assertEquals(oneWayElement.getText(),"ONE WAY");
        oneWayElement.click();
    }

    @Step("click from SJC")
    public void clickFromFly() {
        MobileElement fromFlyElement = driver.findElementById("com.turkishairlines.mobile:id/frDashboard_llFrom");
        Assert.assertTrue("From SJC area is not displayed!", fromFlyElement.isDisplayed());
        fromFlyElement.click();
    }

    @Step("search for flight departure in the search bar and click on the search result")
    public void findKeywordsInSearchBarAndClickkForFly() {
        String searchKeyword = "SAW";
        MobileElement searchInputElement = driver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        Assert.assertTrue("Search airport bar is not displayed!", searchInputElement.isDisplayed());
        searchInputElement.sendKeys(searchKeyword);

        MobileElement sawClickElement = driver.findElementByXPath("//*[@text='SAW - Sabiha Gokcen Airport']");
        sawClickElement.click();
    }

    @Step("click to Select")
    public void clickToSelect() {
        MobileElement destinationElement = driver.findElementById("com.turkishairlines.mobile:id/frDashboard_llTo");
        Assert.assertTrue("To Select area is not displayed!", destinationElement.isDisplayed());
        destinationElement.click();
    }

    @Step("search for the destination in the search bar and click on the search result")
    public void findKeywordsInSearchBarAndClickForDestination() {
        String searchKeyword = "ESB";
        MobileElement searchInputElement = driver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        Assert.assertTrue("Search airport bar is not displayed!", searchInputElement.isDisplayed());
        searchInputElement.sendKeys(searchKeyword);

        MobileElement esbClickElement = driver.findElementByXPath("//*[@text='ESB - Ankara Esenboga Airport']");
        esbClickElement.click();
    }

    @Step("click on the departure Date field")
    public void clickDepartureDate() {
        MobileElement departureDateElement = driver.findElementById("com.turkishairlines.mobile:id/frDashboard_rlDeparture");
        if (departureDateElement.isDisplayed()) {
            departureDateElement.click();
        }
    }

    @Step("select date information 2 days after today's date")
    public void addTwoDaysToCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Current date " + calendar.getTime());
        System.out.println(dayOfMonth);

        calendar.add(Calendar.DAY_OF_MONTH, 2);
        int targetDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Current date plus two days: " + calendar.getTime());
        System.out.println(targetDayOfMonth);

        boolean dateFound = false;
        String dayValue = null;

        for (int i = 2; i < 7; i++) {
            for (int j = 1; j < 8; j++) {
                MobileElement day = driver.findElementByXPath("//*[@resource-id='com.turkishairlines.mobile:id/frDashboard_calendarPickerView']/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup[" + i + "]/android.widget.FrameLayout[" + j + "]/android.widget.TextView");
                dayValue = day.getText();
                if (Integer.parseInt(dayValue) == targetDayOfMonth) {
                    dateFound = true;
                    day.click();
                    return;
                }
            }
        }
    }

    @Step("click the done button after the date selection")
    public void clickDoneButton() {
        MobileElement doneButtonElement = driver.findElementById("com.turkishairlines.mobile:id/frDashboard_btnDone");
        Assert.assertTrue("Done button is not displayed!", doneButtonElement.isDisplayed());
        doneButtonElement.click();
    }

    @Step("increase adult knowledge by 2")
    public void chooseTwoPlacesForAdult() {
        MobileElement incrementForAdultElement = driver.findElementByXPath("//*[@resource-id='com.turkishairlines.mobile:id/calendar_grid']/android.view.ViewGroup[2]/android.widget.FrameLayout[7]");
        MobileElement numberOfPassengers = driver.findElementById("com.turkishairlines.mobile:id/frDashboard_tvPassengerCount");

        incrementForAdultElement.click();
        Assert.assertEquals(numberOfPassengers.getText(),"2");
    }

    @Step("click on search flight button")
    public void clickSearchFlightButton() {
        MobileElement searchFlightButtonElement = driver.findElementById("com.turkishairlines.mobile:id/frDashboard_btnSearch");
        Assert.assertTrue("Search Flight button is not displayed!", searchFlightButtonElement.isDisplayed());
        searchFlightButtonElement.click();
    }

    @Step("check flights are listed")
    public void checkIfFlightPageContentExist() {
        MobileElement flightPageContentElement = driver.findElementById("com.turkishairlines.mobile:id/frFlightSearch_rlPageContent");
        Assert.assertTrue(flightPageContentElement.isDisplayed());
    }

    @Step("choose any time for flight")
    public void chooseTimeTableForFlight() {
        MobileElement timeTableElement = driver.findElementByXPath("//*[@resource-id='com.turkishairlines.mobile:id/frFlightSearch_rlPageContent']/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]");
        timeTableElement.click();
    }

    @Step("choose economy flight")
    public void clickEcoFly() {
        MobileElement ecoFlyElement = driver.findElementByXPath("//*[@resource-id='com.turkishairlines.mobile:id/frFlightSearch_rlPageContent']/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        Assert.assertTrue("Eco Fly element is not displayed!", ecoFlyElement.isDisplayed());
        ecoFlyElement.click();
    }

    @Step("click the continue button")
    public void clickContinueBotton() {
        MobileElement continueButtonElement = driver.findElementById("com.turkishairlines.mobile:id/frFlightSearch_btnContinue");
        Assert.assertEquals(continueButtonElement.getText(),"Continue");
        continueButtonElement.click();
    }
}
