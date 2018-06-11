package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.tasks.CreatePartner;
import com.wirecard.mpos.mswitch.ui.components.NotifyAlert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class PartnersStepdef {

    @When("^s?he creates partner (.*) with email (.*) from (.*)$")
    public void createPartner(String name, String email, String country){
        OnStage.theActorInTheSpotlight().attemptsTo(CreatePartner.withParams(name, email, country));
    }

    @Then("^(?:his|her|the) partner should be created successfully$")
    public void partnerIsCreatedSuccessfully() throws Throwable {
        final String message = "Partner has been created";
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.isVisible()));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.containsText(message)));
    }

}
