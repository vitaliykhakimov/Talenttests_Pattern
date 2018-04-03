package test.login;

import driver.WebDriverSingleton;
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
    public void correctlyLogin(){
        lp.enterLoginPage();
        lp.typeUsername("kabanov@tc.by");
        lp.typePassword("welcome");
        lp.clickLoginButton();
        Assert.assertTrue(driver.getTitle().equals("Главная - Конструктор Талантов"));
    }

    @Test
    public void emptyPasswordLogin(){
        lp.enterLoginPage();
        lp.typeUsername("kabanov@tc.by");
        lp.clickLoginButton();
        Assert.assertTrue(driver.findElement(le.REQUIRED).getText().equals("Это обязательное поле."));
    }

    @Test
    public void emptyUsernameLogin(){
        lp.enterLoginPage();
        lp.typePassword("welcome");
        lp.clickLoginButton();
        Assert.assertTrue(driver.findElement(le.REQUIRED).getText().equals("Это обязательное поле."));
    }

    @Test
    public void emptyUsernameAndPasswordLogin(){
        lp.enterLoginPage();
        lp.clickLoginButton();
        List<WebElement> alerts = driver.findElements(le.REQUIRED);
        Assert.assertTrue(alerts.get(0).getText().equals("Это обязательное поле."));
        Assert.assertTrue(alerts.get(1).getText().equals("Это обязательное поле."));
    }

    @Test
    public void wrongUsernameLogin(){
        lp.enterLoginPage();
        lp.typeUsername("kaban@tc.by");
        lp.typePassword("we");
        lp.clickLoginButton();
        List<WebElement> alerts = driver.findElements(le.ALERT);
        Assert.assertTrue(alerts.get(0).getText().equals("Ваш запрос завершился с ошибкой."));
        Assert.assertTrue(alerts.get(1).getText().equals("Аутентификация не пройдена. Пожалуйста, попробуйте снова."));
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
