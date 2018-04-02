package web.page;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.elements.LoginElements;
import web.elements.MenuElements;

public class MenuUsage {
    private WebDriver driver = WebDriverSingleton.getInstance();

    public void goToProfilePage() {
        WebElement element = driver.findElement(MenuElements.MENU_PROFILE);
        element.click();
    }

    public void goToMainPage() {
        WebElement element = driver.findElement(MenuElements.MENU_MAIN);
        element.click();
    }

    public void goToSelectAndAdaptationPage() {
        WebElement element = driver.findElement(MenuElements.MENU_SELECT_AND_ADAPTATION);
        element.click();
    }

    public void goToApplicationsPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_APPLICATIONS);
        element.click();
    }

    public void goToVacanciesPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_VACANCIES);
        element.click();
    }

    public void goToCandidatesPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_CANDIDATES);
        element.click();
    }

    public void goToAdTemplatesPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_AD_TEMPLATES);
        element.click();
    }

    public void goToVacanciesReportPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_VACANCIES_REPORT);
        element.click();
    }

    public void goToRecruitersReportPage() {
        goToSelectAndAdaptationPage();
        WebElement element = driver.findElement(MenuElements.MENU_RECRUITERS_REPORT);
        element.click();
    }

    public void goToDirectoriesPage() {
        WebElement element = driver.findElement(MenuElements.MENU_DIRECTORIES);
        element.click();
    }

    public void goToCoWorkersDirectoryPage() {
        goToDirectoriesPage();
        WebElement element = driver.findElement(MenuElements.MENU_COWORKERS_DIRECTORY);
        element.click();
    }

    public void goToUnitsDirectoryPage() {
        goToDirectoriesPage();
        WebElement element = driver.findElement(MenuElements.MENU_UNITS_DIRECTORY);
        element.click();
    }

}
