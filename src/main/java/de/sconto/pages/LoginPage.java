package de.sconto.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import de.sconto.utils.PropertiesLoader;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static final String validEmail = PropertiesLoader.loadProperty("valid.email");
    public static final String validPassword = PropertiesLoader.loadProperty("valid.password");

    @FindBy(css = ".existingAccount__headline")
    WebElement loginFormTitle;
    public SelenideElement loginFormTitle() {
        return $(loginFormTitle).should(exist);
    }

    @FindBy(id= "loginEmail")
    WebElement emailInput;

    @FindBy(id = "loginPassword")
    WebElement passwordInOut;
    public LoginPage validLoginInput() {
        $(emailInput).val(validEmail);
        $(passwordInOut).val(validPassword);
        return Selenide.page(LoginPage.class);
    }

    @FindBy(id = "login-submit")
    WebElement anmeldenBtn;
    public HomePage clickOnAnmelden() {
        $(anmeldenBtn).click();
        return Selenide.page(HomePage.class);
    }

    public LoginPage enterInvalidEmail(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps();

        String email = dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");

        $(emailInput).val(email);
        $(passwordInOut).val(password);

        return Selenide.page(LoginPage.class);
    }

    @FindBy(id = "loginEmail-error")
    WebElement loginEmailError;

    public SelenideElement isMessageTextPresent(String message) {
        return $(loginEmailError).shouldHave(text(message));
    }
}
