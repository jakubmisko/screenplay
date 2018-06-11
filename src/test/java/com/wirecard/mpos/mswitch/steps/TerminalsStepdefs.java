package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.tasks.CreateTerminal;
import com.wirecard.mpos.mswitch.ui.components.NotifyAlert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class TerminalsStepdefs {

    @When("^s?he creates new (.*) terminal with serial staring with (.*) and merchant (.*)$")
    public void createTerminal(String type, String serial, String merchant){
        OnStage.theActorInTheSpotlight().wasAbleTo(CreateTerminal.withParams(type, serial, "KE",  merchant));
    }

    @Then("^(?:his|her) terminal should be created successfully$")
    public void hisTerminalShouldBeCreatedSuccessfully() throws Throwable {
        final String message = "Terminal has been created";
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.isVisible()));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.containsText(message)));
    }
}
