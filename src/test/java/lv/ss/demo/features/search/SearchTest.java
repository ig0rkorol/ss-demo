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

import java.util.ArrayList;
import java.util.List;

@RunWith(SerenityRunner.class)
@Story(Application.Search.Simple.class)
public class SearchTest {
    private final SearchOptions simple = new SearchOptions.Builder().word("computer").build();
    private final SearchOptions advanced = new SearchOptions.Builder().priceMin("160").priceMax("300").build();
    private List<String> favoriteItemsIds = new ArrayList<>();

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
        mainSteps.open_home_page();
        mainSteps.switch_language_to(Languages.RUSSIAN);
        mainSteps.open_main_category(Category.ELECTRONICS);
        mainSteps.open_search_form();
        searchSteps.search(simple);
        resultSteps.sort_by_price();
        resultSteps.filter_by_deal_type(ComputerDealType.SELL);
        resultSteps.open_advanced_search();
        searchSteps.search(advanced);
        resultSteps.select_random_result_rows(3, favoriteItemsIds);
        resultSteps.add_selected_to_bookmarks();

        Thread.sleep(5000);
        System.out.println("FINISH");


//        ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].getAttribute('content');", htmlMetaTag)

    }


} 