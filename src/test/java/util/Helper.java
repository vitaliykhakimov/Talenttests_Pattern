package util;

import driver.WebDriverSingleton;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Helper {
    public static void waitForTime(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForTimeInMilliseconds(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeBrowser() throws IOException {
        WebDriverSingleton.getInstance().close();
        WebDriverSingleton.destroyInstance();
    }

    public static void setAttributeValue(String webElementId, String attr, String value){
        JavascriptExecutor js = (JavascriptExecutor) WebDriverSingleton.getInstance();
        js.executeScript("document.getElementById('" + webElementId + "').setAttribute('" + attr + "', '" + value + "')");
    }
}
