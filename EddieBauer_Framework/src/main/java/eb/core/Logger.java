package eb.core;


import org.slf4j.LoggerFactory;
import org.testng.ITestResult;

import java.util.ArrayList;

public class Logger {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(Logger.class);
    private static String currentStepLocal;

    public static String getCurrentStep() {
        return currentStepLocal;
    }

    public static void setCurrentStep(String currentStepLocal) {
        Logger.currentStepLocal = currentStepLocal;
    }
    public static void info(String message) {
        log.info(message);
    }

    public static void warning(String message) {
        log.warn(message);
    }

    public static void stepInfo(String stepName) {
        if (getCurrentStep() != null && getCurrentStep() != "") {
            info("STEP PASSED: " + getCurrentStep());
         //   logReportToFile(Config.getCurrentClassName(), getCurrentStep().toString().trim(), 1);
        }
        setCurrentStep(stepName);
    }
    public static void logReportToFile(String scriptName, String stepName, int intStatus) {
        String stepStatus;
        //   String currentThread = Thread.currentThread().getName();
        switch (intStatus) {
            case 0:
                stepStatus = "STEP FAILED:";
                break;
            case 1:
                stepStatus = "STEP PASSED:";
                break;
            case 2:
                stepStatus = "STEP WARNING:";
                break;
            case 3:
                stepStatus = "STEP MAPPED:";
                break;
            default:
                stepStatus = "Undefined";
        }
    }

    public static void stepFailed(ITestResult result, String screenShotsPlainString, String screenShotsHtmlString) {
        String correctedMessage = result.getThrowable().getMessage();

        if (correctedMessage == null) {
            correctedMessage = "Message is undefined";
        }
        String stepError = getCurrentStep().toString().trim() + "; failure message: " + correctedMessage;
        info("STEP FAILED: " + stepError + "; " + screenShotsHtmlString);
       // logReportToFile(Config.getCurrentClassName(), stepError + screenShotsPlainString, 0);
      //  reset();
    }

    public static void stepWarned(String message) {
        ArrayList<String> screenshots = Selenium.captureScreenshot();
        String stepWarned = getCurrentStep().toString().trim() + "; warning message: " + message;
        warning("STEP WARNED: " + stepWarned + "; " + screenshots.get(1));
       // logReportToFile(Config.getCurrentClassName(), stepWarned + screenshots.get(0), 2);
    }


}
