package web.elements;

import org.openqa.selenium.By;

public class ApplicationPreviewElements {
    public static By APPLICATION_NAME = By.xpath("//div[@class = 'application-name']");
    public static By CANDIDATES_COUNT = By.xpath("//div[@class = 'view-mode row-fluid']//span[@class = 'col-xs-12 col-sm-6 col-md-6 col-lg-7']");
    public static By COMMENTS_REASON_SPEC = By.xpath("//div[@class = 'col-xs-12 col-sm-6 col-md-6 col-lg-7']//pre[@class= 'text large-field']");
    public static By ELEMENTS_WITH_OWN_PATH = By.xpath("//div[@class = 'col-xs-12 col-sm-6 col-md-6 col-lg-7 word-break']");
    public static By TYPE_WORK_AND_TYPE_CANDIDATE = By.xpath("//div[@class = 'col-xs-12 col-sm-6 col-md-6 col-lg-7 word-break text-lowercase']");
    public static By RESPONSIBILITIES = By.xpath("//div[@class = 'col-xs-12 col-sm-6 col-md-6 col-lg-7 ']//pre");
    /*public static By SALARY = By.xpath(xpath1);
    public static By EMPLOYEES_COUNT = By.xpath(xpath1);
    public static By BUSINESS_TRIPS = By.xpath(xpath1);
    public static By TIMETABLE = By.xpath(xpath1);
    public static By PROBATION_PERIOD = By.xpath(xpath1);
    public static By EDUCATION = By.xpath(xpath1);
    public static By EXPIRIENCE = By.xpath(xpath1);
    public static By PRIORITY_WORK_EXPIRIENCE = By.xpath(xpath1);
    public static By UNWANTED_WORK_EXPIRIENCE = By.xpath(xpath1);*/
}
