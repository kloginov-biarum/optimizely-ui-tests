import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement usernameInputField = $(byId("UserName"));
    private SelenideElement passwordInputField = $(byId("Password"));
    private SelenideElement loginButton =  $(byId("Submit"));

    public void enterUsername(String userNameValue){
        usernameInputField.setValue(userNameValue);
    }
    public void enterPassword(String passwordValue){
        passwordInputField.setValue(passwordValue);
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }
}
