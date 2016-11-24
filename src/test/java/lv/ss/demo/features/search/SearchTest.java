package lv.ss.demo.features.search;

import lv.ss.demo.model.Category;
import lv.ss.demo.model.ComputerDealType;
import lv.ss.demo.model.Languages;
import lv.ss.demo.model.SearchOptions;
import lv.ss.demo.requirements.Application;
import lv.ss.demo.steps.serenity.MainSteps;
import lv.ss.demo.steps.serenity.SearchResultSteps;
import lv.ss.demo.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@Story(Application.Search.Simple.class)
public class SearchTest {
    private final SearchOptions simple = new SearchOptions.Builder().word("computer").build();
    private final SearchOptions advanced = new SearchOptions.Builder().priceMin("160").priceMax("300").build();

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public MainSteps mainSteps;

    @Steps
    public SearchSteps searchSteps;

    @Steps
    public SearchResultSteps resultSteps;

    @Test
    public void clickLanguageTest() throws InterruptedException {
        // 1
        mainSteps.open_home_page();
        // 2
        mainSteps.switch_language_to(Languages.RUSSIAN);
        // 3
        mainSteps.open_main_category(Category.ELECTRONICS);
        // 4
        mainSteps.open_search_form();
        // 5
        searchSteps.search(simple);
        // 6
        resultSteps.sort_by_price();
        resultSteps.filter_by_deal_type(ComputerDealType.SELL);
        // 7
        resultSteps.open_advanced_search();
        // 8
        searchSteps.search(advanced);
        // 9
        resultSteps.select_random_result_rows(3);

        Thread.sleep(5000);
        System.out.println("FINISH");


//        ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].getAttribute('content');", htmlMetaTag)

    }


} 