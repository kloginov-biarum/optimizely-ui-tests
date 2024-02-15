import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class LoginTest {
    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }
    @BeforeEach
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("http://qa-stage.flsmm.fls.cloud/");
    }


    @Test
    public void successLoginWithPO(){
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("test1@optitest.com");
        loginPage.enterPassword("ePIsERVER123!$");
        loginPage.clickOnLoginButton();
        LandingPage landingPage = new LandingPage();
        landingPage.catalogButtonIsDisplayed();
    }


    @Test
     public void invalidPassword(){
         $(byId("UserName")).setValue("test1@optitest.com");
         $(byId("Password")).setValue("czxgasghcshj");
         $(byId("Submit")).click();
         $(byClassName("text--error"))
                 .shouldBe(Condition.visible).shouldHave(text("Login failed"));
     }
     @Test
    public void emptyPassword() {
        $(byId("UserName")).setValue("test1@optitest.com");
        $(byId("Password")).setValue("");
        $(byId("Submit")).click();
        $(byClassName("text--error")).shouldBe(Condition.visible)
                .shouldHave(text("You must enter a password"));
    }






}
