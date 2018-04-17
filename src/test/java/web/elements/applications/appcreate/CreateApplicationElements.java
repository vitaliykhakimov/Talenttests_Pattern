package web.elements.applications.appcreate;

import element.GenericElement;
import org.openqa.selenium.By;

public class CreateApplicationElements {
    public static String URL = "http://testing.cld.iba.by/web/guest/recruiting/applications/-/applications/createApplication";
    public static final GenericElement SAVE_BUTTON = new GenericElement("Сохранить", By.xpath("//button[@id = 'save']"));
}
