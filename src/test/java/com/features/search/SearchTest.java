package com.features.search;

import com.steps.serenity.SearchSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Steps
    private SearchSteps searchSteps;

    @Test
    public void searchWithValidText() {
        searchSteps.search("TOP SPRING-WHITE-S");
        searchSteps.verifySearchResults("TOP SPRING-WHITE-S");
    }

    @Test
    public void searchWithNoResults() {
        searchSteps.search("woman");
        searchSteps.verifyNoResultsMessage();
    }
}
