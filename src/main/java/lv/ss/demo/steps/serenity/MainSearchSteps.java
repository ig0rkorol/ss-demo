package lv.ss.demo.steps.serenity;

import lv.ss.demo.model.Category;
import lv.ss.demo.model.Languages;
import lv.ss.demo.pages.HeaderMenu;
import lv.ss.demo.pages.MainPageSS;
import lv.ss.demo.pages.search.SearchForm;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MainSearchSteps extends ScenarioSteps {

    public MainPageSS mainPage;
    public HeaderMenu headerMenu;
    public SearchForm searchForm;

    @Step
    public void open_home_page() {
        mainPage.open();
    }

    @Step
    public void switch_language_to(Languages language) {
        headerMenu.switchLanguage(language);
    }

    @Step
    public void open_main_category(Category category) {
        mainPage.invokeMainCategory(category);
    }

    @Step
    public void open_search_form() {
        headerMenu.clickSearchMenuItem();
    }

    @Step
    public void fill_search_form() {
        searchForm.typeSearchWord("Computer");
        searchForm.typePriceMin("160");
        searchForm.typePriceMax("300");
    }

    @Step
    public void search() {
        fill_search_form();
        searchForm.click_search_button();
        System.out.println();
    }

}