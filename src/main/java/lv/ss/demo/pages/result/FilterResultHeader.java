package lv.ss.demo.pages.result;

import lv.ss.demo.pages.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FilterResultHeader extends BasePage {

    @FindBy(xpath="//span[@class='filter_opt_dv' and (contains(.,'rubrika') or contains(.,'Тип сделки'))]/select")
    private WebElementFacade filterByDealType;

    public <E extends Enum<E>> void filderByType(E value){
        filterByDealType.selectByIndex(value.ordinal());
    }

}

