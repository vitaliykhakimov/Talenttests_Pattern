package test.candidates;

import driver.WebDriverSingleton;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web.elements.candidates.CandidatesElements;
import web.page.LoginPage;
import web.page.candidates.CandidatesPage;

public class SearchTests {
    WebDriver driver = WebDriverSingleton.getInstance();
    private LoginPage lp = new LoginPage();
    private CandidatesPage cp = new CandidatesPage();

    @Step("Логинимся в систему")
    private void login(){
        lp.enterLoginPage();
        lp.typeUsername("kabanov@tc.by");
        lp.typePassword("welcome");
        lp.clickLoginButton();
    }

    @Test
    @DisplayName("Поиск существующего кандидата")
    @Description("Производим поиск существующего кандидата")
    @Feature("Кандидаты")
    @Story("Сценарий - Поиск выполнен")
    @Severity(SeverityLevel.NORMAL)
    public void searchingPresentCandidate() {
        login();
        cp.goToCandidatesPage();
        cp.searchCandidate("Морозова Екатерина Алексеевна");
        Assert.assertTrue(CandidatesElements.FOUNDED_CANDIDATE.getWebElement().getText().equals("Морозова Екатерина Алексеевна"));
    }

    @Test
    @DisplayName("Переход на страницу кандидата")
    @Description("Производим переход на страницу найденного кандидата")
    @Feature("Кандидаты")
    @Story("Сценарий - Переход на страницу найденного кандидата выполнен")
    @Severity(SeverityLevel.NORMAL)
    public void goToPresentCandidatePage() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.searchCandidate("Морозова Екатерина Алексеевна");
        cp.clickOnFoundedCandidate();
        Assert.assertTrue(driver.getTitle().equals("Морозова Екатерина Алексеевна" +
                " - Конструктор Талантов"));
    }

    @Test
    @DisplayName("Поиск несуществующего кандидата")
    @Description("Производим поиск несуществующего кандидата")
    @Feature("Кандидаты")
    @Story("Сценарий - Поиск выполнен")
    @Severity(SeverityLevel.NORMAL)
    public void searchingMissingCandidate() {
        login();
        cp.goToCandidatesPage();
        cp.searchCandidate("Рaгова Светлана Михайловна");
        Assert.assertTrue(CandidatesElements.CANDIDATE_NOT_FOUND_MESSAGE.getWebElement().getText().equals("Список кандидатов пуст"));
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
