package org.openqa.selenium.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.example.pageobjects.HomePage;
import org.openqa.selenium.example.pageobjects.ResultsPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GoogleSearchTest {

    private static WebDriver driver;
    private static String google ="http://www.google.com";


    @BeforeClass
    public void beforeClass() {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        driver = new FirefoxDriver();
    }

    @Test
    public static void submitQuery() {

        final String query = "cheese!";
        final String result = "cheese";

        // Initialize 'HomePage' and any WebElement fields on page before using page.
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo(google);

        ResultsPage resultsPage = homePage.submitQuery(query);

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        assertThat(
                (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().toLowerCase().startsWith(query);
                    }
                })).isTrue();


        assertThat(resultsPage.isResultsCorrect(result)).isTrue();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}