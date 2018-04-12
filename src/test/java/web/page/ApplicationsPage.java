package web.page;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import web.elements.ApplicationsElements;

import java.util.List;

public class ApplicationsPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Кликаем кнопку создания заявки")
    public void clickCreateApplicationButton() {
        WebElement element = driver.findElement(ApplicationsElements.CREATE_APPLICATION_BUTTON);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    @Step("Переход на предыдущю страницу")
    public void clickPreviousPageButton(){
        List<WebElement> buttons = driver.findElements(ApplicationsElements.NAVIGATION_BUTTON);
        buttons.get(0).click();
    }

    @Step("Переход на следующую страницу")
    public void clickNextPageButton(){
        List<WebElement> buttons = driver.findElements(ApplicationsElements.NAVIGATION_BUTTON);
        buttons.get(1).click();
    }
}
