package lv.ss.demo.pages.result;

import lv.ss.demo.pages.BasePage;
import lv.ss.demo.utils.RandomGenerator;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
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

    public void checkRandomRowsCount(int rowsToCheckCount, List<String> favoriteItemsIds){
        int totalRowsCount = getResultRows().size();
        logger.info("Result rows count is {}", totalRowsCount);
        List<Integer> randomRange = RandomGenerator.getRandomNumberInRange(1, totalRowsCount);
        for (int i=0;i<rowsToCheckCount;i++){
            int rowNumber = randomRange.get(i).intValue();
            String itemId = checkRow(rowNumber);
            logger.info("Select row #{} Item ID is {}" ,rowNumber+1, itemId);
            favoriteItemsIds.add(itemId);
        }
    }

    public void clickAddToBookmarks(){
        addToBookmarks.click();
        acceptAlert();
    }

    private String checkRow(int rowNumber) {
        WebElementFacade we = getResultRows().get(rowNumber);
        we.findElement(By.xpath(".//input")).click();
        String itemId = we.getAttribute("id");
        return itemId;
    }
    private List<WebElementFacade> getResultRows(){
        return findAll("//*[contains(@class,'msga2 pp0')]//input[contains(@type,'checkbox')]//../..");
    }
    private void acceptAlert(){
        $("//a[@id='alert_ok']").click();
    }
}
