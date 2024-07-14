package de.sconto.stepDefinitions;

import de.sconto.pages.HomePage;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static de.sconto.pages.HomePage.baseURL;

public class HomePageSteps {

    HomePage homePage;

    @Given("User is on Home Page")
    public void user_is_on_HomePage(){

        homePage = open(baseURL, HomePage.class);
        getWebDriver().manage().window().maximize();
        homePage.acceptCookies();
    }

}
