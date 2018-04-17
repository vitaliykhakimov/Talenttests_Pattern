package test.applications;

import driver.WebDriverSingleton;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Helper;
import web.elements.applications.ApplicationPreviewElements;
import web.elements.applications.ApprovalElements;
import web.page.applications.ApplicationsPage;
import web.page.applications.ApprovalPage;
import web.page.applications.appcreate.CreateApplicationPage;
import web.page.login.LoginPage;
import web.page.menu.MenuUsage;
import web.page.applications.appcreate.PositionInfo;
import web.page.applications.appcreate.RequirmentsToCandidate;
import web.page.applications.appcreate.VacancyInfo;

import java.io.IOException;
import java.util.List;

public class ApplicationTests {

    private WebDriver driver = WebDriverSingleton.getInstance();
    private LoginPage lp = new LoginPage();
    private MenuUsage mu = new MenuUsage();
    private ApplicationsPage applicationsPage = new ApplicationsPage();
    private CreateApplicationPage cap = new CreateApplicationPage();
    private VacancyInfo vi = new VacancyInfo();
    private PositionInfo pi = new PositionInfo();
    private RequirmentsToCandidate rtc = new RequirmentsToCandidate();
    private ApplicationPreviewElements ape = new ApplicationPreviewElements();
    private ApprovalPage approvalPage = new ApprovalPage();

    @Step("Логинимся в систему")
    private void login(String name){
        lp.enterLoginPage();
        lp.typeUsername(name);
        lp.typePassword("welcome");
        lp.clickLoginButton();
    }

    @Test
    @DisplayName("Переход на страницу заявок")
    @Description("Переходим на страницу отображения заявок")
    @Feature("Заявки")
    @Story("Сценарий - Переход на страницу заявок выполнен")
    @Severity(SeverityLevel.BLOCKER)
    public void goToApplicationsPage() {
        login("kabanov@tc.by");
        mu.goToApplicationsPage();
        Assert.assertTrue(driver.getTitle().equals("Заявки - Конструктор Талантов"));
    }

    @Test
    @DisplayName("Кнопка создания заявки")
    @Description("Нажимаем на кнопку создания заявки")
    @Feature("Заявки")
    @Story("Сценарий - Кнопка создания заявки нажимается")
    @Severity(SeverityLevel.BLOCKER)
    public void clickCreateApplicationButton() throws InterruptedException {
        login("kabanov@tc.by");
        Helper.waitForTime(2);
        mu.goToApplicationsPage();
        Helper.waitForTime(2);
        applicationsPage.clickCreateApplicationButton();
        Helper.waitForTime(3);
        Assert.assertTrue(driver.getTitle().equals("Создание заявки на подбор персонала - Конструктор Талантов"));
    }

    @Test
    @DisplayName("Создание заявки")
    @Description("Создаем заявку, заполняем все поля и проверям данные")
    @Feature("Заявки")
    @Story("Сценарий - Заявка успешно создана")
    @Severity(SeverityLevel.BLOCKER)
    public void creatingApplication() throws InterruptedException {
        login("kabanov@tc.by");
        Helper.waitForTime(2);
        cap.goToCreateApplicationPage();
        vi.typeInformationAboutVacancyFull();
        pi.typeInformationAboutPositionFull();
        rtc.typeRequirmentsToCandidateFull();
        cap.clickSaveButton();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().equals("Junior iOS developer - Конструктор Талантов"));

        WebElement app_name = driver.findElement(ApplicationPreviewElements.APPLICATION_NAME);
        Assert.assertTrue(app_name.getText().equals("Junior iOS developer"));

        WebElement cand_count = driver.findElement(ApplicationPreviewElements.CANDIDATES_COUNT);
        Assert.assertTrue(cand_count.getText().equals("3"));


        List<WebElement> comments = driver.findElements(ApplicationPreviewElements.COMMENTS_REASON_SPEC);
        Assert.assertTrue(comments.get(0).getText().equals("Тут комментарии."));
        Assert.assertTrue(comments.get(1).getText().equals("Резкая необходимость."));
        Assert.assertTrue(comments.get(2).getText().equals("Инженер-программист"));

        List<WebElement> elements = driver.findElements(ApplicationPreviewElements.ELEMENTS_WITH_OWN_PATH);
        Assert.assertTrue(elements.get(0).getText().equals("договор подряда"));
        Assert.assertTrue(elements.get(1).getText().equals("3000 EUR"));
        Assert.assertTrue(elements.get(2).getText().equals("В наличии 3 подчиненных."));
        Assert.assertTrue(elements.get(3).getText().equals("При необходимости."));
        Assert.assertTrue(elements.get(4).getText().equals("5 дней в неделю, 8 часов в день. Сверхурочные работы - при необходимости"));
        Assert.assertTrue(elements.get(5).getText().equals("1 месяц"));
        Assert.assertTrue(elements.get(6).getText().equals("Высшее"));
        Assert.assertTrue(elements.get(7).getText().equals("От 1 года"));
        Assert.assertTrue(elements.get(8).getText().equals("EPAM"));
        Assert.assertTrue(elements.get(9).getText().equals("Интеграл"));

        List<WebElement> typesWorkCandidate = driver.findElements(ApplicationPreviewElements.TYPE_WORK_AND_TYPE_CANDIDATE);
        Assert.assertTrue(typesWorkCandidate.get(0).getText().equals("проектная работа"));
        Assert.assertTrue(typesWorkCandidate.get(1).getText().equals("внешний"));

        WebElement resp = driver.findElement(ApplicationPreviewElements.RESPONSIBILITIES);
        Assert.assertTrue(resp.getText().equals("Составление тест-кейсов.\n" +
                "Написание собственных тестов."));
    }

    /*@Test
    @DisplayName("Отправляем заявку на согласование")
    @Description("Создаем заявку, заполняем все поля, отправлем на согласование")
    @Feature("Заявки")
    @Story("Сценарий - Заявка успешно создана")
    @Severity(SeverityLevel.BLOCKER)
    public void sendToApproval()  {
        login("kabanov@tc.by");
        Helper.waitForTime(2);
        cap.goToCreateApplicationPage();
        vi.typeInformationAboutVacancyFull();
        pi.typeInformationAboutPositionFull();
        rtc.typeRequirmentsToCandidateFull();
        cap.clickSaveButton();
        approvalPage.clickSendToApprovalButton();
        approvalPage.selectApprovalPersons();
        Helper.waitForTime(2);
        approvalPage.clickApproveButton();
        Helper.waitForTime(3);
        Assert.assertTrue(driver.getTitle().equals("Junior iOS developer - Конструктор Талантов"));
    }

    @Test
    @DisplayName("Согласование заявки")
    @Description("Переходим на страницу отображения заявок, ищем необходимую, согласуем")
    @Feature("Заявки")
    @Story("Сценарий - Согласование заявки")
    @Severity(SeverityLevel.BLOCKER)
    public void approveApp() throws InterruptedException {
        login("lenina@tc.by");
        Helper.waitForTime(3);
        mu.goToApplicationsPage();
        applicationsPage.searchApp("Junior Java developer");
        Helper.waitForTime(1);
        applicationsPage.reviewApp();
        Helper.waitForTime(1);
        applicationsPage.clickApproveButton();
        Helper.waitForTime(3);
        Assert.assertTrue(ApprovalElements.SUCCESS_MESSAGE.getWebElement().getText().equals("Заявка была согласована"));
    }*/

    @After
    public void shutDown() throws IOException {
        Helper.closeBrowser();
    }
}
