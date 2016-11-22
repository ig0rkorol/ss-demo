package lv.ss.demo.steps.serenity;

import lv.ss.demo.pages.HeaderMenu;
import lv.ss.demo.pages.MainPageSS;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SSMainSearchSteps extends ScenarioSteps {

    public MainPageSS mainPage;
    public HeaderMenu headerMenu;

    @Step
    public void clickLanguage() {
        headerMenu.clickLanguage();
    }

    public void open_home_page() {
        mainPage.open();
    }
}