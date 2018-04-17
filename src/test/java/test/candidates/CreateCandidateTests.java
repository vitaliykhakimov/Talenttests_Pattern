package test.candidates;

import driver.WebDriverSingleton;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import web.elements.candidates.CandidateCreateElements;
import web.page.login.LoginPage;
import web.page.candidates.CandidateCreatePage;

public class CreateCandidateTests {

    WebDriver driver = WebDriverSingleton.getInstance();
    private LoginPage lp = new LoginPage();
    private CandidateCreatePage ccp = new CandidateCreatePage();
    private final String NO_AVATAR = "http://testing.cld.iba.by/TC-RecruitingAndOnboarding-portlet/common/css/images/no-avatar.jpg";

    @Step("Логинимся в систему")
    private void login(){
        lp.enterLoginPage();
        lp.typeUsername("kabanov@tc.by");
        lp.typePassword("welcome");
        lp.clickLoginButton();
    }

    @Test
    @DisplayName("Создание кандидата (все поля заполнены)")
    @Description("Создание с заполнением всех полей")
    @Feature("Кандидаты")
    @Story("Сценарий - Кандидат успешно создался")
    @Severity(SeverityLevel.BLOCKER)
    public void createCandidate() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeInformationFull();
        ccp.clickSaveButton();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().equals("Иванов Иван Иванович - Конструктор Талантов"));
    }

    @Test
    @DisplayName("Создание кандидата (только обязательные поля)")
    @Description("Создание с заполнением только обязательных полей")
    @Feature("Кандидаты")
    @Story("Сценарий - Кандидат успешно создался")
    @Severity(SeverityLevel.BLOCKER)
    public void createCandidateOnlyRequiredFields() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeSurname("Иванов");
        ccp.typeName("Иван");
        ccp.typeSecondname("Иванович");
        ccp.typeTelephone("80334442231");
        ccp.typeEmail("vanka@mail.ru");
        ccp.clickSaveButton();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().equals("Иванов Иван Иванович - Конструктор Талантов"));
    }

    @Test
    @DisplayName("Создание существующего кандидата")
    @Description("Создаем кандидата, после чего создаем такого же")
    @Feature("Кандидаты")
    @Story("Сценарий - Создание кандидата не удалось")
    @Severity(SeverityLevel.CRITICAL)
    public void createPresentCandidate() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeSurname("Иванов");
        ccp.typeName("Иван");
        ccp.typeSecondname("Иванович");
        ccp.typeTelephone("80334442232");
        ccp.typeEmail("vanyaa@mail.ru");
        ccp.clickSaveButton();
        Thread.sleep(3000);

        ccp.goToCandidateCreatePage();
        ccp.typeSurname("Иванов");
        ccp.typeName("Иван");
        ccp.typeSecondname("Иванович");
        ccp.typeTelephone("80334442232");
        ccp.typeEmail("vanyaa@mail.ru");
        ccp.clickSaveButton();
        Assert.assertTrue(CandidateCreateElements.ERROR_MESSAGE.isElementPresent());
    }

    @Test
    @DisplayName("Создание кандидата с неверным телефоном и email")
    @Description("Создаем кандидата, вводим некорректный телефон и email")
    @Feature("Кандидаты")
    @Story("Сценарий - Создание кандидата не удалось")
    @Severity(SeverityLevel.CRITICAL)
    public void createCandidateWithWrongPhoneAndEmail() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeSurname("Иванов");
        ccp.typeName("Иван");
        ccp.typeSecondname("Иванович");
        ccp.typeTelephone("wqwadsd");
        ccp.typeEmail("sdaas");
        ccp.clickSaveButton();
        Assert.assertTrue(CandidateCreateElements.WRONG_PHONE.isElementPresent());
        Assert.assertTrue(CandidateCreateElements.WRONG_EMAIL.isElementPresent());
    }

    @Test
    @DisplayName("Удаление кандидата")
    @Description("Создаем кандидата, после чего удаляем его")
    @Feature("Кандидаты")
    @Story("Сценарий - Удаление и редактирование кандидата")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteCandidate() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeSurname("Иванов");
        ccp.typeName("Иван");
        ccp.typeSecondname("Иванович");
        ccp.typeTelephone("80334442234");
        ccp.typeEmail("vanya777@mail.ru");
        ccp.clickSaveButton();
        Thread.sleep(1000);
        ccp.clickRemoveButtons();
        Thread.sleep(2000);
        Assert.assertTrue(CandidateCreateElements.REMOVE_MESSAGE.isElementPresent());
    }

    @Test
    @DisplayName("Редактирование кандидата")
    @Description("Создаем кандидата, после чего нажимаем кнопку Редактировать и возвращаемся на страницу создания")
    @Feature("Кандидаты")
    @Story("Сценарий - Удаление и редактирование кандидата")
    @Severity(SeverityLevel.CRITICAL)
    public void editCandidate() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeSurname("Иванов");
        ccp.typeName("Иван");
        ccp.typeSecondname("Иванович");
        ccp.typeTelephone("80334442235");
        ccp.typeEmail("vanya888@mail.ru");
        ccp.clickSaveButton();
        Thread.sleep(1000);
        ccp.clickEditButton();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().equals("Иванов Иван Иванович - Конструктор Талантов"));
    }

    @Test
    @DisplayName("Отмена создания кандидата")
    @Description("Заходим на страницу создания кандидата, жмём кнопку Отмена")
    @Feature("Кандидаты")
    @Story("Сценарий - Отмена создания кандидата")
    @Severity(SeverityLevel.NORMAL)
    public void cancelCreatingCandidate() {
        login();
        ccp.goToCandidateCreatePage();
        ccp.clickCancelButton();
        Assert.assertTrue(driver.getTitle().equals("Кандидаты - Конструктор Талантов"));
    }

    @Test
    @DisplayName("Загрузка резюме кандидата")
    @Description("При созданиии кандидата загружаем резюме из файла")
    @Feature("Кандидаты")
    @Story("Сценарий - Загрузка резюме прошла успешно")
    @Severity(SeverityLevel.CRITICAL)
    public void uploadCVusingSeleniumCorrect() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.uploadFileWithSelenium("resume2.doc");
        Thread.sleep(2000);
        Assert.assertEquals( "Виталик", CandidateCreateElements.NAME.getWebElement().getAttribute("value"));
        Assert.assertEquals( "Хакимов", CandidateCreateElements.SURNAME.getWebElement().getAttribute("value"));
        Assert.assertEquals( "+375257090766", CandidateCreateElements.TELEPHONE.getWebElement().getAttribute("value"));
        Assert.assertEquals( "Беларусь", CandidateCreateElements.COUNTRY.getWebElement().getAttribute("value"));
        Assert.assertEquals( "Минск", CandidateCreateElements.CITY.getWebElement().getAttribute("value"));
        Assert.assertEquals( "18", CandidateCreateElements.DAY_OF_BIRTHADAY.getWebElement().getAttribute("value"));
        Assert.assertEquals( "1", CandidateCreateElements.MONTH_OF_BIRTHADAY.getWebElement().getAttribute("value"));
        Assert.assertEquals( "1996", CandidateCreateElements.YEAR_OF_BIRTHADAY.getWebElement().getAttribute("value"));
    }

    @Test
    @DisplayName("Загрузка резюме кандидата")
    @Description("При созданиии кандидата загружаем резюме из файла")
    @Feature("Кандидаты")
    @Story("Сценарий - Загрузка резюме провалилась")
    @Severity(SeverityLevel.CRITICAL)
    public void uploadCVusingSeleniumIncorrect() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.uploadFileWithSelenium("resume.doc");
        Thread.sleep(2000);
        Assert.assertEquals( "Виталик", CandidateCreateElements.NAME.getWebElement().getAttribute("value"));
        Assert.assertEquals( "Хакимов", CandidateCreateElements.SURNAME.getWebElement().getAttribute("value"));
        Assert.assertEquals( "+375257090766", CandidateCreateElements.TELEPHONE.getWebElement().getAttribute("value"));
        Assert.assertEquals( "Беларусь", CandidateCreateElements.COUNTRY.getWebElement().getAttribute("value"));
        Assert.assertEquals( "Минск", CandidateCreateElements.CITY.getWebElement().getAttribute("value"));
        Assert.assertEquals( "18", CandidateCreateElements.DAY_OF_BIRTHADAY.getWebElement().getAttribute("value"));
        Assert.assertEquals( "1", CandidateCreateElements.MONTH_OF_BIRTHADAY.getWebElement().getAttribute("value"));
        Assert.assertEquals( "1996", CandidateCreateElements.YEAR_OF_BIRTHADAY.getWebElement().getAttribute("value"));
    }

    @Test
    @DisplayName("Загрузка фотографии кандидата")
    @Description("При созданиии кандидата загружаем фото")
    @Feature("Кандидаты")
    @Story("Сценарий - Загрузка фото прошла успешно")
    @Severity(SeverityLevel.CRITICAL)
    public void uploadImageUsingSikuliCorrect() throws FindFailed, InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.uploadFileWithSikuli("human.png");
        Thread.sleep(2000);
        Assert.assertNotEquals(CandidateCreateElements.CURRENT_IMAGE.getWebElement().getAttribute("src"), NO_AVATAR);
    }

    @Test
    @DisplayName("Загрузка фотографии кандидата")
    @Description("При созданиии кандидата загружаем файл с неверным форматом")
    @Feature("Кандидаты")
    @Story("Сценарий - Загрузка фото провалилась")
    @Severity(SeverityLevel.CRITICAL)
    public void uploadImageUsingSikuliIncorrect() throws FindFailed, InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.uploadFileWithSikuli("resume.doc");
        Thread.sleep(2000);
        Assert.assertTrue(CandidateCreateElements.WRONG_IMAGE_FORMAT.getWebElement().getText()
                .equals("Выберите изображение (jpeg, jpg, png, gif, bmp)"));
    }

    @Test
    @DisplayName("Прикрепление документа")
    @Description("При созданиии кандидата прикрепляем документ")
    @Feature("Кандидаты")
    @Story("Сценарий - Документ прикреплен")
    @Severity(SeverityLevel.CRITICAL)
    public void uploadFileUsingRobot() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.uploadFileWithRobot("resume2.doc");
        Thread.sleep(2000);
        Assert.assertTrue(CandidateCreateElements.ADDED_ATTACHMENT.getWebElement().getText().equals("resume2.doc"));
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
