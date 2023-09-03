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
        // Enter mobile number
        // Verify OTP
        // Complete sign up process

        sleep(50000); // Used to let the app loaded in the device, as the device takes long to load the app
        randomTap(driver); // Tap to remove auto suggestion
        MobileElement createAccountButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Create new account\"]"));
        createAccountButton.click();
        System.out.println("Create button is clicked....");

/*        //sleep(10000);
        MobileElement text = driver.findElementByXPath("//android.view.View[@content-desc=\"Join Facebook\"]");
        Assert.assertTrue(text.isDisplayed(), "Text is not found");*/

        MobileElement getStartedButton = driver.findElementByXPath("//android.view.View[@content-desc=\"Get started\"]");
        getStartedButton.click();
        System.out.println("Started account creation...");

        MobileElement cancelGmailLoginPopUp = driver.findElementById("com.google.android.gms:id/cancel");
        cancelGmailLoginPopUp.click();
        System.out.println("Gmail login cancelled...");

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

        // Perform an upscroll to select a random birthday
        //upScroll(driver);
        System.out.println("Selecting Birth Year....");
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

        // Selecting Gender
        MobileElement selectGender = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Male\"]");
        selectGender.click();
        System.out.println("Gender is selected....");

        MobileElement genderNextButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Next\"]");
        genderNextButton.click();

        // Entering Mobile Number
        randomTap(driver);

        sleep(5000);
        MobileElement contactPermissionButton = driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
        contactPermissionButton.click();
        System.out.println("Allowed contact permission.");

        System.out.println("Entering mobile number...");
        MobileElement mobileNumber = driver.findElementByClassName("android.widget.EditText");
        mobileNumber.sendKeys("+8801631103051");
        System.out.println("Mobile number is entered.");

        MobileElement mobNextButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Next\"]");
        mobNextButton.click();


        // Creating password
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

        System.out.println("Signed up successfully!");






    }

    public static void randomTap(AppiumDriver<MobileElement> driver) {

        int X = 481;
        int Y = 1545;

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(X, Y)).perform();

    }

    @AfterClass
    public void teardown() {

        driver.quit();

    }


}
