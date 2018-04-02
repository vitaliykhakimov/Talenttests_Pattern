package web.page.appcreate;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import web.elements.appcreate.CreateApplicationElements;

import java.util.List;

public class CreateApplicationPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void goToCreateApplicationPage() {
        driver.get(CreateApplicationElements.URL);
    }

    public void clickSaveButton() {
        WebElement element = driver.findElement(CreateApplicationElements.SAVE_BUTTON);
        element.click();
    }
}
