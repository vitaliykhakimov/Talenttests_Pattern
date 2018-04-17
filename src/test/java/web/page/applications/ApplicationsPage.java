package web.page.applications;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.Helper;
import web.elements.applications.ApplicationsElements;
import web.elements.applications.ApprovalElements;

import java.util.List;

public class ApplicationsPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Кликаем кнопку создания заявки")
    public void clickCreateApplicationButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(ApplicationsElements.CREATE_APPLICATION_BUTTON.getWebElement()).click().build().perform();
    }

    @Step("Переход на предыдущю страницу")
    public void clickPreviousPageButton(){
        ApplicationsElements.NAVIGATION_BUTTON.getWebElements();
        ApplicationsElements.NAVIGATION_BUTTON.getWebElements().get(0).click();
    }

    @Step("Переход на следующую страницу")
    public void clickNextPageButton(){
        ApplicationsElements.NAVIGATION_BUTTON.getWebElements();
        ApplicationsElements.NAVIGATION_BUTTON.getWebElements().get(1).click();
    }

    @Step("Кликаем кнопку Согласовать заявку")
    public void clickApproveButton() {
        ApprovalElements.APPROVE_BUTTON.click();
    }

    @Step("Ищем нужную заявку")
    public void searchApp(String app) {
        ApplicationsElements.SEARCH_APP.sendKeys(app);
        Helper.waitForTime(2);
        ApplicationsElements.FOUNDED_APP.click();
    }

    @Step("Рассматриваем заявку")
    public void reviewApp() {
        ApplicationsElements.REVIEW_BUTTON.click();
        Helper.waitForTime(1);
        ApplicationsElements.REVIEW_COMMENTS.getWebElements().get(0).sendKeys("Ok");
        ApplicationsElements.REVIEW.click();
    }
}
