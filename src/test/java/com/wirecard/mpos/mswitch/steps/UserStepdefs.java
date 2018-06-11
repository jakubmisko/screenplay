package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.tasks.CreateUser;
import com.wirecard.mpos.mswitch.ui.components.NotifyAlert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class UserStepdefs {

    @When("^he creates user (.*) (.*) with username (.*) and (.*) role$")
    public void createUser(String firstName, String lastName, String username, String role){
        OnStage.theActorInTheSpotlight().wasAbleTo(CreateUser.withParams(username, firstName, lastName, role));
    }

    @Then("^(?:his|her|the) user should be created successfully$")
    public void hisUserShouldBeCreatedSuccessfully() throws Throwable {
        final String message = "User has been created";
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.isVisible()));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotifyAlert.NOTIFY_ALERT_TEXT), WebElementStateMatchers.containsText(message)));
    }
}
