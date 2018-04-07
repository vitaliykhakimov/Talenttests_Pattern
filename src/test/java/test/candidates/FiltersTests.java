package test.candidates;

import driver.WebDriverSingleton;
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

    private void login(){
        lp.enterLoginPage();
        lp.typeUsername("kabanov@tc.by");
        lp.typePassword("welcome");
        lp.clickLoginButton();
    }

    @Test//Тест на отображение тега фильтра по опыту работы
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

    @Test//Тест на отображение тегов фильтра по статусу "Новый"
    public void filterByStatusTagNew() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.clickStatusNew();
        Assert.assertTrue(CandidatesElements.STATUS_NEW_TAG.getWebElement().getText().equals("Новый"));
    }

    @Test//Тест на отображение тегов фильтра по статусу "Рассматривается на вакансию"
    public void filterByStatusTagApproval() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.clickStatusApproval();
        Assert.assertTrue(CandidatesElements.STATUS_APPROVAL_TAG.getWebElement().getText().equals("Рассматривается на вакансию"));
    }

    @Test//Тест на отображение тегов фильтра по статусу "Доступен для рассмотрения"
    public void filterByStatusTagAvailable() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.clickStatusAvailable();
        Assert.assertTrue(CandidatesElements.STATUS_AVAILABLE_TAG.getWebElement().getText().equals("Доступен для рассмотрения"));
    }

    @Test//Тест на отображение тегов фильтра по статусу "Принят на работу"
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

    //проверка отображения тега "вакансии"
    @Test
    public void filterByVacancyTag() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.selectVacancy();
        Assert.assertTrue(CandidatesElements.VACANCY_FILTER_TAG.getWebElement().getText().equals("Дизайнер"));
    }

    //проверка отображения тега "образование"
    @Test
    public void filterByEducationTag() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.selectEducation();
        Assert.assertTrue(CandidatesElements.EDUCATION_FILTER_TAG.getWebElement().getText().equals("Не указано"));
    }

    //проверка отображения тега "университет"
    @Test
    public void filterByUniversityTag() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.selectUniversity();
        Assert.assertTrue(CandidatesElements.UNIVERSITY_FILTER_TAG.getWebElement().getText().equals("БГУ"));
    }

    //проверка отображения тега "компетенции"
    @Test
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

    //Тест проверяет тег фильтра по возможности переезда "возможен переезд"
    @Test
    public void filterByRelocationAvailableTag() throws InterruptedException {
        login();
        cp.goToCandidatesPage();
        cp.selectRelocation(RELOCATION_AVAILABLE);
        Assert.assertTrue(CandidatesElements.RELOCATION_AVAILABLE_FILTER_TAG.getWebElement().getText().equals("возможен переезд"));
    }

    //Тест проверяет тег фильтра по возможности переезда "переезд невозможен"
    @Test
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
