package web.elements.candidates;

import element.GenericElement;
import org.openqa.selenium.By;

public class CandidatesElements {
    public static final String URL = "http://testing.cld.iba.by/web/guest/recruiting/candidates";
    public static final GenericElement SEARCH_FIELD = new GenericElement( "Поиск",
            By.xpath("//div[@class = 'search-row row-fluid col-xs-12']//div[@class = 'overflow-auto search']//input[@id = 'searchInput']"));
    public static final GenericElement FOUNDED_CANDIDATE = new GenericElement("Искомый кандидат",
            By.xpath("//div[@class = 'inside-table ']//span[@class = 'fio']"));
    public static final GenericElement CANDIDATE_NOT_FOUND_MESSAGE = new GenericElement("Кандидат не найдет", By.xpath("//tc-alert[@class = 'empty-search']" +
            "//div[@class = 'inner']//div[@class = 'message']"));

    public static final GenericElement EXPERIENCE_FILTER = new GenericElement("Фильтр по опыту работы", By.xpath("//select[@id = 'experience']"));
    public static final GenericElement EXPERIENCE_TAG = new GenericElement("Тег фильтра по опыту работы",
            By.xpath("//div[@id = 'experience_filter-tag']//span"));

    public static final GenericElement STATUS_NEW_TAG = new GenericElement("Тег", By.xpath("//div[@id = 'status_New-tag']//span"));
    public static final GenericElement STATUS_NEW_FILTER = new GenericElement("Фильтр по статусу",
            By.xpath("//div[@class = 'checkbox checkbox-primary']//input[@id='status_New']"));
    public static final GenericElement STATUS_APPROVAL_TAG = new GenericElement("Тег",
            By.xpath("//div[@id = 'status_OnApprovalForTheVacancy-tag']//span"));
    public static final GenericElement STATUS_APPROVAL_FILTER = new GenericElement("Фильтр по статусу",
            By.xpath("//div[@class = 'checkbox checkbox-primary']//input[@id='status_OnApprovalForTheVacancy']"));
    public static final GenericElement STATUS_AVAILABLE_TAG = new GenericElement("Тег", By.xpath("//div[@id = 'status_AvailableForApproval-tag']//span"));
    public static final GenericElement STATUS_AVAILABLE_FILTER = new GenericElement("Фильтр по статусу",
            By.xpath("//div[@class = 'checkbox checkbox-primary']//input[@id='status_AvailableForApproval']"));
    public static final GenericElement STATUS_HIRED_TAG = new GenericElement("Тег", By.xpath("//div[@id = 'status_Hired-tag']//span"));
    public static final GenericElement STATUS_HIRED_FILTER = new GenericElement("Фильтр по статусу",
            By.xpath("//div[@class = 'checkbox checkbox-primary']//input[@id='status_Hired']"));

    public static final GenericElement SELECT_BUTTONS_CLOSED = new GenericElement("Кнопка выбора",
            By.xpath("//div[@class = 'btn-group']//button[@class = 'multiselect dropdown-toggle btn btn-default']"));
    public static final GenericElement SELECT_BUTTONS_OPEN = new GenericElement("Кнопка выбора",
            By.xpath("//div[@class = 'btn-group open']//button[@class = 'multiselect dropdown-toggle btn btn-default']"));

    public static final GenericElement SELECT_VACANCY_CHECKBOX = new GenericElement("Дизайнер",
            By.xpath("//div[@class = 'checkbox checkbox-primary  ']//input[@id= 'vacancy_filtermultiselect-0']"));
    public static final GenericElement VACANCY_FILTER_TAG = new GenericElement("Тег", By.xpath("//div[@id = 'vacancy_filter-tag']//span"));

    public static final GenericElement SELECT_EDUCATION_CHECKBOX = new GenericElement("Не указано",
            By.xpath("//div[@class = 'checkbox checkbox-primary  ']//input[@id= 'education_filtermultiselect-0']"));
    public static final GenericElement EDUCATION_FILTER_TAG = new GenericElement("Тег", By.xpath("//div[@id = 'education_filter-tag']//span"));

    public static final GenericElement SELECT_UNIVERSITY_CHECKBOX = new GenericElement("БГУ",
            By.xpath("//div[@class = 'checkbox checkbox-primary  ']//input[@id= 'universities_filtermultiselect-0']"));
    public static final GenericElement UNIVERSITY_FILTER_TAG = new GenericElement("Тег", By.xpath("//div[@id = 'universities_filter-tag']//span"));

    public static final GenericElement SELECT_COMPETENCE_CHECKBOX = new GenericElement("Английский язык",
            By.xpath("//div[@class = 'checkbox checkbox-primary  ']//input[@id= 'competencies_filtermultiselect-1']"));
    public static final GenericElement COMPETENCE_FILTER_TAG = new GenericElement("Тег", By.xpath("//div[@id = 'competencies_filter-tag']//span"));

    public static final GenericElement RELOCATION_SELECT = new GenericElement("Переезд", By.xpath("//div[@id = 'relocation_filter']//input"));
    public static final GenericElement RELOCATION_AVAILABLE_FILTER_TAG = new GenericElement("Тег",
            By.xpath("//div[@id = 'relocation_Available-tag']//span"));
    public static final GenericElement RELOCATION_UNAVAILABLE_FILTER_TAG = new GenericElement("Тег",
            By.xpath("//div[@id = 'relocation_Unavailable-tag']//span"));

    public static final GenericElement CREATE_CANDIDATE_BUTTON = new GenericElement("Создать кандидата", By.xpath("//a[@id = 'createProfileButton']"));
    public static final GenericElement PAGINATION = new GenericElement("Нумерация страниц", By.xpath("//div[@id = 'pagination']"));

    public static final GenericElement INVITE_FOR_INTERVIEW_BTN = new GenericElement("Пригласить на интервью",
            By.xpath("//a[@id = 'inviteForTheInterview']"));
    public static final GenericElement CREATE_INTERVIEW_DATE = new GenericElement("Создать",
            By.xpath("//button[@id = 'createBtn']"));
    public static final GenericElement INTERVIEWER = new GenericElement("Интервьюер",
            By.xpath("//div[@class = 'controls form-gorup']//input[@id = 'searchInput']"));
    public static final GenericElement DATE = new GenericElement("Дата",
            By.xpath("//div[@class = 'controls form-gorup']//input[@id = 'dateInput']"));
    public static final GenericElement TIMEPICKER_START = new GenericElement("Время начала",
            By.xpath("//div[@class = 'controls form-gorup']//input[@id = 'timepicker-start']"));
    public static final GenericElement TIMEPICKER_END = new GenericElement("Время окончания",
            By.xpath("//div[@class = 'controls form-gorup']//input[@id = 'timepicker-end']"));
    public static final GenericElement SAVE_BUTTON = new GenericElement("Сохранить",
            By.xpath("//button[contains(text(), 'Сохранить')]"));
    public static final GenericElement PASSED_INTERVIEW_BUTTON = new GenericElement("Прошел интервью",
            By.xpath("//a[@id = 'changeStatus_PassedTheInterview']"));
    public static final GenericElement OFFERED_A_JOB_BUTTON = new GenericElement("Пригласить на работу",
            By.xpath("//a[@id = 'changeStatus_OfferedAJob']"));
    public static final GenericElement OFFERED_JOB_STATUS = new GenericElement("Приглашен на работу",
            By.xpath("//span[@id = 'statusForVacancyLabel']"));
}
