package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.tasks.Start;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class OpenPageStepdef {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) opens login page$")
    public void openLoginPage(String actor) {
        OnStage.theActorCalled(actor).wasAbleTo(Start.openLogin());
    }
}
