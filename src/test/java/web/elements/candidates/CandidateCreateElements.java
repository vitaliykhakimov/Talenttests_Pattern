package web.elements.candidates;

import element.GenericElement;
import org.openqa.selenium.By;

public class CandidateCreateElements {
    public static final String URL = "http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile";

    public static final GenericElement SURNAME = new GenericElement("Фамилия", By.xpath("//input[@id = 'surname']"));
    public static final GenericElement NAME = new GenericElement("Имя", By.xpath("//input[@id = 'name']"));
    public static final GenericElement SECONDNAME = new GenericElement("Отчество", By.xpath("//input[@id = 'secondName']"));
    public static final GenericElement TELEPHONE = new GenericElement("Телефон", By.xpath("//input[@id = 'primaryTelephone']"));
    public static final GenericElement EMAIL = new GenericElement("e-mail", By.xpath("//input[@id = 'primaryEmail']"));
    public static final GenericElement SKYPE = new GenericElement("Skype", By.xpath("//input[@id = 'skype']"));
    public static final GenericElement COUNTRY = new GenericElement("Страна", By.xpath("//input[@id = 'country']"));
    public static final GenericElement CITY = new GenericElement("Город", By.xpath("//input[@id = 'city']"));
    public static final GenericElement RELOCATION = new GenericElement("Переезд", By.xpath("//input[@id = 'relocation']"));
    public static final GenericElement DAY_OF_BIRTHADAY = new GenericElement("День рождения", By.xpath("//input[@id = 'dateOfBirthDay']"));
    public static final GenericElement MONTH_OF_BIRTHADAY = new GenericElement("Месяц рождения", By.xpath("//input[@id = 'dateOfBirthMonth']"));
    public static final GenericElement YEAR_OF_BIRTHADAY = new GenericElement("Год рождения", By.xpath("//input[@id = 'dateOfBirthYear']"));
    public static final GenericElement TYPE_EDUCATION_SELECT = new GenericElement("Образование", By.xpath("//select[@id = 'education']"));
    public static final GenericElement DESIRED_POSITION = new GenericElement("Желаемая должность", By.xpath("//input[@id = 'desiredPosition']"));
    public static final GenericElement ADDITIONALLY = new GenericElement("Дополнительно", By.xpath("//textarea[@id = 'additionalInfo']"));

    public static final GenericElement COMPETENCE_TAB = new GenericElement("Вкладка компетенций", By.xpath("//a[@href = '#tab-1']"));
    public static final GenericElement EDUCATION_TAB = new GenericElement("Вкладка образования", By.xpath("//a[@href = '#tab-8']"));
    public static final GenericElement EXPERIENCE_TAB = new GenericElement("Вкладка опыта", By.xpath("//a[@href = '#tab-2']"));
    public static final GenericElement MOTIVATION_TAB = new GenericElement("Вкладка мотивации", By.xpath("//a[@href = '#tab-3']"));
    public static final GenericElement RECOMENRATION_TAB = new GenericElement("Вкладка рекомендаций", By.xpath("//a[@href = '#tab-6']"));

    public static final GenericElement EDIT_COMPETENCE_BUTTON = new GenericElement("Редактировать компетенции", By.xpath("//a[@id = 'editCompetence']"));
    public static final GenericElement SEARCH_FIELD = new GenericElement("Поле поиска", By.xpath("//textarea[@id = 'requestText']"));
    public static final GenericElement SEARCH_BUTTON= new GenericElement("Поиск", By.xpath("//a[@id = 'parseRequestBtn']"));
    public static final GenericElement CLEAR_BUTTON= new GenericElement("Очистить", By.xpath("//a[@id = 'clearRequestBtn']"));
    public static final GenericElement OK_BUTTON= new GenericElement("OK",
            By.xpath("//button[@class = 'btn btn-primary-modal btn-primary-modal-content yui3-widget btn-content btn-focused']"));

    public static final GenericElement ADD_INFO_EDUCATION = new GenericElement("Добавить информацию",
            By.xpath("//span[@id = 'addEducationDetailsButton']//span"));
    public static final GenericElement UNIVERSITY = new GenericElement("Университет", By.xpath("//input[@id = 'university']"));
    public static final GenericElement FACULTY = new GenericElement("Факультет", By.xpath("//input[@id = 'faculty']"));
    public static final GenericElement SPECIALIZATION = new GenericElement("Специальность", By.xpath("//input[@id = 'specialization']"));
    public static final GenericElement EDUCATION_START_YEAR = new GenericElement("Начало обучения",
            By.xpath("//div[@class = 'control-group row-fluid']//select[@id = 'startYear']"));
    public static final GenericElement EDUCATION_END_YEAR = new GenericElement("Конец обучения",
            By.xpath("//div[@class = 'control-group row-fluid']//select[@id = 'endYear']"));

    public static final GenericElement ADD_INFO_EXPERIENCE = new GenericElement("Добавить информацию",
            By.xpath("//span[@id = 'addWorkingExpButton']//span"));
    public static final GenericElement POSITION = new GenericElement("Должность", By.xpath("//input[@id = 'position']"));
    public static final GenericElement COMPANY = new GenericElement("Компания", By.xpath("//input[@id = 'company']"));
    public static final GenericElement WORK_START_MONTH = new GenericElement("Месяц начала",
            By.xpath("//div[@class = 'exp-years-container']//select[@id= 'startMonth']"));
    public static final GenericElement WORK_START_YEAR = new GenericElement("Год начала",
            By.xpath("//div[@class = 'exp-years-container']//select[@id = 'startYear']"));
    public static final GenericElement WORK_END_MONTH = new GenericElement("Месяц окончания",
            By.xpath("//div[@class = 'exp-years-container']//select[@id= 'endMonth']"));
    public static final GenericElement WORK_END_YEAR = new GenericElement("Год окончания",
            By.xpath("//div[@class = 'exp-years-container']//select[@id = 'endYear']"));
    public static final GenericElement DESCRIPTION = new GenericElement("Описание", By.xpath("//textarea[@id = 'description']"));

    public static final GenericElement MOTIVATION_FACTOR_0 = new GenericElement("Материальная заинтересованность",
            By.xpath("//select[@id= 'motivationFactor_0']"));
    public static final GenericElement MOTIVATION_FACTOR_1 = new GenericElement("Стабильность и защищенность",
            By.xpath("//select[@id= 'motivationFactor_1']"));
    public static final GenericElement MOTIVATION_FACTOR_2 = new GenericElement("Условия труда, социальный пакет",
            By.xpath("//select[@id= 'motivationFactor_2']"));
    public static final GenericElement MOTIVATION_FACTOR_3 = new GenericElement("Социальный статус",
            By.xpath("//select[@id= 'motivationFactor_3']"));
    public static final GenericElement MOTIVATION_FACTOR_4 = new GenericElement("Межличностные отношения",
            By.xpath("//select[@id= 'motivationFactor_4']"));
    public static final GenericElement MOTIVATION_FACTOR_5 = new GenericElement("Степень контроля над работой",
            By.xpath("//select[@id= 'motivationFactor_5']"));
    public static final GenericElement MOTIVATION_FACTOR_6 = new GenericElement("Карьерный рост, перспектива",
            By.xpath("//select[@id= 'motivationFactor_6']"));
    public static final GenericElement MOTIVATION_FACTOR_7 = new GenericElement("Наличие высокой ответственности",
            By.xpath("//select[@id= 'motivationFactor_7']"));
    public static final GenericElement MOTIVATION_FACTOR_8 = new GenericElement("Креативность, творческая работа",
            By.xpath("//select[@id= 'motivationFactor_8']"));
    public static final GenericElement MOTIVATION_FACTOR_9 = new GenericElement("Признание",
            By.xpath("//select[@id= 'motivationFactor_9']"));
    public static final GenericElement MOTIVATION_FACTOR_10 = new GenericElement("Обучение, профессиональный рост, развитие",
            By.xpath("//select[@id= 'motivationFactor_10']"));
    public static final GenericElement MOTIVATION_FACTOR_11 = new GenericElement("Достижение результатов, успех",
            By.xpath("//select[@id= 'motivationFactor_11']"));

    public static final GenericElement ADD_RECOMENDATION = new GenericElement("Добавить информацию",
            By.xpath("//span[@id = 'addRecommendationButton']//span"));
    public static final GenericElement REC_NAME = new GenericElement("Имя рекомендатора",
            By.xpath("//input[@id = 'recName']"));
    public static final GenericElement REC_POSITION = new GenericElement("Должность рекомендатора",
            By.xpath("//input[@id = 'recPosition']"));
    public static final GenericElement REC_COMPANY = new GenericElement("Компания рекомендатора",
            By.xpath("//input[@id = 'recCompany']"));
    public static final GenericElement REC_TELEPHONE = new GenericElement("Телефон рекомендатора",
            By.xpath("//input[@id = 'recTelephone']"));

    public static final GenericElement SAVE_BUTTON = new GenericElement("Сохранить",
            By.xpath("//a[@id = 'saveButton']"));
    public static final GenericElement REMOVE_BUTTON = new GenericElement("Удалить",
            By.xpath("//a[@id = 'removeButton']"));
    public static final GenericElement REMOVE_BUTTON2 = new GenericElement("Удалить",
            By.xpath("//div[@class = 'yui3-widget-ft modal-footer']//*[contains(text(), 'Удалить')]"));
    public static final GenericElement EDIT_BUTTON = new GenericElement("Редактировать",
            By.xpath("//a[@id = 'editButton']"));
    public static final GenericElement ERROR_MESSAGE = new GenericElement("Ошибка",
            By.xpath("//div[@class = 'message']//span[@id = 'errorMessage']"));
    public static final GenericElement REMOVE_MESSAGE = new GenericElement("Кандидат успешно удален",
            By.xpath("//div[@class = 'message']//span[@id = 'successMessage']"));
    public static final GenericElement CANCEL_BUTTON = new GenericElement("Отмена",
            By.xpath("//a[@id = 'cancelButton']"));

    public static final GenericElement WRONG_PHONE = new GenericElement("Неверный формат",
            By.xpath("//div[@class = 'validateTelephone']"));
    public static final GenericElement WRONG_EMAIL = new GenericElement("Неверный формат",
            By.xpath("//div[@class = 'email']"));

    public static final GenericElement UPLOAD_IMAGE = new GenericElement("Изображение профиля",
            By.xpath("//input[@id = 'profileImage']"));
    public static final GenericElement UPLOAD_IMAGE_BUTTON = new GenericElement("Изображение профиля",
            By.xpath("//span[@id = 'changeImgLink']"));
    public static final GenericElement WRONG_IMAGE_FORMAT = new GenericElement("Неверный формат",
            By.xpath("//div[@class = 'message']//span[@id = 'errorMessage']"));
    public static final GenericElement CURRENT_IMAGE = new GenericElement("Текущее изображения профиля",
            By.id("currentImage"));
    public static final GenericElement UPLOAD_CV = new GenericElement("Загрузить резюме",
            By.xpath("//input[@id = 'profileCVInput']"));
    public static final GenericElement ADD_ATTACHMENT = new GenericElement("Прикрепить файл",
            By.xpath("//label[@id = 'add-attachment']//i[@class =  'fa fa-plus add-attachment']"));
    public static final GenericElement ADDED_ATTACHMENT = new GenericElement("Прикрепленный файл",
            By.xpath("//div[@class = 'control-group']//span[@class = 'link']"));
}
