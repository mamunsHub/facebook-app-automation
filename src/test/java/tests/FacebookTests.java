package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;


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
            driver = new AndroidDriver<>(appiumServerURL.toURL(), caps);
            System.out.println("Application Started.....");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



    }

    @Test
    public void facebookSignupTest() {
        // Test Steps:
        // Go to Create a new account page
        // Fill up all the fields
        // Complete sign up process

        //String xpath_string = "";
        MobileElement createAccountButton = driver.findElementById("00000000-0000-00a4-ffff-ffff00000053");
        createAccountButton.click();

    }

    @AfterClass
    public void teardown() {

        driver.quit();

    }


}
