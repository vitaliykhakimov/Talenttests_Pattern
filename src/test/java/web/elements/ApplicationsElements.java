package web.elements;

import org.openqa.selenium.By;

public class ApplicationsElements {
    public static By CREATE_APPLICATION_BUTTON = By.cssSelector(".btn.btn-primary#createButton");
    public static By NAVIGATION_BUTTON = By.xpath("//div[@id = 'applications-pagination']//li[@class = 'pagination-control']");
}
