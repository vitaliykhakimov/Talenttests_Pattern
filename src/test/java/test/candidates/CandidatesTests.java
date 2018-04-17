package test.candidates;

import driver.WebDriverSingleton;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import util.Helper;
import web.elements.candidates.CandidatesElements;
import web.page.login.LoginPage;
import web.page.menu.MenuUsage;
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
    private void login(String name){
        lp.enterLoginPage();
        lp.typeUsername(name);
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
        login("kabanov@tc.by");
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
        login("kabanov@tc.by");
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
        login("kabanov@tc.by");
        cp.goToCandidatesPage();
        Assert.assertTrue(CandidatesElements.PAGINATION.isElementPresent());
    }

    /*@Test
    @DisplayName("Приглашаем на интервью")
    @Description("Приглашаем кандидата на интервью, помечаем, что интервью пройденно и приглашаем кандидата на работу")
    @Feature("Кандидаты")
    @Story("Сценарий - Меню навигации присутствует")
    @Severity(SeverityLevel.NORMAL)
    public void appointToInterview() {
        login("kabanov@tc.by");
        cp.goToCandidatesPage();
        cp.searchCandidate("Иванов Иван Иванович");
        cp.clickOnFoundedCandidate();
        cp.inviteForTheInterview();

        Helper.waitForTime(2);
        cp.goToCandidatesPage();
        cp.searchCandidate("Иванов Иван Иванович");
        cp.clickOnFoundedCandidate();
        cp.passedTheInterview();
        cp.offeredJob();

        Helper.waitForTime(2);
        Assert.assertTrue(CandidatesElements.OFFERED_JOB_STATUS.isElementPresent());
    }*/

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
