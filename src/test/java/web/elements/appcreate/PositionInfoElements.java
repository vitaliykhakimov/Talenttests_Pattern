package web.elements.appcreate;

import org.openqa.selenium.By;

public class PositionInfoElements {
    public static By CONTRACT_TYPES = By.xpath("//div[@class = 'control-group contractType row-fluid col-xs-12 col-md-8 col-lg-8 my-success']"+
            "//div[@class = 'controls radio-controls col-xs-12 col-md-8 col-lg-8']"+
            "//input");
    public static By SALARY = By.xpath("//input[@id = 'salary']");
    public static By CURRENCY = By.xpath("//select[@id = 'currency']");
    public static By JOB_TYPE = By.xpath("//select[@id = 'jobType']");
    public static By EMPLOYEES = By.xpath("//input[@id = 'employees']");
    public static By BUSINESS_TRIPS = By.xpath("//input[@id = 'businessTrip']");
    public static By TIMETABLE = By.xpath("//input[@id = 'timetable']");
    public static By PROBATION_PERIOD = By.xpath("//input[@id = 'probationPeriod']");
    public static By RESPONSIBILITIES = By.xpath("//textarea[@id = 'responsibilities']");
}
