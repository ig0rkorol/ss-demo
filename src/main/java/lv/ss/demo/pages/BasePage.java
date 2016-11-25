package lv.ss.demo.pages;

import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;

public class BasePage extends PageObject {

    @WhenPageOpens
    public void makeBrowserWindowFullScreen() {
        getDriver().manage().window().maximize();
    }

}
