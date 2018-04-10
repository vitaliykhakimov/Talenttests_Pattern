package test.candidates;

import driver.WebDriverSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import web.elements.candidates.CandidateCreateElements;
import web.page.LoginPage;
import web.page.candidates.CandidateCreatePage;

import org.sikuli.script.Pattern;

public class CreateCandidateTests {

    WebDriver driver = WebDriverSingleton.getInstance();
    private LoginPage lp = new LoginPage();
    private CandidateCreatePage ccp = new CandidateCreatePage();
    private final String NO_AVATAR = "http://testing.cld.iba.by/TC-RecruitingAndOnboarding-portlet/common/css/images/no-avatar.jpg";

    private void login(){
        lp.enterLoginPage();
        lp.typeUsername("kabanov@tc.by");
        lp.typePassword("welcome");
        lp.clickLoginButton();
    }

    //Тест заполнения всех полей
    @Test
    public void createCandidate() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeInformationFull();
        ccp.clickSaveButton();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().equals("Иванов Иван Иванович - Конструктор Талантов"));
    }

    //Тест заполнения только обязательных полей
    @Test
    public void createCandidateOnlyRequiredFields() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeSurname("Иванов");
        ccp.typeName("Иван");
        ccp.typeSecondname("Иванович");
        ccp.typeTelephone("80334442233");
        ccp.typeEmail("vanya@mail.ru");
        ccp.clickSaveButton();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().equals("Иванов Иван Иванович - Конструктор Талантов"));
    }

    //тест на создание кандидата с существующим телефоном и электронной почтой
    @Test
    public void createPresentCandidate() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeSurname("Иванов");
        ccp.typeName("Иван");
        ccp.typeSecondname("Иванович");
        ccp.typeTelephone("80334442233");
        ccp.typeEmail("vanya@mail.ru");
        ccp.clickSaveButton();
        Thread.sleep(3000);

        ccp.goToCandidateCreatePage();
        ccp.typeSurname("Иванов");
        ccp.typeName("Иван");
        ccp.typeSecondname("Иванович");
        ccp.typeTelephone("80334442233");
        ccp.typeEmail("vanya@mail.ru");
        ccp.clickSaveButton();
        Assert.assertTrue(CandidateCreateElements.ERROR_MESSAGE.isElementPresent());
    }

    //тест на ввод некорректных данных в поле Email и телефон
    @Test
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

    //Тест на удаление только что созданного кандидата
    @Test
    public void deleteCandidate() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeSurname("Иванов");
        ccp.typeName("Иван");
        ccp.typeSecondname("Иванович");
        ccp.typeTelephone("80334442233");
        ccp.typeEmail("vanya@mail.ru");
        ccp.clickSaveButton();
        Thread.sleep(1000);
        ccp.clickRemoveButtons();
        Thread.sleep(2000);
        Assert.assertTrue(CandidateCreateElements.REMOVE_MESSAGE.isElementPresent());
    }

    //Тест на редактирование только что созданного кандидата
    @Test
    public void editCandidate() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeSurname("Иванов");
        ccp.typeName("Иван");
        ccp.typeSecondname("Иванович");
        ccp.typeTelephone("80334442233");
        ccp.typeEmail("vanya@mail.ru");
        ccp.clickSaveButton();
        Thread.sleep(1000);
        ccp.clickEditButton();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().equals("Иванов Иван Иванович - Конструктор Талантов"));
    }

    //Тест на отмену создания кандидата
    @Test
    public void cancelCreatingCandidate() {
        login();
        ccp.goToCandidateCreatePage();
        ccp.clickCancelButton();
        Assert.assertTrue(driver.getTitle().equals("Кандидаты - Конструктор Талантов"));
    }

    //Тест на загрузку резюме профиля с tut.by, где ФИО загружается из файла
    @Test
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

    //Тест на загрузку резюме профиля с tut.by, где ФИО НЕ ЗАГРУЖАЕТСЯ из файла, думаю это связано с тем, что ФИО сместилось из-за фотографии
    @Test
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

    //Тест на загрузку изображения с корректным форматом
    @Test
    public void uploadImageUsingSikuliCorrect() throws FindFailed, InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.uploadFileWithSikuli("human.png");
        Thread.sleep(2000);
        Assert.assertNotEquals(CandidateCreateElements.CURRENT_IMAGE.getWebElement().getAttribute("src"), NO_AVATAR);
    }

    //Тест на загрузку изображения с некорректным форматом
    @Test
    public void uploadImageUsingSikuliIncorrect() throws FindFailed, InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.uploadFileWithSikuli("resume.doc");
        Thread.sleep(2000);
        Assert.assertTrue(CandidateCreateElements.WRONG_IMAGE_FORMAT.getWebElement().getText()
                .equals("Выберите изображение (jpeg, jpg, png, gif, bmp)"));
    }

    //Тест на загрузку файла с помощью Robot
    @Test
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
