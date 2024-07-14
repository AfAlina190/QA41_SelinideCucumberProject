package de.sconto.stepDefinitions;

import com.codeborne.selenide.Selenide;
import de.sconto.pages.CustomerAccountPage;
import de.sconto.pages.HomePage;
import de.sconto.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    HomePage home;
    LoginPage login;
    CustomerAccountPage customer;

    @When("User clicks on User icon")
    public void click_on_User_icon(){
        home = Selenide.page(HomePage.class);
        login = home.clickOnLoginIcon();
    }
    @Then("User verifies Login form")
    public void verify_Login_form(){
        login.loginFormTitle();
    }

    @When("User enters valid data")
    public void enter_valid_data(){
        login.validLoginInput();
    }

    @And("User clicks on Anmelden button")
    public void click_On_Anmelden_btn(){
        login.clickOnAnmelden();
    }

    @Then("User verifies user name status")
    public void verify_userName_status(){
        home.userNameStatus();
    }

    @Then("User verifies user name")
    public void verify_user_name(){
        customer = Selenide.page(CustomerAccountPage.class);
        customer.userName("Ali Afo");
    }

    @When("User enters invalid email and valid password")
    public void enter_invalid_email_valid_password(DataTable table){
        login.enterInvalidEmail(table);
    }

    @Then("User verifies Error Message is displayed")
    public void verify_Error(){
        login.isMessageTextPresent("Bitte geben Sie eine gültige E-Mail-Adresse ein");

    }

}
