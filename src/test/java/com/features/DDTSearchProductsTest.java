package com.features;

import com.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/resource/SearchProducts.csv")
public class DDTSearchProductsTest extends BaseTest {

    @Steps
    private SearchSteps searchSteps;

    private String searchKeyword, searchResult;

    @Test
    public void searchWithValidText() {
        searchSteps.searchInput(searchKeyword);
        searchSteps.verifySearchResults(searchResult);
    }
}
