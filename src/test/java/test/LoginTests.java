package test;

import driver.WebDriverSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTests {

    private WebDriver driver = WebDriverSingleton.getInstance();

    //simple LogIn test
    @Test
    public void loginTest1(){
        driver.get("http://testing.cld.iba.by");
        WebElement nameElement = driver.findElement(By.id("_58_login"));
        nameElement.sendKeys("kabanov@tc.by");
        WebElement passElement = driver.findElement(By.id("_58_password"));
        passElement.sendKeys("welcome");
        WebElement loginBtn = driver.findElement(By.xpath("//button"));
        loginBtn.click();
        Assert.assertTrue(driver.getTitle().equals("Главная - Конструктор Талантов"));
    }

    //empty password
    @Test
    public void loginTest2(){
        driver.get("http://testing.cld.iba.by");
        WebElement nameElement = driver.findElement(By.id("_58_login"));
        nameElement.sendKeys("kabanov@tc.by");
        WebElement loginBtn = driver.findElement(By.xpath("//button"));
        loginBtn.click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'form-validator-stack help-inline']//div[@class = 'required']")).getText().equals("Это обязательное поле."));
    }

    //empty name
    @Test
    public void loginTest3(){
        driver.get("http://testing.cld.iba.by");
        WebElement passElement = driver.findElement(By.id("_58_password"));
        passElement.sendKeys("welcome");
        WebElement loginBtn = driver.findElement(By.xpath("//button"));
        loginBtn.click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'form-validator-stack help-inline']//div[@class = 'required']")).getText().equals("Это обязательное поле."));
    }

    //empty name and password
    @Test
    public void loginTest4(){
        driver.get("http://testing.cld.iba.by");
        WebElement loginBtn = driver.findElement(By.xpath("//button"));
        loginBtn.click();
        List<WebElement> alerts = driver.findElements(By.xpath("//div[@class = 'form-validator-stack help-inline']//div[@class = 'required']"));
        Assert.assertTrue(alerts.get(0).getText().equals("Это обязательное поле."));
        Assert.assertTrue(alerts.get(1).getText().equals("Это обязательное поле."));
    }

    //empty name and password
    @Test
    public void loginTest5(){
        driver.get("http://testing.cld.iba.by");
        WebElement nameElement = driver.findElement(By.id("_58_login"));
        nameElement.sendKeys("kabanov11@tc.by");
        WebElement passElement = driver.findElement(By.id("_58_password"));
        passElement.sendKeys("welcome11");
        WebElement loginBtn = driver.findElement(By.xpath("//button"));
        loginBtn.click();
        List<WebElement> alerts = driver.findElements(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertTrue(alerts.get(0).getText().equals("Ваш запрос завершился с ошибкой."));
        Assert.assertTrue(alerts.get(1).getText().equals("Аутентификация не пройдена. Пожалуйста, попробуйте снова."));
    }

    @After
    public void shutDown() {
        driver.quit();
    }
}
