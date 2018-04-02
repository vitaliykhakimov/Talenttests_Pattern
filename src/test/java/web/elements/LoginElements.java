package web.elements;

import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginElements {
    public static String URL = "http://testing.cld.iba.by";
    public static By USERNAME = By.id("_58_login");
    public static By PASSWORD = By.id("_58_password");
    public static By LOGIN_BUTTON = By.xpath("//button");
    public static By REQUIRED = By.xpath("//div[@class = 'form-validator-stack help-inline']//div[@class = 'required']");
    public static By ALERT = By.xpath("//div[@class = 'alert alert-error']");
}
