package web.page.appcreate;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import web.elements.appcreate.CreateApplicationElements;
import web.elements.appcreate.RequirmentsToCandidateElements;

import java.util.List;

public class RequirmentsToCandidate {

    WebDriver driver = WebDriverSingleton.getInstance();

    public void selectCandidatesType(int type) {
        List<WebElement> candidateTypes = driver.findElements(RequirmentsToCandidateElements.CANDIDATE_TYPE);
        candidateTypes.get(type).click();
    }

    public void selectEducationLvl(int lvl) {
        Select educationSelect = new Select(driver.findElement(RequirmentsToCandidateElements.EDUCATION));
        educationSelect.selectByIndex(lvl);
    }

    public void typeEducationSpec(String spec) {
        WebElement element = driver.findElement(RequirmentsToCandidateElements.EDUCATION_SPECIALIZATION);
        element.sendKeys(spec);
    }

    public void selectExpirience(int exp) {
        Select expirienceSelect = new Select(driver.findElement(RequirmentsToCandidateElements.EXPIRIENCE));
        expirienceSelect.selectByIndex(exp);
    }

    public void typePriorityWorkExpirience(String pwe) {
        WebElement element = driver.findElement(RequirmentsToCandidateElements.PRIORITY_WORK_EXPIRIENCE);
        element.sendKeys(pwe);
    }

    public void typeUnwantedWorkExpirience(String uwe) {
        WebElement element = driver.findElement(RequirmentsToCandidateElements.UNWANTED_WORK_EXPIRIENCE);
        element.sendKeys(uwe);
    }

    public void typeComments(String comm) {
        WebElement element = driver.findElement(RequirmentsToCandidateElements.COMMENTS);
        element.sendKeys(comm);
    }

    public void clickAddRequireCompetenceButton() {
        List<WebElement> elements = driver.findElements(RequirmentsToCandidateElements.ADD_COMPETENCE_BUTTON);
        elements.get(0).click();
    }

    public void selectRequireCompetencies() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement searchingCompetence = driver.findElement(RequirmentsToCandidateElements.SEARCHING_COMPETENCE);
        searchingCompetence.sendKeys("Обучаемость");
        Thread.sleep(1500);
        WebElement competence = driver.findElement(RequirmentsToCandidateElements.COMPETENCE1);
        action.doubleClick(competence).build().perform();

        searchingCompetence.clear();
        searchingCompetence.sendKeys("MySQL");
        Thread.sleep(1500);
        competence = driver.findElement(RequirmentsToCandidateElements.COMPETENCE2);
        action.doubleClick(competence).build().perform();

        WebElement okBtn = driver.findElement(RequirmentsToCandidateElements.OK_BUTTON);
        Thread.sleep(1500);
        okBtn.click();
    }

    public void clickAddWantedCompetenceButton() {
        List<WebElement> elements = driver.findElements(RequirmentsToCandidateElements.ADD_COMPETENCE_BUTTON);
        elements.get(1).click();
    }

    public void selectWantedCompetencies() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement searchingCompetence = driver.findElement(RequirmentsToCandidateElements.SEARCHING_COMPETENCE);
        searchingCompetence.sendKeys("Английский язык");

        Thread.sleep(1500);
        WebElement competence = driver.findElement(RequirmentsToCandidateElements.COMPETENCE3);
        action.doubleClick(competence).build().perform();

        WebElement okBtn = driver.findElement(RequirmentsToCandidateElements.OK_BUTTON);
        Thread.sleep(1500);
        okBtn.click();
    }

    public void typeRequirmentsToCandidateFull() throws InterruptedException {
        selectCandidatesType(0);
        selectEducationLvl(4);
        typeEducationSpec("Инженер-программист");
        selectExpirience(1);
        typePriorityWorkExpirience("EPAM");
        typeUnwantedWorkExpirience("Интеграл");
        clickAddRequireCompetenceButton();
        selectRequireCompetencies();
        clickAddWantedCompetenceButton();
        selectWantedCompetencies();
        typeComments("Тут комментарии.");
    }
}
