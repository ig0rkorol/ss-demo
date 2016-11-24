package lv.ss.demo.pages;

import lv.ss.demo.model.Languages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HeaderMenu extends BasePage {

//    @FindBy(css="[http-equiv='set-cookie']")
//    private WebElementFacade htmlMetaTag;

    @FindBy(css=".menu_lang a")
    private WebElementFacade language;

    @FindBy(xpath="//*[contains(@class,'menu_main')]//a[contains(@href,'search')]")
    private WebElementFacade searchMenu;


    public void clickLanguage() {
        language.click();
    }

    public Languages getCurrentLanguage(){
        String langValue = language.getTextValue().replaceAll("\\/", "");
        System.out.println(langValue);
        return langValue.equalsIgnoreCase(Languages.RUSSIAN.getCode())?Languages.LATVIAN:Languages.RUSSIAN;
    }

    public void switchLanguage(Languages value) {
        if (!value.getCode().equals(getCurrentLanguage().getCode())){
            clickLanguage();
        }
    }

    public void clickSearchMenuItem(){
        searchMenu.click();
    }


}