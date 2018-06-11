package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.actions.WaitForProgress;
import com.wirecard.mpos.mswitch.tasks.Login;
import com.wirecard.mpos.mswitch.ui.components.NotifyAlert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class LoginPageStepdef {

    @And("^s?he logs in$")
    public void login() throws InterruptedException {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.enterCredentials(), WaitForProgress.waitUntilDissapear());
    }

    @Then("^s?he should be logged in successfully$")
    public void heShouldBeLoggedInSuccessfully() throws Throwable {
        final String message = "Login successful";
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.isVisible()));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.containsText(message)));
    }
}
