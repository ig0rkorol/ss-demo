package lv.ss.demo.pages.result;

import lv.ss.demo.pages.BasePage;
import lv.ss.demo.pages.general.TableElement;
import lv.ss.demo.utils.RandomGenerator;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class ResultPage extends TableElement {
    private static final Logger logger = LoggerFactory.getLogger(ResultPage.class);

    @FindBy(xpath="//a[contains(.,'Cena') or contains(.,'Цена')]")
    private WebElementFacade sortPriceHeading;

    @FindBy(xpath="//a[contains(.,'Papla') or contains(.,'Расширенный поиск')]")
    private WebElementFacade advancedSearchLink;

    @FindBy(xpath="//a[contains(.,'Добавить выбранные в закладки') or contains(.,'Pievienot')]")
    private WebElementFacade addToBookmarks;

    public void openAdvancedSearch(){
        advancedSearchLink.click();
    }

    public void clickAddToBookmarks(){
        addToBookmarks.click();
        acceptAlert();
    }
    private void acceptAlert(){
        $("//a[@id='alert_ok']").click();
    }
}
