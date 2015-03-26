package org.openqa.selenium.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(name = "q")
    private WebElement queryInput;

    public HomePage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public ResultsPage submitQuery(String query) {
        queryInput.sendKeys(query);
        queryInput.submit();

        return PageFactory.initElements(driver, ResultsPage.class);
    }

}
