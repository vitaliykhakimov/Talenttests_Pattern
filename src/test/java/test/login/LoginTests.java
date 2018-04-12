package test.login;

import driver.WebDriverSingleton;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.elements.LoginElements;
import web.page.LoginPage;

import java.util.List;

public class LoginTests {

    private WebDriver driver = WebDriverSingleton.getInstance();
    private LoginPage lp = new LoginPage();
    private LoginElements le = new LoginElements();

    @Test
    @DisplayName("Логин")
    @Description("Производим корректный логин")
    @Feature("Авторизация")
    @Story("Сценарий - Логин выполнен")
    @Severity(SeverityLevel.BLOCKER)
    public void correctlyLogin(){
        lp.enterLoginPage();
        lp.typeUsername("kabanov@tc.by");
        lp.typePassword("welcome");
        lp.clickLoginButton();
        Assert.assertTrue(driver.getTitle().equals("Главная - Конструктор Талантов"));
    }

    @Test
    @DisplayName("Логин с пустым паролем")
    @Description("Производим логин с пустым полем пароля")
    @Feature("Авторизация")
    @Story("Сценарий - Логин не выполнен")
    @Severity(SeverityLevel.BLOCKER)
    public void emptyPasswordLogin(){
        lp.enterLoginPage();
        lp.typeUsername("kabanov@tc.by");
        lp.clickLoginButton();
        Assert.assertTrue(LoginElements.REQUIRED.getWebElement().getText().equals("Это обязательное поле."));
    }

    @Test
    @DisplayName("Логин с пустым именем")
    @Description("Производим логин с пустым полем имени")
    @Feature("Авторизация")
    @Story("Сценарий - Логин не выполнен")
    @Severity(SeverityLevel.BLOCKER)
    public void emptyUsernameLogin(){
        lp.enterLoginPage();
        lp.typePassword("welcome");
        lp.clickLoginButton();
        Assert.assertTrue(LoginElements.REQUIRED.getWebElement().getText().equals("Это обязательное поле."));
    }

    @Test
    @DisplayName("Логин с пустым паролем и именем")
    @Description("Производим логин с пустыми полями")
    @Feature("Авторизация")
    @Story("Сценарий - Логин не выполнен")
    @Severity(SeverityLevel.BLOCKER)
    public void emptyUsernameAndPasswordLogin(){
        lp.enterLoginPage();
        lp.clickLoginButton();
        Assert.assertTrue(LoginElements.REQUIRED.getWebElements().get(0).getText().equals("Это обязательное поле."));
        Assert.assertTrue(LoginElements.REQUIRED.getWebElements().get(1).getText().equals("Это обязательное поле."));
    }

    @Test
    @DisplayName("Логин с неверными именем и паролем")
    @Description("Производим логин с неверными данными")
    @Feature("Авторизация")
    @Story("Сценарий - Логин не выполнен")
    @Severity(SeverityLevel.BLOCKER)
    public void wrongUsernameLogin(){
        lp.enterLoginPage();
        lp.typeUsername("kaban@tc.by");
        lp.typePassword("we");
        lp.clickLoginButton();
        Assert.assertTrue(LoginElements.ALERT.getWebElements().get(0).getText().equals("Ваш запрос завершился с ошибкой."));
        Assert.assertTrue(LoginElements.ALERT.getWebElements().get(1).getText().equals("Аутентификация не пройдена. Пожалуйста, попробуйте снова."));
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
