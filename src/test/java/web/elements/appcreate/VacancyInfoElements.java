package web.elements.appcreate;

import org.openqa.selenium.By;

public class VacancyInfoElements {
    public static By POSITION = By.xpath("//input[@id = 'name']");
    public static By PLANNING_DATE_FIELD = By.xpath("//input[@id = 'plannedClosingDate']");
    public static By PRIORITY_BUTTON = By.xpath("//div[@class = 'control-group row-fluid col-xs-12 col-md-8 col-lg-8']" +
            "//div[@class = 'controls radio-controls col-xs-12 col-md-8 col-lg-8']" +
            "//input");
    public static By COUNT_OF_CANDIDATES = By.xpath("//input[@id = 'quantity']");
    public static By CREATION_REASON = By.xpath("//textarea[@id = 'creationReason']");
}
