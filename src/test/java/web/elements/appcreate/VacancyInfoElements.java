package web.elements.appcreate;

import element.GenericElement;
import org.openqa.selenium.By;

public class VacancyInfoElements {
    public static final GenericElement POSITION = new GenericElement("Должность", By.xpath("//input[@id = 'name']"));
    public static final GenericElement PLANNING_DATE_FIELD = new GenericElement("Запланированная дата закрытия",
            By.xpath("//input[@id = 'plannedClosingDate']"));
    public static final GenericElement PRIORITY_BUTTON = new GenericElement ("Приоритет",
            By.xpath("//div[@class = 'control-group row-fluid col-xs-12 col-md-8 col-lg-8']" +
            "//div[@class = 'controls radio-controls col-xs-12 col-md-8 col-lg-8']" +
            "//input"));
    public static final GenericElement COUNT_OF_CANDIDATES = new GenericElement ("Количество кандидатов", By.xpath("//input[@id = 'quantity']"));
    public static final GenericElement CREATION_REASON = new GenericElement ("Причина заявки", By.xpath("//textarea[@id = 'creationReason']"));
}
