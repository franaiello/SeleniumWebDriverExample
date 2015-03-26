package org.openqa.selenium.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPage {

    WebDriver driver;

    @FindBy(className="r")
    private List<WebElement> resultLinks;


    public ResultsPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isResultsCorrect(String query) {
        for( WebElement webElement : resultLinks) {
            if (! webElement.getText().contains(query)) {
                return false;
            }
        }

        return true;
    }

}
