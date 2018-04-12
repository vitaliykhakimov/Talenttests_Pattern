package web.page.candidates;

import driver.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import web.elements.candidates.CandidateCreateElements;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CandidateCreatePage {
    WebDriver driver = WebDriverSingleton.getInstance();

    private final int NOT_IMPORTANT_EDUCATION = 0;
    private final int AVERAGE_EDUCATION = 1;
    private final int TECHNICAL_EDUCATION = 2;
    private final int SPECIALIZED_EDUCATION = 3;
    private final int HIGHER_EDUCATION = 4;
    private final int INCOMPLETE_HIGHER_EDUCATION = 5;

    private final int JANUARY = 0;
    private final int FEBRUARY = 1;
    private final int MARCH = 2;
    private final int APRIL = 3;
    private final int MAY = 4;
    private final int JUNE = 5;
    private final int JULY = 6;
    private final int AUGUST = 7;
    private final int SEPTEMBER = 8;
    private final int OCTOBER = 9;
    private final int NOVEMBER = 10;
    private final int DECEBMER = 11;

    private final int NOT_SELECTED = 0;
    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int FIVE = 5;

    @Step("Переход на страницу создания кандидата")
    public void goToCandidateCreatePage() {
        driver.get(CandidateCreateElements.URL);
    }

    @Step("Ввод фамилии")
    public void typeSurname(String surname) {
        CandidateCreateElements.SURNAME.sendKeys(surname);
    }

    @Step("Ввод имени")
    public void typeName(String name) {
        CandidateCreateElements.NAME.sendKeys(name);
    }

    @Step("Ввод отчества")
    public void typeSecondname(String secondname) {
        CandidateCreateElements.SECONDNAME.sendKeys(secondname);
    }

    @Step("Ввод телефона")
    public void typeTelephone(String phone) {
        CandidateCreateElements.TELEPHONE.sendKeys(phone);
    }

    @Step("Ввод email")
    public void typeEmail(String email) {
        CandidateCreateElements.EMAIL.sendKeys(email);
    }

    @Step("Ввод skype")
    public void typeSkype(String skype) {
        CandidateCreateElements.SKYPE.sendKeys(skype);
    }

    @Step("Ввод страны")
    public void typeCountry(String country) {
        CandidateCreateElements.COUNTRY.sendKeys(country);
    }

    @Step("Ввод города")
    public void typeCity(String city) {
        CandidateCreateElements.CITY.sendKeys(city);
    }

    @Step("Кликаем кнопку возможности переезда")
    public void clickRelocationButton() {
        CandidateCreateElements.RELOCATION.click();
    }

    @Step("Ввод даты рождения")
    public void typeBirthdayDate(String day, String month, String year) {
        CandidateCreateElements.DAY_OF_BIRTHADAY.sendKeys(day);
        CandidateCreateElements.MONTH_OF_BIRTHADAY.sendKeys(month);
        CandidateCreateElements.YEAR_OF_BIRTHADAY.sendKeys(year);
    }

    @Step("Выбор образования")
    public void selectEducation(int index) {
        Select select = new Select(CandidateCreateElements.TYPE_EDUCATION_SELECT.getWebElement());
        select.selectByIndex(index);
    }

    @Step("Ввод желаемой должности")
    public void typeDesiredPosition(String position) {
        CandidateCreateElements.DESIRED_POSITION.sendKeys(position);
    }

    @Step("Ввод дополнительной информации")
    public void typeAdditionally(String add) {
        CandidateCreateElements.ADDITIONALLY.sendKeys(add);
    }

    @Step("Ввод информации об образовании")
    public void typeInfoAboatEducation(String univer, String faculty, String spec, String startyear, String endyear) {
        CandidateCreateElements.EDUCATION_TAB.click();
        CandidateCreateElements.ADD_INFO_EDUCATION.click();
        CandidateCreateElements.UNIVERSITY.sendKeys(univer);
        CandidateCreateElements.FACULTY.sendKeys(faculty);
        CandidateCreateElements.SPECIALIZATION.sendKeys(spec);

        Select startYearSelect = new Select(CandidateCreateElements.EDUCATION_START_YEAR.getWebElement());
        startYearSelect.selectByValue(startyear);
        Select endYearSelect = new Select(CandidateCreateElements.EDUCATION_END_YEAR.getWebElement());
        endYearSelect.selectByValue(endyear);
    }

    @Step("Ввод информации об опыте работы")
    public void typeInfoAboutExperience(String pos, String comp, int monthStart, String yearStart, int monthEnd, String yearEnd, String descr) {
        CandidateCreateElements.EXPERIENCE_TAB.click();
        CandidateCreateElements.ADD_INFO_EXPERIENCE.click();
        CandidateCreateElements.POSITION.sendKeys(pos);
        CandidateCreateElements.COMPANY.sendKeys(comp);
        Select selectStartMonth = new Select(CandidateCreateElements.WORK_START_MONTH.getWebElement());
        selectStartMonth.selectByIndex(monthStart);
        Select selectStartYear = new Select(CandidateCreateElements.WORK_START_YEAR.getWebElement());
        selectStartYear.selectByValue(yearStart);
        Select selectEndMonth = new Select(CandidateCreateElements.WORK_END_MONTH.getWebElement());
        selectEndMonth.selectByIndex(monthEnd);
        Select selectEndYear = new Select(CandidateCreateElements.WORK_END_YEAR.getWebElement());
        selectEndYear.selectByValue(yearEnd);
        CandidateCreateElements.DESCRIPTION.sendKeys(descr);
    }

    @Step("Выбор мотивационных факторов")
    public void selectMotivationFactors(int index_0, int index_1, int index_2, int index_3, int index_4, int index_5, int index_6, int index_7,
                                        int index_8, int index_9, int index_10, int index_11) throws InterruptedException {
        CandidateCreateElements.MOTIVATION_TAB.click();
        Select selectFactor0 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_0.getWebElement());
        selectFactor0.selectByIndex(index_0);
        Select selectFactor1 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_1.getWebElement());
        selectFactor1.selectByIndex(index_1);
        Select selectFactor2 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_2.getWebElement());
        selectFactor2.selectByIndex(index_2);
        Select selectFactor3 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_3.getWebElement());
        selectFactor3.selectByIndex(index_3);
        Select selectFactor4 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_4.getWebElement());
        selectFactor4.selectByIndex(index_4);
        Select selectFactor5 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_5.getWebElement());
        selectFactor5.selectByIndex(index_5);
        Select selectFactor6 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_6.getWebElement());
        selectFactor6.selectByIndex(index_6);
        Select selectFactor7 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_7.getWebElement());
        selectFactor7.selectByIndex(index_7);
        Select selectFactor8 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_8.getWebElement());
        selectFactor8.selectByIndex(index_8);
        Select selectFactor9 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_9.getWebElement());
        selectFactor9.selectByIndex(index_9);
        Select selectFactor10 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_10.getWebElement());
        selectFactor10.selectByIndex(index_10);
        Select selectFactor11 = new Select(CandidateCreateElements.MOTIVATION_FACTOR_11.getWebElement());
        selectFactor11.selectByIndex(index_11);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_UP).perform();
    }

    @Step("Ввод рекомендаций")
    public void typeRecInformation(String name, String position, String company, String phone) {
        CandidateCreateElements.RECOMENRATION_TAB.click();
        CandidateCreateElements.ADD_RECOMENDATION.click();
        CandidateCreateElements.REC_NAME.sendKeys(name);
        CandidateCreateElements.REC_POSITION.sendKeys(position);
        CandidateCreateElements.REC_COMPANY.sendKeys(company);
        CandidateCreateElements.REC_TELEPHONE.sendKeys(phone);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_UP).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_UP).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_UP).perform();
    }

    @Step("Ввод компетенций")
    public void typeCompetence() throws InterruptedException {
        CandidateCreateElements.EDIT_COMPETENCE_BUTTON.click();
        Thread.sleep(2000);
        CandidateCreateElements.SEARCH_FIELD.click();
        Thread.sleep(1000);
        CandidateCreateElements.SEARCH_FIELD.sendKeys("Обучаемость");
        Thread.sleep(1000);
        CandidateCreateElements.SEARCH_BUTTON.click();
        Thread.sleep(2000);
        CandidateCreateElements.OK_BUTTON.click();
    }

    @Step("Кликаем кнопку Сохранить")
    public void clickSaveButton() throws InterruptedException {
        Thread.sleep(2000);
        CandidateCreateElements.SAVE_BUTTON.click();
    }

    @Step("Кликаем кнопку удалить")
    public void clickRemoveButtons() throws InterruptedException {
        CandidateCreateElements.REMOVE_BUTTON.click();
        Thread.sleep(2000);
        CandidateCreateElements.REMOVE_BUTTON2.click();
    }

    @Step("Получение пути к файлу")
    public String getAbsolutePath(String file) {
        Path path = Paths.get(file);
        return path.toAbsolutePath().toString();
    }

    @Step("Загружаем файл с помощью Selenium")
    public void uploadFileWithSelenium(String fName) {
        CandidateCreateElements.UPLOAD_CV.sendKeys(getAbsolutePath("resources/" + fName + ""));
    }

    @Step("Загружаем файл с помощью Sikuli")
    public void uploadFileWithSikuli(String imgName) throws InterruptedException, FindFailed {
        Pattern filePath = new Pattern("resources/sikuli/FilePath.JPG");
        Pattern openButton = new Pattern("resources/sikuli/OpenButton.JPG");
        CandidateCreateElements.UPLOAD_IMAGE_BUTTON.click();

        Screen screen = new Screen();
        screen.wait(filePath, 20);
        screen.type(filePath, getAbsolutePath("resources/" + imgName + ""));
        screen.click(openButton);
    }

    @Step("Загружаем файл с помощью Robot")
    public void uploadFileWithRobot(String fName) {
        CandidateCreateElements.ADD_ATTACHMENT.click();
        sendFile(getAbsolutePath("resources/" + fName + ""));
    }

    @Step("Копируем путь к файлу и вставляем в поле путь к файлу")
    private void sendFile(String path) {
        try{
            setClipboardData(path);
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Step("Выбираем строку для копирования")
    private void setClipboardData(String str) {
        StringSelection strSelection = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
    }

    @Step("Кликаем кнопку Редактировать")
    public void clickEditButton() {
        CandidateCreateElements.EDIT_BUTTON.click();
    }

    @Step("Кликаем кнопку отмены")
    public void clickCancelButton() {
        CandidateCreateElements.CANCEL_BUTTON.click();
    }

    @Step("Ввод всей инфорации о кандидатах")
    public void typeInformationFull() throws InterruptedException {
        typeSurname("Иванов");
        typeName("Иван");
        typeSecondname("Иванович");
        typeTelephone("80291234567");
        typeEmail("vanya@mail.ru");
        typeSkype("ivanov_ivan");
        typeCountry("Беларусь");
        typeCity("Минск");
        clickRelocationButton();
        typeBirthdayDate("18", "01", "1996");
        selectEducation(HIGHER_EDUCATION);
        typeDesiredPosition("QA engineer");
        typeAdditionally("Очень ответственный");
        //typeCompetence(); Не стал добавлять компетенции, так как драйвер не может нажать кнопку ОК, не смог решить эту проблему
        typeInfoAboatEducation("БГУИР", "КСИС", "Инженер-программист", "2015", "2019");
        typeInfoAboutExperience("Программист Java", "EPAM", MARCH, "2013", MARCH, "2018", "Писал Java код");
        //selectMotivationFactors(TWO, THREE, FIVE, FOUR, NOT_SELECTED, THREE, ONE, ONE, TWO, THREE, FIVE, NOT_SELECTED);
        typeRecInformation("Сидоров Максим Иванович", "Team lead", "EPAM", "222-32-32");
    }

}
