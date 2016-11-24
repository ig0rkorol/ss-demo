package lv.ss.demo.steps.serenity;

import lv.ss.demo.model.SearchOptions;
import lv.ss.demo.pages.search.SearchForm;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SearchSteps extends ScenarioSteps {
    public SearchForm searchForm;

    @Step
    public void fill_search_form(SearchOptions searchOptions) {
        searchForm.typeSearchWord(searchOptions.getWord());
        searchForm.typePriceMin(searchOptions.getMinPrice());
        searchForm.typePriceMax(searchOptions.getMaxPrice());
    }

    @Step
    public void search(SearchOptions value) {
        fill_search_form(value);
        searchForm.click_search_button();
    }
}