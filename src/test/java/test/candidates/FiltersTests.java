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

public class FiltersTests {
    WebDriver driver = WebDriverSingleton.getInstance();
    private final int NOT_IMPORTANT_EXPERIENCE = 0;
    private final int ONE_YEAR_EXPERIENCE = 1;
    private final int THREE_YEAR_EXPERIENCE = 2;
    private final int FIVE_YEAR_EXPERIENCE = 3;

    private final int RELOCATION_AVAILABLE = 0;
    private final int RELOCATION_UNAVAILABLE = 1;

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
    @DisplayName("Фильтр по опыту работы")
    @Description("Производим фильтрацию по опыту работы")
    @Feature("Кандидаты")
    @Story("Сценарий -  Теги фильтров отображаются")
    @Severity(SeverityLevel.MINOR)
    public void filterByExperienceTag() {
        login();
        cp.goToCandidatesPage();
        cp.selectExperience(ONE_YEAR_EXPERIENCE);
        Assert.assertTrue(CandidatesElements.EXPERIENCE_TAG.getWebElement().getText().equals("От 1 года"));
    }

    @Test
    public void filterByCandidateWithCurrentExperience() {
        //хотел протестировать на сортировку по фильтру опыта работы, который бы сравнивал указанный опыт с опытом работы кандидата
        //но из-за отсутствия доступа к БД это не предоставляется возможным
    }

    @Test
    @DisplayName("Фильтр по статусу Новый")
    @Description("Производим фильтрацию по статусу - Новый")
    @Feature("Кандидаты")
    @Story("Сценарий -  Теги фильтров отображаются")
    @Severity(SeverityLevel.MINOR)
    public void filterByStatusTagNew() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.clickStatusNew();
        Assert.assertTrue(CandidatesElements.STATUS_NEW_TAG.getWebElement().getText().equals("Новый"));
    }

    @Test
    @DisplayName("Фильтр по статусу - Рассматривается на вакансию")
    @Description("Производим фильтрацию по статусу - Рассматривается на вакансию")
    @Feature("Кандидаты")
    @Story("Сценарий -  Теги фильтров отображаются")
    @Severity(SeverityLevel.MINOR)
    public void filterByStatusTagApproval() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.clickStatusApproval();
        Assert.assertTrue(CandidatesElements.STATUS_APPROVAL_TAG.getWebElement().getText().equals("Рассматривается на вакансию"));
    }

    @Test
    @DisplayName("Фильтр по статусу - Доступен для рассмотрения")
    @Description("Производим фильтрацию по статусу - Доступен для рассмотрения")
    @Feature("Кандидаты")
    @Story("Сценарий -  Теги фильтров отображаются")
    @Severity(SeverityLevel.MINOR)
    public void filterByStatusTagAvailable() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.clickStatusAvailable();
        Assert.assertTrue(CandidatesElements.STATUS_AVAILABLE_TAG.getWebElement().getText().equals("Доступен для рассмотрения"));
    }

    @Test
    @DisplayName("Фильтр по статусу - Принят на работу")
    @Description("Производим фильтрацию по статусу - Принят на работу")
    @Feature("Кандидаты")
    @Story("Сценарий -  Теги фильтров отображаются")
    @Severity(SeverityLevel.MINOR)
    public void filterByStatusTagHired() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.clickStatusHired();
        Assert.assertTrue(CandidatesElements.STATUS_HIRED_TAG.getWebElement().getText().equals("Принят на работу"));
    }

    @Test
    public void filterByStatusNew() {
        //не предоставляется возможным протестировать правильное отображение данных по данному фильтру из-за отсутствия доступа к бд
    }

    @Test
    public void filterByStatusApproval() {
        //не предоставляется возможным протестировать правильное отображение данных по данному фильтру из-за отсутствия доступа к бд
    }

    @Test
    public void filterByStatusAvailable() {
        //не предоставляется возможным протестировать правильное отображение данных по данному фильтру из-за отсутствия доступа к бд
    }

    @Test
    public void filterByStatusHired() {
        //не предоставляется возможным протестировать правильное отображение данных по данному фильтру из-за отсутствия доступа к бд
    }

    @Test
    @DisplayName("Фильтр по вакансии")
    @Description("Производим фильтрацию по вакансии")
    @Feature("Кандидаты")
    @Story("Сценарий -  Теги фильтров отображаются")
    @Severity(SeverityLevel.MINOR)
    public void filterByVacancyTag() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.selectVacancy();
        Assert.assertTrue(CandidatesElements.VACANCY_FILTER_TAG.getWebElement().getText().equals("Дизайнер"));
    }

    @Test
    @DisplayName("Фильтр по образованию")
    @Description("Производим фильтрацию по образованию")
    @Feature("Кандидаты")
    @Story("Сценарий -  Теги фильтров отображаются")
    @Severity(SeverityLevel.MINOR)
    public void filterByEducationTag() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.selectEducation();
        Assert.assertTrue(CandidatesElements.EDUCATION_FILTER_TAG.getWebElement().getText().equals("Не указано"));
    }

    @Test
    @DisplayName("Фильтр по университету")
    @Description("Производим фильтрацию по университету")
    @Feature("Кандидаты")
    @Story("Сценарий -  Теги фильтров отображаются")
    @Severity(SeverityLevel.MINOR)
    public void filterByUniversityTag() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.selectUniversity();
        Assert.assertTrue(CandidatesElements.UNIVERSITY_FILTER_TAG.getWebElement().getText().equals("БГУ"));
    }

    @Test
    @DisplayName("Фильтр по компетенциям")
    @Description("Производим фильтрацию по компетенциям")
    @Feature("Кандидаты")
    @Story("Сценарий -  Теги фильтров отображаются")
    @Severity(SeverityLevel.MINOR)
    public void filterByCompetenceTag() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.selectCompetence();
        Assert.assertTrue(CandidatesElements.COMPETENCE_FILTER_TAG.getWebElement().getText().equals("Английский язык"));
    }

    @Test
    public void filterByVacancy() throws InterruptedException {
        //не предоставляется возможным протестировать правильное отображение данных по данному фильтру из-за отсутствия доступа к бд
    }

    @Test
    public void filterByEducation() throws InterruptedException {
        //не предоставляется возможным протестировать правильное отображение данных по данному фильтру из-за отсутствия доступа к бд
    }

    @Test
    public void filterByUniversity() throws InterruptedException {
        //не предоставляется возможным протестировать правильное отображение данных по данному фильтру из-за отсутствия доступа к бд
    }

    @Test
    public void filterByCompetence() throws InterruptedException {
        //не предоставляется возможным протестировать правильное отображение данных по данному фильтру из-за отсутствия доступа к бд
    }

    @Test
    @DisplayName("Фильтр по возможности переезда")
    @Description("Производим фильтрацию по возможности переезда")
    @Feature("Кандидаты")
    @Story("Сценарий -  Теги фильтров отображаются")
    @Severity(SeverityLevel.MINOR)
    public void filterByRelocationAvailableTag() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.selectRelocation(RELOCATION_AVAILABLE);
        Assert.assertTrue(CandidatesElements.RELOCATION_AVAILABLE_FILTER_TAG.getWebElement().getText().equals("возможен переезд"));
    }

    @Test
    @DisplayName("Фильтр по невозможности переезда")
    @Description("Производим фильтрацию по невозможности переезда")
    @Feature("Кандидаты")
    @Story("Сценарий -  Теги фильтров отображаются")
    @Severity(SeverityLevel.MINOR)
    public void filterByRelocationUnavailableTag() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.selectRelocation(RELOCATION_UNAVAILABLE);
        Assert.assertTrue(CandidatesElements.RELOCATION_UNAVAILABLE_FILTER_TAG.getWebElement().getText().equals("переезд невозможен"));
    }

    @Test
    public void filterByRelocationAvailable() throws InterruptedException {
        //не предоставляется возможным протестировать правильное отображение данных по данному фильтру из-за отсутствия доступа к бд
    }

    @Test
    public void filterByRelocationUnavailable() throws InterruptedException {
        //не предоставляется возможным протестировать правильное отображение данных по данному фильтру из-за отсутствия доступа к бд
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
