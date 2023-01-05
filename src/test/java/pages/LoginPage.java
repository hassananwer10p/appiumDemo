package pages;

import base.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Helper;

import java.time.Duration;

public class LoginPage {

    int emailLength = 10;

    private final Helper hc;

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
        hc = new Helper();
    }

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement createAccountButton;

    @FindBy(id = "com.booking:id/identity_header_title")
    public WebElement pageHeader;

    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public WebElement emailAddress;

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement continueButton;

    @FindBy(id = "com.booking:id/identity_header_title")
    public WebElement createPasswordHeader;

    @FindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    public WebElement password;

    @FindBy(xpath = "//android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    public WebElement confirmPassword;

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement signInButton;

    By by_createAccountButton = By.id("com.booking:id/identity_landing_social_button_text");
    By by_pageHeader = By.id("com.booking:id/identity_header_title");
    By by_passwordField = By.id("com.booking:id/identity_text_input_edit_text");

    public void clickCreateAccountButton() {
        new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(by_createAccountButton));
        createAccountButton.click();
    }

    public void enterValidEmailAddress(String validEmail) {
        new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(by_pageHeader));
        emailAddress.sendKeys(hc.getAlphaNumericString(emailLength) + validEmail);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void enterPassword(String userPassword) {
        new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(by_passwordField));
        password.sendKeys(userPassword);
    }

    public void enterConfirmPassword(String userConfirmPassword) {
          confirmPassword.sendKeys(userConfirmPassword);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
