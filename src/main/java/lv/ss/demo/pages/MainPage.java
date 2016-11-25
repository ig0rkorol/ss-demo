package lv.ss.demo.pages;

import lv.ss.demo.model.Category;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.ss.lv/")
public class MainPage extends BasePage {

    public void invokeMainCategory(Category category){
        String locator = String.format("//h2[.//a[contains(@href,'/%s/')]]", category.getCategoryHref());
        $(locator).click();
    }

    public void openBookmarks() {
        $("//*[@class='menu_main']//a[contains(@href,'favorites')]").click();
    }


}