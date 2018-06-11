package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.questions.TableColumns;
import com.wirecard.mpos.mswitch.tasks.FilterSales;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.is;

public class SalesStepdefs {

    @When("^he filters sales by (.*) : (.*)")
    public void filterSalesBy(String by, String value){
        OnStage.theActorInTheSpotlight().attemptsTo(FilterSales.filter(by, value));
    }

    @Then("^only sales with (.*) containing (.*) should be visible$")
    public void onlySalesWithNameTestMerchShouldBeVisible(String columnName, String value) throws Throwable {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TableColumns.get(columnName), everyItem(is(value))));
    }
}

