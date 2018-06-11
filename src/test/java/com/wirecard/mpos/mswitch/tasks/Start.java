package com.wirecard.mpos.mswitch.tasks;

import com.wirecard.mpos.mswitch.Config;
import com.wirecard.mpos.mswitch.actions.Refresh;
import com.wirecard.mpos.mswitch.actions.WaitForProgress;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class Start implements Task {

    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(Config.HOST_URL),
                Refresh.theBrowserSession(),
                WaitForProgress.waitUntilDissapear());
    }

    public static Start openLogin(){
        return Tasks.instrumented(Start.class);
    }
}
