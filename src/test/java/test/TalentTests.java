package test;

import driver.WebDriverSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class TalentTests {
    private WebDriver driver = WebDriverSingleton.getInstance();

    private void login(){
        driver.get("http://testing.cld.iba.by");
        WebElement nameElement = driver.findElement(By.id("_58_login"));
        nameElement.sendKeys("kabanov@tc.by");
        WebElement passElement = driver.findElement(By.id("_58_password"));
        passElement.sendKeys("welcome");
        WebElement loginBtn = driver.findElement(By.xpath("//button"));
        loginBtn.click();
    }

    @Test
    public void mainRecruitmentPage() throws InterruptedException {
        login();
        Thread.sleep(5000);
        WebElement recruitmentPage = driver.findElement(By.xpath("//a[@href='http://testing.cld.iba.by/web/guest/recruiting']"));
        recruitmentPage.click();
        Assert.assertTrue(driver.getTitle().equals("Подбор и адаптация - Конструктор Талантов"));
    }

    @After
    public void shutDown() {
        driver.close();
    }
}
