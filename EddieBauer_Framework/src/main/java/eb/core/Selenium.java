package eb.core;



import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;

public class Selenium {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        Selenium.webDriver = webDriver;
    }

    public static void start() throws Exception {
        Selenium.setWebDriver(DriverFactory.createInstance());
    }

    public static void stop(){
        Selenium.getWebDriver().close();

    }

    public static void get(String url) throws Exception {
        getWebDriver().get(url);
    }


}
