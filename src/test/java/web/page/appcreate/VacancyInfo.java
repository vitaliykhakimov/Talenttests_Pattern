package web.page.appcreate;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.elements.appcreate.CreateApplicationElements;
import web.elements.appcreate.VacancyInfoElements;

import java.util.List;

public class VacancyInfo {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Переходим на страницу создания заявки")
    public void goToCreateApplicationPage() {
        driver.get(CreateApplicationElements.URL);
    }

    @Step("Ввод должности")
    public void typePosition(String position) {
        VacancyInfoElements.POSITION.sendKeys(position);
    }

    @Step("Ввод даты окончания набора")
    public void typePlanningDate(String date) {
        VacancyInfoElements.PLANNING_DATE_FIELD.sendKeys(date);
    }

    @Step("Выбираем приоритет")
    public void selectPriority(int priority) {
        VacancyInfoElements.PRIORITY_BUTTON.selectAndClickRadioButton(priority);
    }

    @Step("Вводим количество кандидатов")
    public void typeCountOfCandidates(String count) {
        VacancyInfoElements.COUNT_OF_CANDIDATES.sendKeys(count);
    }

    @Step("Вводим причину создания")
    public void typeCreationReason(String reason) {
        VacancyInfoElements.CREATION_REASON.sendKeys(reason);
    }

    @Step("Вводим всю информацию о вакансии")
    public void typeInformationAboutVacancyFull() {
        typePosition("QA engineer");
        typePlanningDate("12.04.2018");
        selectPriority(2);
        typeCountOfCandidates("3");
        typeCreationReason("Резкая необходимость.");
    }
}
