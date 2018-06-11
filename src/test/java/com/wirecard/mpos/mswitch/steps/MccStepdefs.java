package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.tasks.CreateMcc;
import com.wirecard.mpos.mswitch.ui.components.NotifyAlert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class MccStepdefs {

    @When("^he creates category (.*) with code (\\d+)$")
    public void createMcc(String name, int code){
        OnStage.theActorInTheSpotlight().wasAbleTo(CreateMcc.withParams(name, code));
    }

    @Then("^(?:his|her|the) mcc should be created successfully$")
    public void hisMccShouldBeCreatedSuccessfully() throws Throwable {
        final String message = "Merchant category code has been created";
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.isVisible()));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.containsText(message)));
    }
}
