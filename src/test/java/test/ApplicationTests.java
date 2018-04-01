package test;

import driver.WebDriverSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ApplicationTests {

    private WebDriver driver = WebDriverSingleton.getInstance();

    //login
    private void login(){
        driver.get("http://testing.cld.iba.by");
        WebElement nameElement = driver.findElement(By.id("_58_login"));
        nameElement.sendKeys("kabanov@tc.by");
        WebElement passElement = driver.findElement(By.id("_58_password"));
        passElement.sendKeys("welcome");
        WebElement loginBtn = driver.findElement(By.xpath("//button"));
        loginBtn.click();
    }

    //отправление на главную страницу подбора
    private void goToMainRecruitmentPage() throws InterruptedException {
        Thread.sleep(3000);
        WebElement recruitmentPage = driver.findElement(By.xpath("//a[@href='http://testing.cld.iba.by/web/guest/recruiting']"));
        recruitmentPage.click();
    }

    //отправление на главную страницу заявок
    private void goToMainApplicationPage() throws InterruptedException{
        login();
        goToMainRecruitmentPage();
        WebElement applicationPage = driver.findElement(By.xpath("//a[@href = 'http://testing.cld.iba.by/web/guest/recruiting/applications']"));
        applicationPage.click();
    }

    //отправление на страницу создания заявки
    private void goToCreatingApplicationPage() throws InterruptedException{
        goToMainApplicationPage();
        Thread.sleep(2000);
        WebElement createAppBtn = driver.findElement(By.xpath("//a[@id = 'createButton']"));
        createAppBtn.click();
    }

    //заполнение блока "Информация о вакансии"
    private void informationAboutVacancy(String date, int i, String count, String reason){
        WebElement planningDateField = driver.findElement(By.xpath("//input[@id = 'plannedClosingDate']"));
        planningDateField.sendKeys(date);

        List<WebElement> priorityBtns = driver.findElements(By.xpath("//div[@class = 'control-group row-fluid col-xs-12 col-md-8 col-lg-8']" +
                "//div[@class = 'controls radio-controls col-xs-12 col-md-8 col-lg-8']" +
                "//input"));
        priorityBtns.get(i).click();

        WebElement countOfWorkers = driver.findElement(By.xpath("//input[@id = 'quantity']"));
        countOfWorkers.sendKeys(count);

        WebElement creationReason = driver.findElement(By.xpath("//textarea[@id = 'creationReason']"));
        creationReason.sendKeys(reason);
    }

    //Заполнение блока "Информация о позиции"
    private void informationAboutPosition(int i, String slry, int curr, int jobT, String sub,
                                          String businessT, String timeT, String probPeriod, String resp){
        List<WebElement> contractTypes = driver.findElements(By.xpath("//div[@class = 'control-group contractType row-fluid col-xs-12 col-md-8 col-lg-8 my-success']"+
                "//div[@class = 'controls radio-controls col-xs-12 col-md-8 col-lg-8']"+
                "//input"));
        contractTypes.get(i).click();

        WebElement salary = driver.findElement(By.xpath("//input[@id = 'salary']"));
        salary.sendKeys(slry);

        Select currency = new Select(driver.findElement(By.xpath("//select[@id = 'currency']")));
        currency.selectByIndex(curr);

        List<WebElement> jobTypes = driver.findElements(By.xpath("//select[@id = 'jobType']//option"));
        jobTypes.get(jobT).click();

        WebElement subordinates = driver.findElement(By.xpath("//input[@id = 'employees']"));
        subordinates.sendKeys(sub);

        WebElement businessTrips = driver.findElement(By.xpath("//input[@id = 'businessTrip']"));
        businessTrips.sendKeys(businessT);

        WebElement timetable = driver.findElement(By.xpath("//input[@id = 'timetable']"));
        timetable.sendKeys(timeT);

        WebElement probationPeriod = driver.findElement(By.xpath("//input[@id = 'probationPeriod']"));
        probationPeriod.sendKeys(probPeriod);

        WebElement responsibilities = driver.findElement(By.xpath("//textarea[@id = 'responsibilities']"));
        responsibilities.sendKeys(resp);
    }

    private void requirementsToCandidate() throws InterruptedException {
        List<WebElement> candidateTypes = driver.findElements(By.xpath("//div[@class = 'controls col-xs-12 col-md-8 col-lg-8']" +
                "//div[@class = 'checkbox checkbox-recruiting checkbox-inline col-lg-4 col-md-4 col-sm-4 col-xs-4 text-lowercase']" +
                "//input"));
        candidateTypes.get(0).click();
        candidateTypes.get(1).click();

        List<WebElement> education = driver.findElements(By.xpath("//select[@id = 'education']//option"));
        education.get(4).click();

        WebElement educationSpecialization = driver.findElement(By.xpath("//textarea[@id = 'educationSpecialization']"));
        educationSpecialization.sendKeys("Инженер-программист");

        List<WebElement> experience = driver.findElements(By.xpath("//select[@id = 'experience']//option"));
        experience.get(1).click();

        WebElement priorityWorkingExperience = driver.findElement(By.xpath("//textarea[@id = 'priority.working.experience']"));
        priorityWorkingExperience.sendKeys("Apple, Google");

        WebElement undesirableWorkingExperience = driver.findElement(By.xpath("//textarea[@id = 'undesirableWorkingExperience']"));
        undesirableWorkingExperience.sendKeys("Интеграл");

        List<WebElement> addCompetenciesBtn = driver.findElements(By.xpath("//a[@class = 'editable-mode view-actions edit-mode add-competence']"));
        addCompetenciesBtn.get(0).click();

        Actions action = new Actions(driver);
        WebElement searchingCompetence = driver.findElement(By.id("searchCompetenceWord"));
        searchingCompetence.sendKeys("Обучаемость");
        Thread.sleep(2000);
        WebElement competencies = driver.findElement(By.id("competence_1103"));
        action.doubleClick(competencies).build().perform();

        searchingCompetence.clear();
        searchingCompetence.sendKeys("MySQL");
        Thread.sleep(2000);
        competencies = driver.findElement(By.id("competence_196"));
        action.doubleClick(competencies).build().perform();

        WebElement okBtn = driver.findElement(By.cssSelector("div.toolbar-content button:nth-child(2)"));
        Thread.sleep(2000);
        okBtn.click();

        addCompetenciesBtn.get(1).click();
        searchingCompetence.sendKeys("Английский язык");
        Thread.sleep(2000);
        competencies = driver.findElement(By.id("competence_222"));
        action.doubleClick(competencies).build().perform();
        Thread.sleep(2000);
        okBtn.click();
    }

    //Тест переход на страницу заявок
    @Test
    public void applicationTest() throws InterruptedException {
        login();
        goToMainRecruitmentPage();
        WebElement applicationPage = driver.findElement(By.xpath("//a[@href = 'http://testing.cld.iba.by/web/guest/recruiting/applications']"));
        applicationPage.click();
        Assert.assertTrue(driver.getTitle().equals("Заявки - Конструктор Талантов"));
    }

    //Тест перехода на страницу создания заявки
    @Test
    public void applicationCreateButtonTest() throws InterruptedException {
        goToMainApplicationPage();
        Thread.sleep(2000);
        WebElement createAppBtn = driver.findElement(By.xpath("//a[@id = 'createButton']"));
        createAppBtn.click();
        Assert.assertTrue(driver.getTitle().equals("Создание заявки на подбор персонала - Конструктор Талантов"));
    }

    //Тест создания новой заявки
    @Test
    public void creatingAppTest1() throws InterruptedException {
        goToCreatingApplicationPage();

        WebElement positionField = driver.findElement(By.xpath("//input[@id = 'name']"));
        positionField.sendKeys("QA engineer 1");

        informationAboutVacancy("12.04.2018", 2, "3", "Резкая потребность.");
        informationAboutPosition(1, "3000", 2, 2, "В наличии 3 подчиненных.",
                "Возможны.", "5 дней в неделю, 8 часов в день.", "1 месяц.",
                "Составление тест-кейсов.\nНаписание собственных тестов.");
        requirementsToCandidate();
        WebElement comments = driver.findElement(By.xpath("//textarea[@id = 'comment']"));
        comments.sendKeys("Тут должны быть комментарии");
        WebElement saveBtn = driver.findElement(By.xpath("//button[@id = 'save']"));
        saveBtn.click();

        Assert.assertTrue(driver.getTitle().equals(positionField.getText()+" - Конструктор Талантов"));
    }

    @After
    public void shutDown() {
        driver.close();
    }

}
