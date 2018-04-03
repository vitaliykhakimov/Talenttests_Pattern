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
        PositionInfoElements.CONTRACT_TYPES.selectAndClickRadioButton(type);
    }

    public void typeSalary(String salary) {
        PositionInfoElements.SALARY.sendKeys(salary);
    }

    public void selectCurrency(int index) {
        Select currenciesSelect = new Select(PositionInfoElements.CURRENCY.getWebElement());
        currenciesSelect.selectByIndex(index);
    }

    public void selectJobType(int index) {
        Select jobTypesSelect = new Select(PositionInfoElements.JOB_TYPE.getWebElement());
        jobTypesSelect.selectByIndex(index);
    }

    public void typeEmployees(String employees) {
        PositionInfoElements.EMPLOYEES.sendKeys(employees);
    }

    public void typeBusinessTrips(String trips) {
        PositionInfoElements.BUSINESS_TRIPS.sendKeys(trips);
    }

    public void typeTimetable(String tt) {
        PositionInfoElements.TIMETABLE.sendKeys(tt);
    }

    public void typeProbationPeriod(String pp) {
        PositionInfoElements.PROBATION_PERIOD.sendKeys(pp);
    }

    public void typeResponsibilities(String resp) {
        PositionInfoElements.RESPONSIBILITIES.sendKeys(resp);
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
