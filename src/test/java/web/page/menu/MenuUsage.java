package web.page.menu;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.elements.menu.MenuElements;

public class MenuUsage {
    private WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Переход на страницу профиля")
    public void goToProfilePage() {
        WebElement element = driver.findElement(MenuElements.MENU_PROFILE);
        element.click();
    }

    @Step("Переход на главную страницу")
    public void goToMainPage() {
        WebElement element = driver.findElement(MenuElements.MENU_MAIN);
        element.click();
    }

    @Step("Переход на страницу подбора и адаптации")
    public void goToSelectAndAdaptationPage() {
        WebElement element = driver.findElement(MenuElements.MENU_SELECT_AND_ADAPTATION);
        element.click();
    }

    @Step("Переход на страницу заявок")
    public void goToApplicationsPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_APPLICATIONS);
        element.click();
    }

    @Step("Переход на страницу вакансий")
    public void goToVacanciesPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_VACANCIES);
        element.click();
    }

    @Step("Переход на страницу кандидатов")
    public void goToCandidatesPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_CANDIDATES);
        element.click();
    }

    @Step("Переход на страницу шаблонов")
    public void goToAdTemplatesPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_AD_TEMPLATES);
        element.click();
    }

    @Step("Переход на страницу отчета по вакансиям")
    public void goToVacanciesReportPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_VACANCIES_REPORT);
        element.click();
    }

    @Step("Переход на страницу отчета по рекрутерам")
    public void goToRecruitersReportPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_RECRUITERS_REPORT);
        element.click();
    }

    @Step("Переход на страницу справочников")
    public void goToDirectoriesPage() {
        WebElement element = driver.findElement(MenuElements.MENU_DIRECTORIES);
        element.click();
    }

    @Step("Переход на страницу справочника работников")
    public void goToCoWorkersDirectoryPage() {
        goToDirectoriesPage();
        WebElement element = driver.findElement(MenuElements.MENU_COWORKERS_DIRECTORY);
        element.click();
    }

    @Step("Переход на страницу справочника подразделений")
    public void goToUnitsDirectoryPage() {
        goToDirectoriesPage();
        WebElement element = driver.findElement(MenuElements.MENU_UNITS_DIRECTORY);
        element.click();
    }

    @Step("Выходим из системы")
    public void exitButton() {
        MenuElements.EXIT.click();
    }
}
