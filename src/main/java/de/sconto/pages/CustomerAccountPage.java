package de.sconto.pages;

import com.codeborne.selenide.SelenideElement;
import org.hamcrest.Factory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CustomerAccountPage {

    @FindBy(css = ".titleHeadline")
    WebElement userNameTitle;
    public SelenideElement userName(String name) {
        return $(userNameTitle).shouldHave(text(name));
    }
}
