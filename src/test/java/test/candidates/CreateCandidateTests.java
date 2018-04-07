package test.candidates;

import driver.WebDriverSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web.elements.candidates.CandidateCreateElements;
import web.page.LoginPage;
import web.page.candidates.CandidateCreatePage;

public class CreateCandidateTests {

    WebDriver driver = WebDriverSingleton.getInstance();
    private LoginPage lp = new LoginPage();
    private CandidateCreatePage ccp = new CandidateCreatePage();

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
        ccp.typeOnlyRequiredFields("Иванов", "Иван", "Иванович", "80334442233", "vanya@mail.ru");
        ccp.clickSaveButton();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().equals("Иванов Иван Иванович - Конструктор Талантов"));
    }

    //тест на создание кандидата с существующим телефоном и электронной почтой
    @Test
    public void createPresentCandidate() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeOnlyRequiredFields("Иванов", "Иван", "Иванович", "80334442233", "vanya@mail.ru");
        ccp.clickSaveButton();
        Thread.sleep(3000);
        ccp.goToCandidateCreatePage();
        ccp.typeOnlyRequiredFields("Иванов", "Иван", "Иванович", "80334442233", "vanya@mail.ru");
        ccp.clickSaveButton();
        Assert.assertTrue(CandidateCreateElements.ERROR_MESSAGE.isElementPresent());
    }

    //тест на ввод некорректных градусов в поле Email и телефон
    @Test
    public void createCandidateWithWrongPhoneAndEmail() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeOnlyRequiredFields("Иванов", "Иван", "Иванович", "wqeqw", "qwewq");
        ccp.clickSaveButton();
        Assert.assertTrue(CandidateCreateElements.WRONG_PHONE.isElementPresent());
        Assert.assertTrue(CandidateCreateElements.WRONG_EMAIL.isElementPresent());
    }

    //Тест на удаление только что созданного кандидата
    @Test
    public void deleteCandidate() throws InterruptedException {
        login();
        ccp.goToCandidateCreatePage();
        ccp.typeOnlyRequiredFields("Иванов", "Иван", "Иванович", "80334442233", "vanya@mail.ru");
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
        ccp.typeOnlyRequiredFields("Иванов", "Иван", "Иванович", "80334442233", "vanya@mail.ru");
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

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
