package web.page;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.elements.LoginElements;

public class LoginPage {
    private WebDriver driver = WebDriverSingleton.getInstance();

    public void enterLoginPage() {
        driver.get(LoginElements.URL);
    }

    public void typeUsername(String name) {
        WebElement element = driver.findElement(LoginElements.USERNAME);
        element.clear();
        element.sendKeys(name);
    }

    public void typePassword(String password) {
        WebElement element = driver.findElement(LoginElements.PASSWORD);
        element.clear();
        element.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement element = driver.findElement(LoginElements.LOGIN_BUTTON);
        element.click();
    }
}
