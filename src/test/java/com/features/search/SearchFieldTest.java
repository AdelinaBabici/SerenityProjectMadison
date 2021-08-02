package com.features.search;

import com.steps.serenity.SearchFieldSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class SearchFieldTest extends BaseTest{

    @Steps
    private SearchFieldSteps searchFieldSteps;

    @Test
    public void searchWithValidText(){
        searchFieldSteps.search();
    }
}
