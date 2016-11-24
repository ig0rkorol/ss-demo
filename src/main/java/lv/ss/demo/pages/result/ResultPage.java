package lv.ss.demo.pages.result;

import lv.ss.demo.pages.BasePage;
import lv.ss.demo.utils.RandomGenerator;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ResultPage extends BasePage {
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

    public void checkRow(int rowNumber) {
        getResultRowsCheckbox().get(rowNumber).click();
    }

    public void checkRandomRowsCount(int rowsCount, List<String> favoriteItemsIds){
        int totalRowsCount = getResultRowsCheckbox().size();
        List<Integer> randomRange = RandomGenerator.getRandomNumberInRange(0, totalRowsCount);
        for (int i=0;i<rowsCount;i++){
            int rowNumber = randomRange.get(i).intValue();
            logger.info("Select row # " + rowNumber);
            checkRow(rowNumber);
            favoriteItemsIds.add(getItemId(i));
        }
    }


    public void clickAddToBookmarks(){
        addToBookmarks.click();
        acceptAlert();
    }
    private String getItemId(int rowNumber){
        return "";
    }
    private List<WebElementFacade> getResultRowsCheckbox(){
        return findAll("//input[contains(@type,'checkbox')]");
    }

    private void acceptAlert(){
        $("//a[@id='alert_ok']").click();
    }
}