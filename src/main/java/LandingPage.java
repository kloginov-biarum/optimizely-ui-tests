import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LandingPage {

    private SelenideElement catalogButton =
            $(byText("Go to the Catalog"));

    public void catalogButtonIsDisplayed(){
        catalogButton.shouldBe(Condition.visible);
    }
}
