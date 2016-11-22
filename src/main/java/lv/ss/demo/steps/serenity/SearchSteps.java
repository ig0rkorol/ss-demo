package lv.ss.demo.steps.serenity;

import lv.ss.demo.pages.MainPageSS;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class SearchSteps extends ScenarioSteps {

    MainPageSS mainPage;

    @Step
    public void enters(String keyword) {
//        mainPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
       // mainPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        //assertThat(mainPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        mainPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }


}