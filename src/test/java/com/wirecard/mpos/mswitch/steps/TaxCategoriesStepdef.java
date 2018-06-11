package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.tasks.CreateTaxCategory;
import com.wirecard.mpos.mswitch.ui.components.NotifyAlert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaxCategoriesStepdef {

    @When("^s?he creates (\\d+)% (standard )?tax category with name (.*) for (.*) valid from (.*)$")
    public void createTaxCategory(int rate, boolean standard, String name, String country, String validFrom){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(validFrom.equalsIgnoreCase("today") || validFrom.equalsIgnoreCase("now")){
            validFrom = dateFormat.format(new Date());
        }
        OnStage.theActorInTheSpotlight().wasAbleTo(CreateTaxCategory.withParams(name, country, standard, validFrom, String.valueOf(rate)));
    }

    @Then("^(?:his|her|the) tax category should be created successfully$")
    public void hisTaxCategoryIsCreatedSuccessfully() throws Throwable {
        final String message = "Tax category has been created";
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.isVisible()));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.containsText(message)));
    }
}
