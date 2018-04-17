package web.elements.login;

import driver.WebDriverSingleton;
import element.GenericElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginElements {
    public static String URL = "http://testing.cld.iba.by";

    public static GenericElement USERNAME = new GenericElement("Имя", By.id("_58_login"));
    public static GenericElement PASSWORD = new GenericElement("Пароль", By.id("_58_password"));
    public static GenericElement LOGIN_BUTTON = new GenericElement("Кнопка Войти", By.xpath("//button"));
    public static GenericElement REQUIRED = new GenericElement("Обязательное поле",
            By.xpath("//div[@class = 'form-validator-stack help-inline']//div[@class = 'required']"));
    public static GenericElement ALERT = new GenericElement("Предупреждение", By.xpath("//div[@class = 'alert alert-error']"));
}
