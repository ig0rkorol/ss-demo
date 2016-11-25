package lv.ss.demo.steps.serenity;

import lv.ss.demo.pages.bookmarks.BookmarksPage;
import lv.ss.demo.pages.search.SearchForm;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class BookmarksSteps extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(BookmarksSteps.class);
    public BookmarksPage bookmarksPage;
    @Step
    public void verify_items_present(List<String> expectedItemsIds) {
        List<String> actualItemsIds = bookmarksPage.getRows()
                                        .stream().map(m -> m.getAttribute("id"))
                                        .collect(Collectors.toList());
        logger.info("Actual items id {}", actualItemsIds);
        logger.info("Expected items id {}", expectedItemsIds);
        assertThat("List equality without order",
                actualItemsIds, containsInAnyOrder(expectedItemsIds.toArray()));
    }
}