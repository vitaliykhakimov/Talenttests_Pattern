package web.page.appcreate;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import web.elements.appcreate.RequirmentsToCandidateElements;


public class RequirmentsToCandidate {

    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Выбор типа кандидата")
    public void selectCandidatesType(int type) {
        RequirmentsToCandidateElements.CANDIDATE_TYPE.selectAndClickCheckBox(type);
    }

    @Step("Выбор уровня образования")
    public void selectEducationLvl(int lvl) {
        Select educationSelect = new Select(RequirmentsToCandidateElements.EDUCATION.getWebElement());
        educationSelect.selectByIndex(lvl);
    }

    @Step("Ввод специальности")
    public void typeEducationSpec(String spec) {
        RequirmentsToCandidateElements.EDUCATION_SPECIALIZATION.sendKeys(spec);
    }

    @Step("Выбор опыта")
    public void selectExpirience(int exp) {
        Select expirienceSelect = new Select(RequirmentsToCandidateElements.EXPIRIENCE.getWebElement());
        expirienceSelect.selectByIndex(exp);
    }

    @Step("Ввод компаний, опыт в которых в приоритете")
    public void typePriorityWorkExpirience(String pwe) {
        RequirmentsToCandidateElements.PRIORITY_WORK_EXPIRIENCE.sendKeys(pwe);
    }

    @Step("Ввод компаний, опыт в которых нежелателен")
    public void typeUnwantedWorkExpirience(String uwe) {
        RequirmentsToCandidateElements.UNWANTED_WORK_EXPIRIENCE.sendKeys(uwe);
    }

    @Step("Ввод комментариев")
    public void typeComments(String comm) {
        RequirmentsToCandidateElements.COMMENTS.sendKeys(comm);
    }

    @Step("Нажимаем на кнопку добавления обязательных компетенций")
    public void clickAddRequireCompetence() {
        RequirmentsToCandidateElements.ADD_COMPETENCE_BUTTON.clickAddRequireCompetenceButton();
    }

    @Step("Выбираем обязательные компетенции")
    public void selectRequireCompetencies() throws InterruptedException {
        Actions action = new Actions(driver);
        RequirmentsToCandidateElements.SEARCHING_COMPETENCE.sendKeys("Обучаемость");
        Thread.sleep(1500);
        action.doubleClick(RequirmentsToCandidateElements.COMPETENCE1.getWebElement()).build().perform();
        RequirmentsToCandidateElements.SEARCHING_COMPETENCE.getWebElement().clear();
        RequirmentsToCandidateElements.SEARCHING_COMPETENCE.sendKeys("MySQL");
        Thread.sleep(1500);
        action.doubleClick(RequirmentsToCandidateElements.COMPETENCE2.getWebElement()).build().perform();
        Thread.sleep(1500);
        RequirmentsToCandidateElements.OK_BUTTON.click();
    }

    @Step("Нажимаем кнопку добавления желательных компетенций")
    public void clickAddWantedCompetence() {
        RequirmentsToCandidateElements.ADD_COMPETENCE_BUTTON.clickAddWantedCompetenceButton();
    }

    @Step("Выбираем желательные компетенции")
    public void selectWantedCompetencies() throws InterruptedException {
        Actions action = new Actions(driver);
        RequirmentsToCandidateElements.SEARCHING_COMPETENCE.sendKeys("Английский язык");
        Thread.sleep(1500);
        action.doubleClick(RequirmentsToCandidateElements.COMPETENCE3.getWebElement()).build().perform();
        Thread.sleep(1500);
        RequirmentsToCandidateElements.OK_BUTTON.click();
    }

    @Step("Заполняем все поля требований к кандидату")
    public void typeRequirmentsToCandidateFull() throws InterruptedException {
        selectCandidatesType(0);
        selectEducationLvl(4);
        typeEducationSpec("Инженер-программист");
        selectExpirience(1);
        typePriorityWorkExpirience("EPAM");
        typeUnwantedWorkExpirience("Интеграл");
        clickAddRequireCompetence();
        selectRequireCompetencies();
        clickAddWantedCompetence();
        selectWantedCompetencies();
        typeComments("Тут комментарии.");
    }
}
