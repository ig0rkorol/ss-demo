package lv.ss.demo.pages.result;

import lv.ss.demo.pages.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ResultTable extends BasePage {

    @FindBy(xpath="//a[contains(.,'Cena') or contains(.,'Цена')]")
    private WebElementFacade sortPriceHeading;

    public void sortByPrice(){
        sortPriceHeading.click();
    }

}