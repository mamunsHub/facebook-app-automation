package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class FacebookTests {

    private AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void setup(){

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6a");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\mamun\\IdeaProjects\\facebook-app-automation\\src\\test\\resources\\apps/Facebook.apk");

        // Capabilities for handling permissions and pop-ups
        caps.setCapability("autoAcceptAlerts", true);
        caps.setCapability("autoDismissAlerts", true);
        caps.setCapability("autoGrantPermissions", true);

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
        // Enter mobile number
        // Fill up all the fields
        // Complete sign up process

        sleep(50000); // Used to let the app loaded in the device, as the device takes long to load the app
        MobileElement createAccountButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Create new account\"]"));
        createAccountButton.click();
        System.out.println("Create button is clicked....");
        //sleep(5000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

/*
        MobileElement text = driver.findElementByXPath("//android.view.View[@content-desc=\"Join Facebook\"]");
        Assert.assertTrue(text.isDisplayed(), "Text is not found");*/

        MobileElement getStartedButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Get started\"]");
        getStartedButton.click();
        System.out.println("Started account creation...");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement firstName = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");
        firstName.sendKeys("Jack");
        System.out.println("First name is given..");
        //sleep(5000);

        MobileElement lastName = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");
        lastName.sendKeys("Ryans");
        System.out.println("Last name is given..");
        //sleep(5000);

        MobileElement nextButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Next\"]");
        nextButton.click();
        System.out.println("Navigated to the next page.");
        //sleep(1000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Perform an upscroll to select a random birthday
        System.out.println("Selecting Birth Year....");
        //sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement selectYear = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.Button");
        int count = 0;
        while (count < 18) {

            selectYear.click();

            count++;
        }
        System.out.println("Birthdate has been selected.");

        // Set date and Navigate to next page
        MobileElement setButton = driver.findElementById("android:id/button1");
        setButton.click();

        MobileElement birthdayNextButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Next\"]");
        birthdayNextButton.click();
        //sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Selecting Gender
        MobileElement selectGender = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Male\"]");
        selectGender.click();
        System.out.println("Gender is selected....");

        MobileElement genderNextButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Next\"]");
        genderNextButton.click();


        System.out.println("Entering mobile number...");
        MobileElement mobileNumber = driver.findElementByClassName("android.widget.EditText");
        mobileNumber.clear();
        mobileNumber.sendKeys("+8801631103051");
        System.out.println("Mobile number is entered.");

        MobileElement mobNextButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Next\"]");
        mobNextButton.click();


        // Creating password
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement password = driver.findElementByClassName("android.widget.EditText");
        password.sendKeys("Test@Daraz2023");
        System.out.println("Password is entered...");

        MobileElement passNextButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Next\"]");
        passNextButton.click();

        MobileElement loginInfoButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Not now\"]");
        loginInfoButton.click();
        System.out.println("Declined saving login info.");

        MobileElement agreeButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"I agree\"]");
        agreeButton.click();
        System.out.println("Agreed terms and conditions");
        sleep(30000);


        System.out.println("Signed up successfully!");


    }

    @AfterClass
    public void teardown() {

        driver.quit();

    }


}
