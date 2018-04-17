package web.page.applications;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import util.Helper;
import web.elements.applications.ApprovalElements;

public class ApprovalPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Кликаем кнопку Отправить на согласование")
    public void clickSendToApprovalButton() {
        ApprovalElements.SEND_TO_APPROVAL_BUTTON.click();
    }

    @Step("Выбираем участвующих в согласовании сотрудников")
    public void selectApprovalPersons() {
        Helper.waitForTime(1);
        ApprovalElements.REVIEW_PERSONS.click();
        ApprovalElements.SELECT_BUTTON.getWebElements().get(0).click();
        ApprovalElements.SELECT.click();
        ApprovalElements.OK_BUTTON.click();

        Helper.waitForTime(1);
        ApprovalElements.APPROVE_PERSONS.click();
        ApprovalElements.SELECT_BUTTON.getWebElements().get(0).click();
        ApprovalElements.SELECT.click();
        ApprovalElements.OK_BUTTON.click();

        Helper.waitForTime(1);
        ApprovalElements.SEND_PERSONS.click();
        ApprovalElements.SELECT_BUTTON.getWebElements().get(0).click();
        ApprovalElements.SELECT.click();
        ApprovalElements.OK_BUTTON.click();
    }

    @Step("Кликаем кнопку Отправить на согласование")
    public void clickApproveButton() {
        ApprovalElements.APPROVE_BUTTON.click();
    }
}
