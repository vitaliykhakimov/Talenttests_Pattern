package element;

import driver.WebDriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class GenericElement {
    private String name;
    private By by;
    WebDriver driver = WebDriverSingleton.getInstance();

    public GenericElement(String name, By by) {
        this.name = name;
        this.by = by;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }

    public WebElement getWebElement() {
        return WebDriverSingleton.getInstance().findElement(by);
    }

    public List<WebElement> getWebElements() {
        return WebDriverSingleton.getInstance().findElements(by);
    }


    public Boolean isElementPresent() {
        try{
            getWebElement();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public Boolean isElementsPresent() {
        try{
            getWebElement();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void assertPresenceElement() {
        Assert.assertTrue("Элемент " + name + " не существует на странице", isElementPresent());
    }

    public void assertPresenceElements() {
        Assert.assertTrue("Элементы " + name + " не существует на странице", isElementsPresent());
    }

    public void click() {
        assertPresenceElement();
        getWebElement().click();
    }

    public void sendKeys(String str) {
        assertPresenceElement();
        getWebElement().sendKeys(str);
    }

    public void selectAndClickRadioButton(int i) {
        assertPresenceElements();
        getWebElements().get(i).click();
    }

    public void selectAndClickCheckBox(int i) {
        assertPresenceElements();
        getWebElements().get(i).click();
    }

    public void clickAddRequireCompetenceButton() {
        assertPresenceElements();
        getWebElements().get(0).click();
    }

    public void clickAddWantedCompetenceButton() {
        assertPresenceElements();
        getWebElements().get(1).click();
    }

    public void searchCandidate(String name) {
        assertPresenceElement();
        getWebElement().sendKeys(name);
    }

    public void clickSelectVacancyButton() {
        assertPresenceElements();
        getWebElements().get(0).click();
    }

    public void clickSelectEducationButton() {
        assertPresenceElements();
        getWebElements().get(1).click();
    }

    public void clickSelectUniversityButton() {
        assertPresenceElements();
        getWebElements().get(2).click();
    }

    public void clickSelectCompetenceButton() {
        assertPresenceElements();
        getWebElements().get(3).click();
    }

    public void closeSelectButton() {
        assertPresenceElements();
        getWebElement().click();
    }

    public void clickFilterCheckbox() {
        assertPresenceElement();
        getWebElement().click();
    }


    public void goToFoundedCandidatePage() {
        assertPresenceElement();
        getWebElement().click();
    }

    public void clickCreateCandidateButton() {
        assertPresenceElement();
        getWebElement().click();
    }
}
