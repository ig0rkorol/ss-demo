package lv.ss.demo.pages.result;

import lv.ss.demo.pages.BasePage;
import lv.ss.demo.utils.RandomGenerator;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class ResultPage extends BasePage {

    @FindBy(xpath="//a[contains(.,'Cena') or contains(.,'Цена')]")
    private WebElementFacade sortPriceHeading;

    @FindBy(xpath="//a[contains(.,'Papla') or contains(.,'Расширенный поиск')]")
    private WebElementFacade advancedSearchLink;

    public void sortByPrice(){
        sortPriceHeading.click();
    }
    public void openAdvancedSearch(){
        advancedSearchLink.click();
    }

    public void checkRow(int rowNumber) {
        getResultRowsCheckbox().get(rowNumber).click();
    }

    public void checkRandomRowsCount(int rowsCount){
        int totalRowsCount = getResultRowsCheckbox().size();
        List<Integer> randomRange = RandomGenerator.getRandomNumberInRange(0, totalRowsCount);
        for (int i=0;i<rowsCount;i++){
            int rowNumber = randomRange.get(i).intValue();
            checkRow(rowNumber);
        }
    }
    private List<WebElementFacade> getResultRowsCheckbox(){
        return findAll("//input[contains(@type,'checkbox')]");
    }

}