package com.wirecard.mpos.mswitch.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class WaitForProgress implements Interaction {
    private Target processing = Target.the("Processing overlay").locatedBy("//div[@ng-show='loadingContainer']");

    @Override
    public   <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(processing, WebElementStateMatchers.isNotVisible()));
    }

    public static WaitForProgress waitUntilDissapear(){
        return new WaitForProgress();
    }
}
