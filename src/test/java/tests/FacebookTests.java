package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;

import static java.lang.Thread.sleep;


public class FacebookTests {

    private AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void setup(){

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 7 Pro");
        caps.setCapability(MobileCapabilityType.UDID, "8bcc435");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        // Capabilities for Android Apps settings
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.facebook.katana");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.facebook.katana.platform.FacebookAuthenticationActivity");


        // Create an instance of the AppiumDriver
        URI appiumServerURL = URI.create("http://localhost:4723/wd/hub");

        try {
            driver = new AndroidDriver<MobileElement>(appiumServerURL.toURL(), caps);
            System.out.println("Application Started.....");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



    }

    @Test
    public void facebookSignupTest() throws InterruptedException {
        // Test Steps:
        // Go to Create a new account page
        // Fill up all the fields
        // Complete sign up process

        sleep(50000); // Used to let the app loaded in the device, as the device takes long to load the app
        MobileElement createAccountButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Create new account\"]"));
        createAccountButton.click();
        System.out.println("Create button is clicked....");

        //sleep(10000);
        MobileElement text = driver.findElementByXPath("//android.view.View[@content-desc=\"Join Facebook\"]");
        Assert.assertTrue(text.isDisplayed(), "Text is not found");

        MobileElement getStartedButton = driver.findElementByXPath("//android.view.View[@content-desc=\"Get started\"]");
        getStartedButton.click();

        MobileElement cancelGmailLoginPopUp = driver.findElementById("com.google.android.gms:id/cancel");
        cancelGmailLoginPopUp.click();

        MobileElement firstName = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");
        firstName.sendKeys("Jack");
        sleep(5000);

        MobileElement lastName = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");
        lastName.sendKeys("Ryans");
        sleep(5000);

        MobileElement nextButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Next\"]");
        nextButton.click();


    }

    @AfterClass
    public void teardown() {

        driver.quit();

    }


}
