package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

        @Nonnull
        @Override
        public WebDriver createDriver(@Nonnull Capabilities capabilities) {
            MutableCapabilities caps = new MutableCapabilities();

            caps.setCapability("browserstack.user", "bsuser_nSLF3V");
            caps.setCapability("browserstack.key", "PPXoqnxzaV3z94pLSc6C");

            caps.setCapability("device", "Samsung Galaxy S22 Ultra");
            caps.setCapability("os_version", "12.0");

            caps.setCapability("app", "bs://sample.app");

            caps.setCapability("project", "BrowserStack Sample");
            caps.setCapability("build", "browserstack-build-1");
            caps.setCapability("name", "first_test");

            try {
                return new RemoteWebDriver(
                        new URL("https://hub.browserstack.com/wd/hub"), caps);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }


