package eb.core;

public class Browser {

    private static String browserName;

    public Browser() {
        this.browserName = null;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public static String getBrowserName() {
        return browserName;
    }


}
