package web.elements.appcreate;

import org.openqa.selenium.By;

public class RequirmentsToCandidateElements {
    public static By CANDIDATE_TYPE = By.xpath("//div[@class = 'controls col-xs-12 col-md-8 col-lg-8']" +
            "//div[@class = 'checkbox checkbox-recruiting checkbox-inline col-lg-4 col-md-4 col-sm-4 col-xs-4 text-lowercase']" +
            "//input");
    public static By EDUCATION = By.xpath("//select[@id = 'education']");
    public static By EDUCATION_SPECIALIZATION = By.xpath("//textarea[@id = 'educationSpecialization']");
    public static By EXPIRIENCE = By.xpath("//select[@id = 'experience']");
    public static By PRIORITY_WORK_EXPIRIENCE = By.xpath("//textarea[@id = 'priority.working.experience']");
    public static By UNWANTED_WORK_EXPIRIENCE = By.xpath("//textarea[@id = 'undesirableWorkingExperience']");
    public static By ADD_COMPETENCE_BUTTON = By.xpath("//a[@class = 'editable-mode view-actions edit-mode add-competence']");
    public static By COMMENTS = By.xpath("//textarea[@id = 'comment']");

    //adding competence elements
    public static By SEARCHING_COMPETENCE = By.id("searchCompetenceWord");
    public static By COMPETENCE1 = By.id("competence_1103");
    public static By COMPETENCE2 = By.id("competence_196");
    public static By COMPETENCE3 = By.id("competence_222");
    public static By OK_BUTTON = By.cssSelector("div.toolbar-content button:nth-child(2)");
}
