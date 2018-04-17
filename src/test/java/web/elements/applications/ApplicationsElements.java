package web.elements.applications;

import element.GenericElement;
import org.openqa.selenium.By;

public class ApplicationsElements {
    public static final GenericElement CREATE_APPLICATION_BUTTON = new GenericElement("Создать заявку",
            By.cssSelector(".btn.btn-primary#createButton"));
    public static final GenericElement NAVIGATION_BUTTON = new GenericElement("Панель навигации",
            By.xpath("//div[@id = 'applications-pagination']//li[@class = 'pagination-control']"));
    public static final GenericElement SEARCH_APP = new GenericElement("Поиск заявок",
            By.xpath("//input[@id = 'searchAppInput']"));
    public static final GenericElement FOUNDED_APP = new GenericElement("Найденная заявка",
            By.xpath("//a[contains(text(), 'Junior iOS developer')]"));
    public static final GenericElement REVIEW_BUTTON = new GenericElement("Рассмотреть",
            By.xpath("//a[@id = 'reviewButton']"));
    public static final GenericElement REVIEW_COMMENTS = new GenericElement("Комментарии",
            By.xpath("//div[@id= 'commentModalBody']//textarea[@class = 'form-control success error-field']"));
    public static final GenericElement REVIEW = new GenericElement("Рассмотреть",
            By.xpath("//button[contains(text(), 'Рассмотреть')]"));
}
