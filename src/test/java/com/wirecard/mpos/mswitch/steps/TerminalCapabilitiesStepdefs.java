package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.tasks.CreateTerminalCapability;
import com.wirecard.mpos.mswitch.ui.components.NotifyAlert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class TerminalCapabilitiesStepdefs {

    @When("^s?he creates terminal capability with name (.*) and capabilities (.*)$")
    public void createTerminalCapability(String name, String capabilities){
        OnStage.theActorInTheSpotlight().attemptsTo(CreateTerminalCapability.withParams(name, capabilities));
    }

    @Then("^(?:his|her|the) terminal capability should be created successfully$")
    public void hisTerminalCapabilityShouldBeCreatedSuccessfully() throws Throwable {
        final String message = "Terminal capabilities template has been created";
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.isVisible()));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.containsText(message)));
    }
}
