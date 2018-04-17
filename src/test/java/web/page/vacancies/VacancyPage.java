package web.page.vacancies;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import util.Helper;
import web.elements.vacancies.VacanciesElements;

public class VacancyPage {

    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Кликаем кнопку создания вакансии")
    public void clickCreateVacancyButton() {
        VacanciesElements.CREATE_VACANCY_BUTTON.click();
    }

    @Step("Создаем вакансию")
    public void creatingVacancy() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
        Helper.waitForTime(2);
        VacanciesElements.SAVE_BUTTON.click();
    }

    @Step("Открываем вакансию")
    public void openVacancy() {
        Helper.waitForTime(2);
        VacanciesElements.OPEN_VACANCY_BUTTON.click();
    }

    @Step("Ищем вакансию и переходим на её страницу")
    public void searchVacancy(String name) {
        VacanciesElements.SEARCH_VACANCY.sendKeys(name);
        Helper.waitForTime(1);
        VacanciesElements.VACANCY.click();
    }

    @Step("Добавляем кандидата в шортлист")
    public void addToShortlist(String name) {
        VacanciesElements.CANDIDATES_TAB.click();
        VacanciesElements.ADD_CANDIDATE_BUTTON.click();
        VacanciesElements.SEARCH_CANDIDATE_FOR_SHORTLIST.sendKeys(name);
        VacanciesElements.CANDIDATE.getWebElements().get(1).click();
        VacanciesElements.OK_BUTTON.getWebElements().get(1).click();
    }

    @Step("Добавляем вопрос к интервью")
    public void addQuestions(String question, String answer, String competence) {
        VacanciesElements.INTERVIEW_PLAN_TAB.click();
        VacanciesElements.ADD_QUESTION_BUTTON.click();
        Helper.waitForTime(2);
        VacanciesElements.PERSONAL_QUESTIONS_TAB.click();
        VacanciesElements.ADD_QUESTION_BTN.click();
        Helper.waitForTime(2);
        VacanciesElements.QUESTION_FIELD.sendKeys(question);
        VacanciesElements.ANSWER_FIELD.sendKeys(answer);
        VacanciesElements.COMPETENCE_FIELD.sendKeys(competence);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).perform();
        //VacanciesElements.SAVE_QUESTION_BUTTON.click();
        actions.click(VacanciesElements.SAVE_QUESTION_BUTTON.getWebElement()).perform();
    }
 }
