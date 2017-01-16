package eb.core.listeners;


import eb.core.Selenium;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class TestListener extends TestNGListener {
    /*
    private static Hashtable<String, Boolean> testStatus = new Hashtable<>();
    private static boolean isConfigurationFailed;
    private static boolean isConfigurationSkipped;
    private static String currentTestClass;

    public static boolean isConfigurationSkipped() {
        return isConfigurationSkipped;
    }

    public static void setIsConfigurationSkipped(boolean isConfigurationSkipped) {
        TestListener.isConfigurationSkipped = isConfigurationSkipped;
    }

    public static boolean isConfigurationFailed() {
        return isConfigurationFailed;
    }

    public static void setIsConfigurationFailed() {
        TestListener.isConfigurationFailed = isConfigurationFailed;
    }

    public boolean isBeforeAnnotation(ITestResult iTestResult) {
        ITestNGMethod iTestNGMethod = iTestResult.getMethod();
        if (iTestNGMethod.isBeforeClassConfiguration() || iTestNGMethod.isBeforeGroupsConfiguration() || iTestNGMethod.isBeforeMethodConfiguration() || iTestNGMethod.isBeforeSuiteConfiguration() || iTestNGMethod.isBeforeTestConfiguration()) {
            return true;
        }
        return false;
    }

    private boolean hasBeforeMethods(ITestResult iTestResult) {
        return Arrays.asList(iTestResult.getTestClass().getRealClass().getMethods()).stream().filter(method -> method.getAnnotation(BeforeClass.class) != null || method.getAnnotation(BeforeGroups.class) != null || method.getAnnotation(BeforeSuite.class) != null || method.getAnnotation(BeforeMethod.class) != null).findFirst().isPresent();
    }

    private boolean hasAfterMethods(ITestResult iTestResult) {
        return Arrays.asList(iTestResult.getTestClass().getRealClass().getMethods()).stream().filter(method -> method.getAnnotation(AfterClass.class) != null || method.getAnnotation(AfterGroups.class) != null || method.getAnnotation(AfterSuite.class) != null || method.getAnnotation(AfterMethod.class) != null).findFirst().isPresent();
    }

    private ITestNGMethod getTestMethodOfClass(final ITestResult iTestResult) {
        ITestNGMethod[] methods = iTestResult.getTestContext().getAllTestMethods();
        return Arrays.asList(methods).stream().filter(method -> method.getRealClass().equals(iTestResult.getTestClass().getRealClass())).findFirst().get();
    }

    public void setAnnotationHolder(ITestNGMethod iTestNGMethod) {
        String description = iTestNGMethod.getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
        boolean isSkipped = !iTestNGMethod.getConstructorOrMethod().getMethod().getAnnotation(Test.class).enabled();
        setIsConfigurationSkipped(isSkipped);
    }


    public void setupPreconditions(ITestResult iTestResult) {
        ITestNGMethod iTestNGMethod = getTestMethodOfClass(iTestResult);
        setAnnotationHolder(iTestNGMethod);
        TestListener.currentTestClass = iTestResult.getTestClass().getName();
    }

    public void beforeConfiguration(ITestResult iTestResult) {
        if (isBeforeAnnotation(iTestResult)) {
            if (!isConfigurationSkipped) {
                try {
                    Selenium.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onTestStart(ITestResult iTestResult) {
        if (!hasBeforeMethods(iTestResult)) {
            setupPreconditions(iTestResult);
            try {
                Selenium.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void onTestSuccess(ITestResult iTestResult) {
        if (!hasAfterMethods(iTestResult)) {
            closeAllWindows();
        }
    }

    private void closeAllWindows() {
        Selenium.stop();
        Selenium.getWebDriver().quit();
    }

    */
}