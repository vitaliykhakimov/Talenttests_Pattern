package test.vacancies;

import driver.WebDriverSingleton;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import util.Helper;
import web.elements.applications.ApprovalElements;
import web.elements.vacancies.VacanciesElements;
import web.page.applications.ApplicationsPage;
import web.page.login.LoginPage;
import web.page.menu.MenuUsage;
import web.page.vacancies.VacancyPage;

public class VacanciesTests {

    WebDriver driver = WebDriverSingleton.getInstance();
    private ApplicationsPage applicationsPage = new ApplicationsPage();
    private LoginPage lp = new LoginPage();
    private MenuUsage mu = new MenuUsage();
    private VacancyPage vacancyPage = new VacancyPage();

    @Step("Логинимся в систему")
    private void login(String name){
        lp.enterLoginPage();
        lp.typeUsername(name);
        lp.typePassword("welcome");
        lp.clickLoginButton();
    }

    /*@Test
    @DisplayName("Создание вакансии")
    @Description("Переходим на страницу заявок, ищем необходимую, создаем на её основе вакансию, открываем её")
    @Feature("Вакансии")
    @Story("Сценарий - Создание и открытие вакансии")
    @Severity(SeverityLevel.BLOCKER)
    public void createVacancy() {
        login("kabanov@tc.by");
        Helper.waitForTime(3);
        mu.goToApplicationsPage();
        applicationsPage.searchApp("Junior Java developer");
        Helper.waitForTime(1);
        vacancyPage.clickCreateVacancyButton();
        vacancyPage.creatingVacancy();
        vacancyPage.openVacancy();
        Helper.waitForTime(2);
        Assert.assertTrue(VacanciesElements.SUCCESS_OPENED.getWebElement().getText().equals("Вакансия была успешно открыта"));
    }

    @Test
    @DisplayName("Создание вакансии")
    @Description("Переходим на страницу вакансий, находим нужную, добавляем кандидата, добавляем вопросы")
    @Feature("Вакансии")
    @Story("Сценарий - Создание и открытие вакансии")
    @Severity(SeverityLevel.BLOCKER)
    public void editVacancyPage() {
        login("kabanov@tc.by");
        Helper.waitForTime(3);
        mu.goToVacanciesPage();
        vacancyPage.searchVacancy("Junior Java developer");
        vacancyPage.addToShortlist("Иванов Иван Иванович");
        vacancyPage.addQuestions("Легко учишься?", "Да", "Обучаемость");
    }*/
}
