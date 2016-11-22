package lv.ss.demo.features.search;

import lv.ss.demo.requirements.Application;
import lv.ss.demo.steps.serenity.SSMainSearchSteps;
import lv.ss.demo.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
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
    public SSMainSearchSteps ssSteps;

    @Test
    public void clickLanguageTest() throws InterruptedException {
        ssSteps.open_home_page();
        ssSteps.clickLanguage();
        Thread.sleep(5000);
    }


} 