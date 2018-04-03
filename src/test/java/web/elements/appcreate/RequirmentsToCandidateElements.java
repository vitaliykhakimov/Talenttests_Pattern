package web.elements.appcreate;

import element.GenericElement;
import org.openqa.selenium.By;

public class RequirmentsToCandidateElements {
    public static final GenericElement CANDIDATE_TYPE = new GenericElement ("Тип кандидата", By.xpath("//div[@class = 'controls col-xs-12 col-md-8 col-lg-8']" +
            "//div[@class = 'checkbox checkbox-recruiting checkbox-inline col-lg-4 col-md-4 col-sm-4 col-xs-4 text-lowercase']" +
            "//input"));
    public static final GenericElement EDUCATION = new GenericElement ("Образование", By.xpath("//select[@id = 'education']"));
    public static final GenericElement EDUCATION_SPECIALIZATION = new GenericElement ("Специальность",
            By.xpath("//textarea[@id = 'educationSpecialization']"));
    public static final GenericElement EXPIRIENCE = new GenericElement ("Опыт работы", By.xpath("//select[@id = 'experience']"));
    public static final GenericElement PRIORITY_WORK_EXPIRIENCE = new GenericElement ("Компании, опыт работы в которых приветствуется",
            By.xpath("//textarea[@id = 'priority.working.experience']"));
    public static final GenericElement UNWANTED_WORK_EXPIRIENCE = new GenericElement ("Компании, опыт работы в которых нежелателен",
            By.xpath("//textarea[@id = 'undesirableWorkingExperience']"));
    public static final GenericElement ADD_COMPETENCE_BUTTON = new GenericElement ("Добавить компетенцию",
            By.xpath("//a[@class = 'editable-mode view-actions edit-mode add-competence']"));
    public static final GenericElement COMMENTS = new GenericElement ("Комментарии", By.xpath("//textarea[@id = 'comment']"));

    //adding competence elements
    public static final GenericElement SEARCHING_COMPETENCE = new GenericElement ("Искомая компетенция", By.id("searchCompetenceWord"));
    public static final GenericElement COMPETENCE1 = new GenericElement ("Обучаемость", By.id("competence_1103"));
    public static final GenericElement COMPETENCE2 = new GenericElement ("MySQL", By.id("competence_196"));
    public static final GenericElement COMPETENCE3 = new GenericElement ("Английский язык", By.id("competence_222"));
    public static final GenericElement OK_BUTTON = new GenericElement ("Кнопка OK", By.cssSelector("div.toolbar-content button:nth-child(2)"));
}
