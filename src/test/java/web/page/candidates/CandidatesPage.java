package web.page.candidates;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import util.Helper;
import web.elements.candidates.CandidatesElements;

public class CandidatesPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Переход на страницу кандидатов")
    public void goToCandidatesPage(){
        driver.get(CandidatesElements.URL);
    }

    @Step("Поиск кандидата")
    public void searchCandidate(String name) {
        CandidatesElements.SEARCH_FIELD.searchCandidate(name);
    }

    @Step("Переход на страницу найденного кандидата")
    public void clickOnFoundedCandidate() {
        Helper.waitForTime(2);
        CandidatesElements.FOUNDED_CANDIDATE.goToFoundedCandidatePage();
    }

    @Step("Выбираем опыт")
    public void selectExperience(int indexExp) {
        Select selectExp = new Select(CandidatesElements.EXPERIENCE_FILTER.getWebElement());
        selectExp.selectByIndex(indexExp);
    }

    @Step("Выбираем статус Новый")
    public void clickStatusNew() throws InterruptedException {
        Thread.sleep(5000);
        CandidatesElements.STATUS_NEW_FILTER.getWebElement().click();
    }

    @Step("Выбираем стату Рассматривается на вакансию")
    public void clickStatusApproval() throws InterruptedException {
        Thread.sleep(5000);
        CandidatesElements.STATUS_APPROVAL_FILTER.getWebElement().click();
    }

    @Step("Выбираем статус Доступен")
    public void clickStatusAvailable() throws InterruptedException {
        Thread.sleep(5000);
        CandidatesElements.STATUS_AVAILABLE_FILTER.getWebElement().click();
    }

    @Step("Выбираем статус Принят на работу")
    public void clickStatusHired() throws InterruptedException {
        Thread.sleep(5000);
        CandidatesElements.STATUS_HIRED_FILTER.getWebElement().click();
    }

    @Step("Выбираем вакансиб")
    public void selectVacancy() throws InterruptedException {
        Thread.sleep(2000);
        CandidatesElements.SELECT_BUTTONS_CLOSED.clickSelectVacancyButton();
        CandidatesElements.SELECT_VACANCY_CHECKBOX.clickFilterCheckbox();
        Thread.sleep(3000);
        CandidatesElements.SELECT_BUTTONS_OPEN.closeSelectButton();
    }

    @Step("Выбираем образование")
    public void selectEducation() throws InterruptedException {
        Thread.sleep(3000);
        CandidatesElements.SELECT_BUTTONS_CLOSED.clickSelectEducationButton();
        CandidatesElements.SELECT_EDUCATION_CHECKBOX.clickFilterCheckbox();
        Thread.sleep(1000);
        CandidatesElements.SELECT_BUTTONS_OPEN.closeSelectButton();
    }

    @Step("Выбираем университет")
    public void selectUniversity() throws InterruptedException {
        Thread.sleep(3000);
        CandidatesElements.SELECT_BUTTONS_CLOSED.clickSelectUniversityButton();
        CandidatesElements.SELECT_UNIVERSITY_CHECKBOX.clickFilterCheckbox();
        Thread.sleep(5000);
        CandidatesElements.SELECT_BUTTONS_OPEN.closeSelectButton();
    }

    @Step("Выбираем компетенции")
    public void selectCompetence() throws InterruptedException {
        Thread.sleep(3000);
        CandidatesElements.SELECT_BUTTONS_CLOSED.clickSelectCompetenceButton();
        CandidatesElements.SELECT_COMPETENCE_CHECKBOX.clickFilterCheckbox();
        Thread.sleep(3000);
        CandidatesElements.SELECT_BUTTONS_OPEN.closeSelectButton();
    }

    @Step("Выбираем возможность переезда")
    public void selectRelocation(int index) throws InterruptedException {
        Thread.sleep(3000);
        CandidatesElements.RELOCATION_SELECT.selectAndClickCheckBox(index);
    }

    @Step("Кликаем кнопку создания кандидата")
    public void clickCreateCandidateButton() {
        CandidatesElements.CREATE_CANDIDATE_BUTTON.clickCreateCandidateButton();
    }

    @Step("Приглашаем на интервью")
    public void inviteForTheInterview() {
        CandidatesElements.INVITE_FOR_INTERVIEW_BTN.click();
        CandidatesElements.CREATE_INTERVIEW_DATE.click();
        CandidatesElements.INTERVIEWER.sendKeys("Ленина Алёна");
        CandidatesElements.DATE.sendKeys("18.04.2018");
        CandidatesElements.TIMEPICKER_START.sendKeys("9:00");
        CandidatesElements.TIMEPICKER_END.sendKeys("10:00");

        Actions actions = new Actions(driver);
        actions.click(CandidatesElements.SAVE_BUTTON.getWebElement()).perform();
    }

    @Step("Прошел интервью")
    public void passedTheInterview() {
        CandidatesElements.PASSED_INTERVIEW_BUTTON.click();
    }

    @Step("Приглашаем на работу")
    public void offeredJob() {
        CandidatesElements.OFFERED_A_JOB_BUTTON.click();
    }
}
