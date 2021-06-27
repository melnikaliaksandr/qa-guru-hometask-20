package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AndroidConfig;
import helpers.Browserstack;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        return getAndroidDriver();
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", AndroidConfig.get.device());
        capabilities.setCapability("os_version", AndroidConfig.get.operatingSystem());
        capabilities.setCapability("app", AndroidConfig.get.application());
        capabilities.setCapability("project", "First Java Project");
        capabilities.setCapability("build", "Java Android");
        capabilities.setCapability("name", "first_test");
        capabilities.setCapability("autoGrantPermissions", "true");

        return new AndroidDriver(Browserstack.browserstackUrl(), capabilities);
    }

}
