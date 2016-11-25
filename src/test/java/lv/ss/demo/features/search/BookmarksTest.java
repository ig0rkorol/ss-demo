package lv.ss.demo.features.search;

import lv.ss.demo.model.Category;
import lv.ss.demo.model.ComputerDealType;
import lv.ss.demo.model.Languages;
import lv.ss.demo.model.SearchOptions;
import lv.ss.demo.requirements.Application;
import lv.ss.demo.steps.serenity.BookmarksSteps;
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
@Story(Application.Bookmarks.AddBookmarks.class)
public class BookmarksTest {
    private final SearchOptions simple = new SearchOptions.Builder().word("computer").build();
    private final SearchOptions advanced = new SearchOptions.Builder().priceMin("160").priceMax("300").build();
    private List<String> favoriteItemsIds = new ArrayList<>();
    private final int FAVORITE_ITEMS_COUNT = 3;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public MainSteps mainSteps;

    @Steps
    public SearchSteps searchSteps;

    @Steps
    public SearchResultSteps resultSteps;

    @Steps
    public BookmarksSteps bookmarksSteps;

    @Test
    public void addBookmarksTest() throws InterruptedException {
        mainSteps.open_home_page();
        mainSteps.switch_language_to(Languages.RUSSIAN);
        mainSteps.open_main_category(Category.ELECTRONICS);
        mainSteps.open_search_form();
        searchSteps.search(simple);
        resultSteps.sort_by_price();
        resultSteps.filter_by_deal_type(ComputerDealType.SELL);
        resultSteps.open_advanced_search();
        searchSteps.search(advanced);
        resultSteps.select_random_result_rows(FAVORITE_ITEMS_COUNT, favoriteItemsIds);
        resultSteps.add_selected_to_bookmarks();
        mainSteps.open_bookmarks();
        bookmarksSteps.verify_items_present(favoriteItemsIds);
    }
}
