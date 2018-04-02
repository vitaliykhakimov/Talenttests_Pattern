package web.page;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import web.elements.ApplicationsElements;

import java.util.List;

public class ApplicationsPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void clickCreateApplicationButton() {
        WebElement element = driver.findElement(ApplicationsElements.CREATE_APPLICATION_BUTTON);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void clickPreviousPageButton(){
        List<WebElement> buttons = driver.findElements(ApplicationsElements.NAVIGATION_BUTTON);
        buttons.get(0).click();
    }

    public void clickNextPageButton(){
        List<WebElement> buttons = driver.findElements(ApplicationsElements.NAVIGATION_BUTTON);
        buttons.get(1).click();
    }
}
