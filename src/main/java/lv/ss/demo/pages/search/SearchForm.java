package lv.ss.demo.pages.search;

import lv.ss.demo.model.Languages;
import lv.ss.demo.model.SubHeading;
import lv.ss.demo.pages.SSBasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchForm extends SSBasePage {
    private static final String FORM_LOCATOR = "//form[contains(@action,'search-result')]";

    @FindBy(id="ptxt")
    private WebElementFacade searchWord;

    @FindBy(xpath="//input[contains(@name,'min')]")
    private WebElementFacade priceMin;

    @FindBy(xpath="//input[contains(@name,'max')]")
    private WebElementFacade priceMax;

    @FindBy(xpath=FORM_LOCATOR + "//td[contains(.,'Подрубрика') or contains(.,'rubrika')]")
    private WebElementFacade subHeading;

    @FindBy(id="sbtn")
    private WebElementFacade searchButton;


    public void typeSearchWord(String value){
        searchWord.type(value);
    }
    public void typePriceMin(String min){
        priceMin.type(min);
    }
    public void typePriceMax(String max){
        priceMax.type(max);
    }
    public void selectSubHeading(SubHeading value){
        subHeading.selectByIndex(value.ordinal());
    }
    public void click_search_button() {
        searchButton.click();
    }
}