package io.github.prasadmudedla.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.time.Duration;

import static io.github.prasadmudedla.server.AppiumServerManager.*;


public class AndroidDriverManager {
    private static final String APP_PATH = String.valueOf(
            Path.of(System.getProperty("user.dir"), "/src/test/resources/app", "webdriverio-app.apk"));
    private static final ThreadLocal<AndroidDriver> DRIVER = new ThreadLocal<>();
    private static final Logger LOG = LogManager.getLogger("DriverManager.class");

    public static void quitSession() {
        if (null != DRIVER.get()) {
            LOG.info("Closing the driver...");
            getDriver().quit();
            DRIVER.remove();
            stopServer();
        }
    }

    public static AndroidDriver getDriver() {
        return AndroidDriverManager.DRIVER.get();
    }

    private static void setDriver(AndroidDriver driver) {
        AndroidDriverManager.DRIVER.set(driver);
    }

    private static UiAutomator2Options uiAutomator2OptionsWdio() {
        UiAutomator2Options uiAutomator2Options;
        uiAutomator2Options = new UiAutomator2Options()
                .setAvd("Pixel_XL_API_33")
                .setAvdLaunchTimeout(Duration.ofSeconds(300))
                .setAvdReadyTimeout(Duration.ofSeconds(100))
                .setDeviceName("Pixel_XL_API_33")
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .setApp(APP_PATH)
                .setAppPackage("com.wdiodemoapp")
                .setAppActivity("com.wdiodemoapp.MainActivity")
                .setNoReset(false);
        return uiAutomator2Options;
    }

    public static void createAndroidDriver() {
        startServer("android");
        setDriver(new AndroidDriver(getService().getUrl(), uiAutomator2OptionsWdio()));
        setupDriverTimeouts();
    }

    private static void setupDriverTimeouts() {
        getDriver().manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
    }


}
