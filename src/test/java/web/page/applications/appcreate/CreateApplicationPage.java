package web.page.applications.appcreate;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import web.elements.applications.ApplicationPreviewElements;
import web.elements.applications.appcreate.CreateApplicationElements;

public class CreateApplicationPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Переход на страницу создания заявки")
    public void goToCreateApplicationPage() {
        driver.get(CreateApplicationElements.URL);
    }

    @Step("Кликаем кнопку Сохранить")
    public void clickSaveButton() {
        CreateApplicationElements.SAVE_BUTTON.click();
    }
}
