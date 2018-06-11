package com.wirecard.mpos.mswitch.tasks;

import com.wirecard.mpos.mswitch.actions.WaitForProgress;
import com.wirecard.mpos.mswitch.ui.components.NavigationBar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class Navigate implements Task{
    private final String sub;
    private String main;
    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Click.on(NavigationBar.MAIN_SECTION.of(main)),
                WaitUntil.the(NavigationBar.SUB_SECTION.of(sub), WebElementStateMatchers.isVisible()),
                Click.on(NavigationBar.SUB_SECTION.of(sub)),
                WaitForProgress.waitUntilDissapear()
        );
    }

    public static Navigate toPage(String main, String sub){
        return Tasks.instrumented(Navigate.class, main, sub);
    }

    public Navigate(String main, String sub) {
        this.main = main;
        this.sub = sub;
    }
}
