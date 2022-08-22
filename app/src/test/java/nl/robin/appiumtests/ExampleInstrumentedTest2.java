package nl.robin.appiumtests;

import static org.junit.Assert.assertEquals;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleInstrumentedTest2 {

    static AndroidDriver driver;

    /**
     * initialization.
     */
    @BeforeClass
    static void beforeClass() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        capabilities.setCapability(
                AndroidMobileCapabilityType.APP_PACKAGE,
                "com.vodqareactnative"
        );
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700000);
        capabilities.setCapability("clearSystemFiles", true);
        capabilities.setCapability(MobileCapabilityType.APP, "/opt/VodQA.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * finishing.
     */
    @AfterClass
    static void afterClass() {
        driver.quit();
    }

    @Test
    void useAppContext() {
        // Context of the app under test.
        assertEquals("A", "B");
    }

}