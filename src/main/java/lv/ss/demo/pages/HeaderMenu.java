package lv.ss.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HeaderMenu extends SSBasePage {

    @FindBy(css=".menu_lang a")
    private WebElementFacade language;

    public void clickLanguage() {
        language.click();
    }

}