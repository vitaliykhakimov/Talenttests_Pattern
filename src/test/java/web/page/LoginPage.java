package web.page;

import driver.WebDriverSingleton;
import element.GenericElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.elements.LoginElements;

public class LoginPage {
    private WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Переход на страницу логина")
    public void enterLoginPage() {
        driver.get(LoginElements.URL);
    }

    @Step("Ввод имени")
    public void typeUsername(String name) {
        LoginElements.USERNAME.getWebElement().clear();
        LoginElements.USERNAME.getWebElement().sendKeys(name);
    }

    @Step("Ввод пароля")
    public void typePassword(String password) {
        LoginElements.PASSWORD.getWebElement().clear();
        LoginElements.PASSWORD.getWebElement().sendKeys(password);
    }

    @Step("Кликаем кнопку логина")
    public void clickLoginButton() {
        LoginElements.LOGIN_BUTTON.getWebElement().click();
    }
}
