package test.candidates;

import driver.WebDriverSingleton;
import element.GenericElement;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web.elements.candidates.CandidatesElements;
import web.page.LoginPage;
import web.page.MenuUsage;
import web.page.candidates.CandidateCreatePage;
import web.page.candidates.CandidatesPage;

public class CandidatesTests {
    private WebDriver driver = WebDriverSingleton.getInstance();
    private LoginPage lp = new LoginPage();
    private MenuUsage mu = new MenuUsage();
    private CandidatesPage cp = new CandidatesPage();
    private CandidatesElements ce = new CandidatesElements();
    private CandidateCreatePage ccp = new CandidateCreatePage();

    @Step("Логинимся в систему")
    private void login(){
        lp.enterLoginPage();
        lp.typeUsername("kabanov@tc.by");
        lp.typePassword("welcome");
        lp.clickLoginButton();
    }

    @Test
    @DisplayName("Переход на страницу кандидатов")
    @Description("Переходим на страницу кандидатов с помощью кнопок меню")
    @Feature("Кандидаты")
    @Story("Сценарий - Переход на страницу кандидатов совершён")
    @Severity(SeverityLevel.BLOCKER)
    public void goToCantidatesMainPage() {
        login();
        mu.goToCandidatesPage();
        Assert.assertTrue(driver.getTitle().equals("Кандидаты - Конструктор Талантов"));
    }

    @Test
    @DisplayName("Кнопка создания кандидата")
    @Description("Нажимаем кнопку создания кандидата")
    @Feature("Кандидаты")
    @Story("Сценарий - Кнопка создания кандидата нажимается")
    @Severity(SeverityLevel.BLOCKER)
    public void clickCreateCandidateButton() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        Thread.sleep(2000);
        cp.clickCreateCandidateButton();
        Assert.assertTrue(driver.getTitle().equals("Создание резюме - Конструктор Талантов"));
    }

    @Test
    @DisplayName("Навигационное меню")
    @Description("Проверяем присутствие навигационного меню")
    @Feature("Кандидаты")
    @Story("Сценарий - Меню навигации присутствует")
    @Severity(SeverityLevel.NORMAL)
    public void paginationPresence() {
        login();
        cp.goToCandidatesPage();
        Assert.assertTrue(CandidatesElements.PAGINATION.isElementPresent());
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
