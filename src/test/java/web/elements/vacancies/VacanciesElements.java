package web.elements.vacancies;

import element.GenericElement;
import org.openqa.selenium.By;

public class VacanciesElements {
    public static final GenericElement CREATE_VACANCY_BUTTON = new GenericElement("Создать вакансию",
            By.xpath("//a[@id = 'createVacancyButton']"));
    public static final GenericElement SAVE_BUTTON = new GenericElement("Сохранить",
            By.xpath("//a[@id = 'saveButton']"));
    public static final GenericElement OPEN_VACANCY_BUTTON = new GenericElement("Открыть вакансию",
            By.xpath("//a[@id = 'openButton']"));
    public static final GenericElement SUCCESS_OPENED = new GenericElement("Успешно открыта",
            By.xpath("//div[@class = 'message']//span[@id = 'successMessage']"));
    public static final GenericElement SEARCH_VACANCY = new GenericElement("Поиск вакансии",
            By.xpath("//input[@id = 'searchVacancyInput']"));
    public static final GenericElement VACANCY = new GenericElement("Вакансия",
            By.xpath("//a[@href = 'http://testing.cld.iba.by/web/guest/recruiting/vacancies/-/vacancies/51']"));
    public static final GenericElement CANDIDATES_TAB = new GenericElement("Кандидаты",
            By.xpath("//a[@href = '#candidates']"));
    public static final GenericElement ADD_CANDIDATE_BUTTON = new GenericElement("Добавить киндадита",
            By.xpath("//button[@id = 'addCandidateForShortlistButton']"));
    public static final GenericElement SEARCH_CANDIDATE_FOR_SHORTLIST = new GenericElement("Поиск",
            By.xpath("//input[@id = 'searchCandidateForShortlist']"));
    public static final GenericElement CANDIDATE = new GenericElement("Кандидат",
            By.xpath("//input[@id = '642']"));
    public static final GenericElement OK_BUTTON = new GenericElement("Добавить",
            By.xpath("//button[@id = 'btn-ok']"));

    public static final GenericElement INTERVIEW_PLAN_TAB = new GenericElement("План интервью",
            By.xpath("//a[@href = '#interviewPlan']"));
    public static final GenericElement ADD_QUESTION_BUTTON = new GenericElement("Добавить вопрос",
            By.xpath("//a[@id = 'addQuestionButton']"));
    public static final GenericElement QUESTION_FIELD = new GenericElement("Текст вопроса",
            By.xpath("//textarea[@id = 'questionText']"));
    public static final GenericElement ANSWER_FIELD = new GenericElement("Текст ответа",
            By.xpath("//textarea[@id = 'questionAnswer']"));
    public static final GenericElement COMPETENCE_FIELD = new GenericElement("Компетенция",
            By.xpath("//input[@class = 'ui-widget-content ui-autocomplete-input']"));
    public static final GenericElement SAVE_QUESTION_BUTTON = new GenericElement("Сохранить",
            By.xpath("//a[@id = 'saveQuestionButton']"));
    public static final GenericElement PERSONAL_QUESTIONS_TAB = new GenericElement("Персональные вопросы",
            By.xpath("//li[@id = 'personalTab']"));
    public static final GenericElement ADD_QUESTION_BTN = new GenericElement("Добавить",
            By.xpath("//a[@id = 'addBtn']"));
}
