package eb.core;

import eb.core.listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.util.Arrays;
import java.util.Collection;
@Listeners({ TestListener.class })
public abstract class BaseTest {

    private static BaseTest currentTest = null;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { {} });
    }

    public BaseTest() {
        BaseTest.currentTest = this;
    }

    public static BaseTest getCurrentTest() {
        return currentTest;
    }

    public static void setCurrentTest(BaseTest currentTest) {
        BaseTest.currentTest = currentTest;
    }


}
