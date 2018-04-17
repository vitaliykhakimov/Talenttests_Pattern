package test.general;

import driver.WebDriverSingleton;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import util.Helper;
import web.elements.applications.ApplicationPreviewElements;
import web.elements.candidates.CandidatesElements;
import web.page.applications.ApplicationsPage;
import web.page.applications.ApprovalPage;
import web.page.applications.appcreate.CreateApplicationPage;
import web.page.applications.appcreate.PositionInfo;
import web.page.applications.appcreate.RequirmentsToCandidate;
import web.page.applications.appcreate.VacancyInfo;
import web.page.candidates.CandidateCreatePage;
import web.page.candidates.CandidatesPage;
import web.page.login.LoginPage;
import web.page.menu.MenuUsage;
import web.page.vacancies.VacancyPage;

import java.io.IOException;

public class AllFeaturesTest {
    private WebDriver driver = WebDriverSingleton.getInstance();
    private LoginPage lp = new LoginPage();
    private MenuUsage mu = new MenuUsage();
    private CandidatesPage cp = new CandidatesPage();
    private CandidatesElements ce = new CandidatesElements();
    private CandidateCreatePage ccp = new CandidateCreatePage();
    private CreateApplicationPage cap = new CreateApplicationPage();
    private VacancyInfo vi = new VacancyInfo();
    private PositionInfo pi = new PositionInfo();
    private RequirmentsToCandidate rtc = new RequirmentsToCandidate();
    private ApplicationPreviewElements ape = new ApplicationPreviewElements();
    private ApprovalPage approvalPage = new ApprovalPage();
    private ApplicationsPage applicationsPage = new ApplicationsPage();
    private VacancyPage vacancyPage = new VacancyPage();

    @Step("Логинимся в систему")
    private void login(String name){
        lp.enterLoginPage();
        lp.typeUsername(name);
        lp.typePassword("welcome");
        lp.clickLoginButton();
    }

    @Test
    @DisplayName("Проверка всех функций")
    @Description("Проверяем работоспособность всех функций")
    @Feature("Подбор и адаптация")
    @Story("Сценарий - Проверка работоспособности всех функций")
    @Severity(SeverityLevel.BLOCKER)
    public void allFeaturesTest() {
        login("kabanov@tc.by");

        /*ccp.goToCandidateCreatePage();
        ccp.typeSurname("Петров");
        ccp.typeName("Пётр");
        ccp.typeTelephone("80334442244");
        ccp.typeEmail("petr@mail.ru");
        ccp.clickSaveButton();*/

        cap.goToCreateApplicationPage();
        vi.typeInformationAboutVacancyFull();
        pi.typeInformationAboutPositionFull();
        rtc.typeRequirmentsToCandidateFull();
        cap.clickSaveButton();
        approvalPage.clickSendToApprovalButton();
        approvalPage.selectApprovalPersons();
        Helper.waitForTime(2);
        approvalPage.clickApproveButton();
        Helper.waitForTime(5);

        mu.exitButton();
        login("lenina@tc.by");

        Helper.waitForTime(3);
        mu.goToApplicationsPage();
        applicationsPage.searchApp("Junior iOS developer");
        Helper.waitForTime(1);
        applicationsPage.reviewApp();
        Helper.waitForTime(1);
        applicationsPage.clickApproveButton();
        Helper.waitForTime(3);

        mu.exitButton();
        login("kabanov@tc.by");

        Helper.waitForTime(3);
        mu.goToApplicationsPage();
        applicationsPage.searchApp("Junior iOS developer");
        Helper.waitForTime(1);
        vacancyPage.clickCreateVacancyButton();
        vacancyPage.creatingVacancy();
        vacancyPage.openVacancy();
        Helper.waitForTime(2);

        vacancyPage.addToShortlist("Петров Пётр");
        vacancyPage.addQuestions("Легко учишься?", "Да", "Обучаемость");

        cp.goToCandidatesPage();
        cp.searchCandidate("Петров Пётр");
        cp.clickOnFoundedCandidate();
        cp.inviteForTheInterview();

        Helper.waitForTime(2);
        cp.goToCandidatesPage();
        cp.searchCandidate("Петров Пётр");
        cp.clickOnFoundedCandidate();
        cp.passedTheInterview();
        cp.offeredJob();
        Helper.waitForTime(2);
        Assert.assertTrue(CandidatesElements.OFFERED_JOB_STATUS.isElementPresent());
    }

    @After
    public void shutDown() throws IOException {
        Helper.closeBrowser();
    }
}
