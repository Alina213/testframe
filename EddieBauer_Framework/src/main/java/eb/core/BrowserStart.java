package eb.core;

public class BrowserStart {

    static EnvironmentConfig configProvider = EnvironmentConfigProvider.provide();
    private static String hostName = configProvider.getHostName();

    public static void openMainPage() throws Exception {
       BrowserStart.maximize();
        Selenium.get(hostName);
    }

    public static void openDynAdminPage() {
        BrowserStart.maximize();
        try {
            Selenium.get(configProvider.getDynAdminProductCatalog());
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    public static void maximize() {
        Selenium.getWebDriver().manage().window().maximize();
    }
}
