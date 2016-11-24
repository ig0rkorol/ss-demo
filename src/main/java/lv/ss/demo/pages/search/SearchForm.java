package lv.ss.demo.pages.search;

import lv.ss.demo.model.SubHeading;
import lv.ss.demo.pages.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;

public class SearchForm extends BasePage {
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
        if(StringUtils.isNotEmpty(value))
            searchWord.type(value);
    }
    public void typePriceMin(String value){
        if(StringUtils.isNotEmpty(value))
            priceMin.type(value);
    }
    public void typePriceMax(String value){
        if(StringUtils.isNotEmpty(value))
            priceMax.type(value);
    }
    public void selectSubHeading(SubHeading value){
        if(!(value==null))
            subHeading.selectByIndex(value.ordinal());
    }
    public void click_search_button() {
        searchButton.click();
    }
}
