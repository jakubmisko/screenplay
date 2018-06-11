package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.questions.RequiredFields;
import com.wirecard.mpos.mswitch.tasks.CreateEmptyUpdate;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

public class TerminalUpdatesStepdefs {


    @When("^he tries to create update with no data$")
    public void createEmptyTerminalUpdate(){
        OnStage.theActorInTheSpotlight().attemptsTo(CreateEmptyUpdate.create());
    }

    @Then("^he should see marked all mandatory fields for terminal update$")
    public void heShouldSeeMarkedAllMandatoryFields() throws Throwable {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(RequiredFields.highlighted(), Matchers.containsInAnyOrder("Terminal Type", "Update Type", "Update Priority", "Version", "Update File")));

    }
}
