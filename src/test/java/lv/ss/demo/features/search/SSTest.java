package lv.ss.demo.features.search;

import lv.ss.demo.model.Category;
import lv.ss.demo.model.Languages;
import lv.ss.demo.requirements.Application;
import lv.ss.demo.steps.serenity.MainSearchSteps;
import lv.ss.demo.steps.serenity.SearchResultSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@Story(Application.Search.Simple.class)
public class SSTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public MainSearchSteps ssSteps;

    @Steps
    public SearchResultSteps resultSteps;

    @Test
    public void clickLanguageTest() throws InterruptedException {
        // 1
        ssSteps.open_home_page();
        // 2
        ssSteps.switch_language_to(Languages.RUSSIAN);
        // 3
        ssSteps.open_main_category(Category.ELECTRONICS);
        // 4
        ssSteps.open_search_form();
        // 5
        ssSteps.search();
        // 6
        resultSteps.sort_by_price();

        Thread.sleep(5000);

//        ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].getAttribute('content');", htmlMetaTag)

    }


} 