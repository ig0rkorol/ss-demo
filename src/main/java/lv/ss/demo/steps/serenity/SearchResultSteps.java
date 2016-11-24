package lv.ss.demo.steps.serenity;

import lv.ss.demo.pages.result.ResultTable;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SearchResultSteps extends ScenarioSteps {

    ResultTable resultTable;

    @Step
    public void sort_by_price() {
        resultTable.sortByPrice();
    }

}