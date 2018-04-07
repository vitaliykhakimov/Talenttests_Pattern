package test.candidates;

import driver.WebDriverSingleton;
import element.GenericElement;
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


    private void login(){
        lp.enterLoginPage();
        lp.typeUsername("kabanov@tc.by");
        lp.typePassword("welcome");
        lp.clickLoginButton();
    }

    //переход на главную страницу кандидатов
    @Test
    public void goToCantidatesMainPage() {
        login();
        mu.goToCandidatesPage();
        Assert.assertTrue(driver.getTitle().equals("Кандидаты - Конструктор Талантов"));
    }

    //нажатие кнопи создания кандидата
    @Test
    public void clickCreateCandidateButton() {
        login();
        cp.goToCandidatesPage();
        cp.clickCreateCandidateButton();
        Assert.assertTrue(driver.getTitle().equals("Создание резюме - Конструктор Талантов"));
    }

    //тест на проверка прогрузки навигационного меню
    @Test
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
