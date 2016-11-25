package lv.ss.demo.pages.general;

import lv.ss.demo.pages.BasePage;
import lv.ss.demo.utils.RandomGenerator;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TableElement extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(TableElement.class);

    public void checkRandomRows(int rowsToCheckCount, List<String> favoriteItemsIds){
        int totalRowsCount = getRows().size();
        logger.info("Result rows count is {}", totalRowsCount);
        List<Integer> randomRange = RandomGenerator.getRandomNumberInRange(0, totalRowsCount-1);
        for (int i=0;i<rowsToCheckCount;i++){
            int rowNumber = randomRange.get(i).intValue();
            String itemId = checkRow(rowNumber);
            logger.info("Select row #{} Item ID is {}", rowNumber+1 , itemId);
            favoriteItemsIds.add(itemId);
        }
    }
    public String checkRow(int rowNumber) {
        WebElementFacade we = getRows().get(rowNumber);
        we.findElement(By.xpath(".//input")).click();
        String itemId = we.getAttribute("id");
        return itemId;
    }
    public List<WebElementFacade> getRows(){
        return findAll("//*[contains(@class,'msga2 pp0')]//input[contains(@type,'checkbox')]//../..");
    }
}
