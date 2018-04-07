package web.page.candidates;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import web.elements.candidates.CandidatesElements;

public class CandidatesPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void goToCandidatesPage(){
        driver.get(CandidatesElements.URL);
    }

    public void searchCandidate(String name) {
        CandidatesElements.SEARCH_FIELD.searchCandidate(name);
    }

    public void clickOnFoundedCandidate() throws InterruptedException {
        Thread.sleep(5000);
        CandidatesElements.FOUNDED_CANDIDATE.goToFoundedCandidatePage();
    }

    public void selectExperience(int indexExp) {
        Select selectExp = new Select(CandidatesElements.EXPERIENCE_FILTER.getWebElement());
        selectExp.selectByIndex(indexExp);
    }

    public void clickStatusNew() throws InterruptedException {
        Thread.sleep(5000);
        CandidatesElements.STATUS_NEW_FILTER.getWebElement().click();
    }

    public void clickStatusApproval() throws InterruptedException {
        Thread.sleep(5000);
        CandidatesElements.STATUS_APPROVAL_FILTER.getWebElement().click();
    }

    public void clickStatusAvailable() throws InterruptedException {
        Thread.sleep(5000);
        CandidatesElements.STATUS_AVAILABLE_FILTER.getWebElement().click();
    }

    public void clickStatusHired() throws InterruptedException {
        Thread.sleep(5000);
        CandidatesElements.STATUS_HIRED_FILTER.getWebElement().click();
    }

    public void selectVacancy() throws InterruptedException {
        Thread.sleep(2000);
        CandidatesElements.SELECT_BUTTONS_CLOSED.clickSelectVacancyButton();
        CandidatesElements.SELECT_VACANCY_CHECKBOX.clickFilterCheckbox();
        Thread.sleep(3000);
        CandidatesElements.SELECT_BUTTONS_OPEN.closeSelectButton();
    }

    public void selectEducation() throws InterruptedException {
        Thread.sleep(3000);
        CandidatesElements.SELECT_BUTTONS_CLOSED.clickSelectEducationButton();
        CandidatesElements.SELECT_EDUCATION_CHECKBOX.clickFilterCheckbox();
        Thread.sleep(1000);
        CandidatesElements.SELECT_BUTTONS_OPEN.closeSelectButton();
    }

    public void selectUniversity() throws InterruptedException {
        Thread.sleep(3000);
        CandidatesElements.SELECT_BUTTONS_CLOSED.clickSelectUniversityButton();
        CandidatesElements.SELECT_UNIVERSITY_CHECKBOX.clickFilterCheckbox();
        Thread.sleep(5000);
        CandidatesElements.SELECT_BUTTONS_OPEN.closeSelectButton();
    }

    public void selectCompetence() throws InterruptedException {
        Thread.sleep(3000);
        CandidatesElements.SELECT_BUTTONS_CLOSED.clickSelectCompetenceButton();
        CandidatesElements.SELECT_COMPETENCE_CHECKBOX.clickFilterCheckbox();
        Thread.sleep(3000);
        CandidatesElements.SELECT_BUTTONS_OPEN.closeSelectButton();
    }

    public void selectRelocation(int i) throws InterruptedException {
        Thread.sleep(3000);
        CandidatesElements.RELOCATION_SELECT.selectAndClickCheckBox(i);
    }

    public void clickCreateCandidateButton() {
        CandidatesElements.CREATE_CANDIDATE_BUTTON.clickCreateCandidateButton();
    }
}
