package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.tasks.Navigate;
import cucumber.api.java.en.And;
import net.serenitybdd.screenplay.actors.OnStage;

public class NavigationStepdef {
    @And("^s?he navigate to (.*) under (.*)$")
    public void heNavigateToTaxCategoriesUnderSystem(String subCategoy, String mainCategory) throws Throwable {
        OnStage.theActorInTheSpotlight().attemptsTo(Navigate.toPage(mainCategory, subCategoy));
    }
}
