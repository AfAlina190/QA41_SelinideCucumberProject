package de.sconto.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import de.sconto.utils.PropertiesLoader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public static String baseURL= PropertiesLoader.loadProperty("url");

    @FindBy(css = "[data-accept-action='all']")
    WebElement acceptButton;
    public HomePage acceptCookies() {
        if ($(acceptButton).exists()) {
            $(acceptButton).click();
        }
        return Selenide.page(this);
    }

    @FindBy(css = ".headerElement--login")
    WebElement loginIcon;
    public LoginPage clickOnLoginIcon() {
        $(loginIcon).click();
        return Selenide.page(LoginPage.class);
    }

    @FindBy(css = ".headerElement__status--login")
    WebElement statusLogin;
    public SelenideElement userNameStatus() {

        return $(statusLogin).shouldHave(text("Ali Afo"));
    }
}
