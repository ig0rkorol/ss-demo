package lv.ss.demo.steps.serenity;

import lv.ss.demo.model.Category;
import lv.ss.demo.model.Languages;
import lv.ss.demo.pages.HeaderMenu;
import lv.ss.demo.pages.MainPage;
import lv.ss.demo.pages.search.SearchForm;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MainSteps extends ScenarioSteps {
    public MainPage mainPage;
    public HeaderMenu headerMenu;

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



}