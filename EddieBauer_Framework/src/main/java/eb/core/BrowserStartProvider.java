package eb.core;

import eb.utils.PropertyUtils;
//TODO
public class BrowserStartProvider {

    public static final String BROWSER_NAME_PROPERTY_KEY = "nbty.brs";
    private static final String BROWSER_BY_DEFAULT = "firefox";

   public static String obtainBrowserName() {
        final String brsName = System.getProperty(BROWSER_NAME_PROPERTY_KEY);
        if (brsName == null || brsName.isEmpty()) {
            return BROWSER_BY_DEFAULT;
        }
        return brsName;
    }

    public static Browser provideParameters() throws Exception {
        Browser browser = new Browser();
        browser.setBrowserName(PropertyUtils.getProperty(getBrowserPath(), obtainBrowserName()));
        return browser;
}

    public static String getBrowserPath() throws Exception {
        return PropertiesProcessor.getConfigurationFolderPath() + "browsers.properties";
    }
}
