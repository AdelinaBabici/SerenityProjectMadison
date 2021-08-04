package com.features;

import com.pages.SearchPage;
import com.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.stepdata.StepData;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(SerenityRunner.class)

public class DDTSearchResults extends BaseTest {

    @Steps
    private SearchSteps searchSteps;
    @Steps
    private SearchPage searchPage;

    @Test
    public void searchWithValidText() throws IOException {

        StepData.withTestDataFrom("src/resource/SearchProducts.csv").run(searchSteps).searchAndVerifyResult();

    }
}
