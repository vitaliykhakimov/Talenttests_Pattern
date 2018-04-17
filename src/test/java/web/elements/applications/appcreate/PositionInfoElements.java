package web.elements.applications.appcreate;

import element.GenericElement;
import org.openqa.selenium.By;

public class PositionInfoElements {
    public static final GenericElement CONTRACT_TYPES = new GenericElement ("Тип договора",
            By.xpath("//div[@class = 'control-group contractType row-fluid col-xs-12 col-md-8 col-lg-8 my-success']"+
            "//div[@class = 'controls radio-controls col-xs-12 col-md-8 col-lg-8']"+
            "//input"));
    public static final GenericElement SALARY = new GenericElement ("Зарплата", By.xpath("//input[@id = 'salary']"));
    public static final GenericElement CURRENCY = new GenericElement ("Валюта", By.xpath("//select[@id = 'currency']"));
    public static final GenericElement JOB_TYPE = new GenericElement ("Тип занятости", By.xpath("//select[@id = 'jobType']"));
    public static final GenericElement EMPLOYEES = new GenericElement ("Наличие подчиненных", By.xpath("//input[@id = 'employees']"));
    public static final GenericElement BUSINESS_TRIPS = new GenericElement ("Командировки", By.xpath("//input[@id = 'businessTrip']"));
    public static final GenericElement TIMETABLE = new GenericElement ("График работы", By.xpath("//input[@id = 'timetable']"));
    public static final GenericElement PROBATION_PERIOD = new GenericElement  ("Испытательный срок", By.xpath("//input[@id = 'probationPeriod']"));
    public static final GenericElement RESPONSIBILITIES  = new GenericElement ("Обязанности", By.xpath("//textarea[@id = 'responsibilities']"));
}
