package eb.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

   public static String browserProvider = "firefox";
   // static String browserProvider = BrowserStartProvider.provideParameters().getBrowserName();

    public static WebDriver createInstance() throws Exception {
        WebDriver webDriver;
        DesiredCapabilities capabilities;
        if (browserProvider.equals("firefox")) {
            FirefoxProfile profile = createFFProfile();
            capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);
            webDriver = new FirefoxDriver(capabilities);

        } else {
            throw new Exception("Unsupported browser:" + browserProvider);
        }
        return webDriver;
    }

    private static FirefoxProfile createFFProfile() {
        FirefoxProfile profile;
        profile = new FirefoxProfile();
        profile.setPreference("capability.policy.default.HTMLIFrameElement.name", "allAccess");
        profile.setPreference("capability.policy.default.Window.frameElement", "allAccess");
        profile.setPreference("capability.policy.default.HTMLDocument.compatMode", "allAccess");
        profile.setPreference("capability.policy.default.Window.pageXOffset", "allAccess");
        profile.setPreference("capability.policy.default.Window.pageYOffset", "allAccess");
        profile.setPreference("intl.accept_languages", "en");
        profile.setPreference("browser.startup.page", 0);
        profile.setPreference("browser.startup.homepage", "about:blank");
        int timeout = 120000 / 1000;
        timeout = timeout < 30 ? 30 : timeout;
        profile.setPreference("dom.max_script_run_time", timeout);
        profile.setPreference("dom.max_chrome_script_run_time", timeout);
        profile.setPreference("plugin.state.flash", 0);
        return profile;
    }
}
