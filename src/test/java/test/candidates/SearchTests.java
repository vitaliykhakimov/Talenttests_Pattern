package test.candidates;

import driver.WebDriverSingleton;
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

    private void login(){
        lp.enterLoginPage();
        lp.typeUsername("kabanov@tc.by");
        lp.typePassword("welcome");
        lp.clickLoginButton();
    }

    //Поиск существующего кандидата
    @Test
    public void searchingPresentCandidate() {
        login();
        cp.goToCandidatesPage();
        cp.searchCandidate("Рогова Светлана Михайловна");
        Assert.assertTrue(CandidatesElements.FOUNDED_CANDIDATE.getWebElement().getText().equals("Рогова Светлана Михайловна"));
    }

    //Переход на страницу найденного кандидата
    @Test
    public void goToPresentCandidatePage() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.searchCandidate("Рогова Светлана Михайловна");
        cp.clickOnFoundedCandidate();
        Assert.assertTrue(driver.getTitle().equals("Рогова Светлана Михайловна - Конструктор Талантов"));
    }

    //поиск отсутствующего кандидата
    @Test
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
