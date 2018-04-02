package web.page.appcreate;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import web.elements.appcreate.PositionInfoElements;
import java.util.List;

public class PositionInfo {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void selectContractType(int type) {
        List<WebElement> contractTypes = driver.findElements(PositionInfoElements.CONTRACT_TYPES);
        contractTypes.get(type).click();
    }

    public void typeSalary(String salary) {
        WebElement element = driver.findElement(PositionInfoElements.SALARY);
        element.sendKeys(salary);
    }

    public void selectCurrency(int type) {
        Select currenciesSelect = new Select(driver.findElement(PositionInfoElements.CURRENCY));
        currenciesSelect.selectByIndex(type);
    }

    public void selectJobType(int type) {
        Select jobTypesSelect = new Select(driver.findElement(PositionInfoElements.JOB_TYPE));
        jobTypesSelect.selectByIndex(type);
    }

    public void typeEmployees(String employees) {
        WebElement element = driver.findElement(PositionInfoElements.EMPLOYEES);
        element.sendKeys(employees);
    }

    public void typeBusinessTrips(String trips) {
        WebElement element = driver.findElement(PositionInfoElements.BUSINESS_TRIPS);
        element.sendKeys(trips);
    }

    public void typeTimetable(String tt) {
        WebElement element = driver.findElement(PositionInfoElements.TIMETABLE);
        element.sendKeys(tt);
    }

    public void typeProbationPeriod(String pp) {
        WebElement element = driver.findElement(PositionInfoElements.PROBATION_PERIOD);
        element.sendKeys(pp);
    }

    public void typeResponsibilities(String resp) {
        WebElement element = driver.findElement(PositionInfoElements.RESPONSIBILITIES);
        element.sendKeys(resp);
    }

    public void typeInformationAboutPositionFull() {
        selectContractType(1);
        typeSalary("3000");
        selectCurrency(2);
        selectJobType(2);
        typeEmployees("В наличии 3 подчиненных.");
        typeBusinessTrips("При необходимости.");
        typeTimetable("5 дней в неделю, 8 часов в день. Сверхурочные работы - при необходимости");
        typeProbationPeriod("1 месяц");
        typeResponsibilities("Составление тест-кейсов.\nНаписание собственных тестов.");
    }
}
