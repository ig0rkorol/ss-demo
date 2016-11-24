package lv.ss.demo.steps.serenity;

import lv.ss.demo.pages.result.FilterResultHeader;
import lv.ss.demo.pages.result.ResultPage;
import lv.ss.demo.pages.result.ResultTable;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class SearchResultSteps extends ScenarioSteps {

    ResultTable resultTable;
    FilterResultHeader filterResultHeader;
    ResultPage resultPage;

    @Step
    public void sort_by_price() {
        resultTable.sortByPrice();
    }

    @Step
    public <E extends Enum<E>> void filter_by_deal_type(E dealType) {
        filterResultHeader.filderByType(dealType);
    }

    @Step
    public void open_advanced_search() {
        resultPage.openAdvancedSearch();
    }

    @Step
    public void select_random_result_rows(int rowsCount, List<String> favoriteItemsIds) {
        resultPage.checkRandomRowsCount(rowsCount, favoriteItemsIds);
    }

    @Step
    public void add_selected_to_bookmarks() {
        resultPage.clickAddToBookmarks();
    }
}