package web.page.appcreate;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.elements.appcreate.CreateApplicationElements;
import web.elements.appcreate.VacancyInfoElements;

import java.util.List;

public class VacancyInfo {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void goToCreateApplicationPage() {
        driver.get(CreateApplicationElements.URL);
    }

    public void typePosition(String position) {
        WebElement element = driver.findElement(VacancyInfoElements.POSITION);
        element.sendKeys(position);
    }

    public void typePlanningDate(String date) {
        WebElement element = driver.findElement(VacancyInfoElements.PLANNING_DATE_FIELD);
        element.sendKeys(date);
    }

    public void selectPriority(int priority) {
        List<WebElement> priorities = driver.findElements(VacancyInfoElements.PRIORITY_BUTTON);
        priorities.get(priority).click();

    }

    public void typeCountOfCandidates(String count) {
        WebElement element = driver.findElement(VacancyInfoElements.COUNT_OF_CANDIDATES);
        element.sendKeys(count);
    }

    public void typeCreationReason(String reason) {
        WebElement element = driver.findElement(VacancyInfoElements.CREATION_REASON);
        element.sendKeys(reason);
    }

    public void typeInformationAboutVacancyFull() {
        typePosition("QA engineer");
        typePlanningDate("12.04.2018");
        selectPriority(2);
        typeCountOfCandidates("3");
        typeCreationReason("Резкая необходимость.");
    }
}
