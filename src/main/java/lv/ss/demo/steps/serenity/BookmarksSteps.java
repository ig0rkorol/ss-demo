package lv.ss.demo.steps.serenity;

import lv.ss.demo.pages.bookmarks.BookmarksPage;
import lv.ss.demo.pages.search.SearchForm;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class BookmarksSteps extends ScenarioSteps {
    public BookmarksPage bookmarksPage;

    @Step
    public void verify_items_present(List<String> expectedItemsIds) {
        List<String> actualItemsIds = bookmarksPage.getRows()
                                        .stream().map(m -> m.getAttribute("id"))
                                        .collect(Collectors.toList());
        assertThat("List equality without order",
                actualItemsIds, containsInAnyOrder(expectedItemsIds.toArray()));
    }
}