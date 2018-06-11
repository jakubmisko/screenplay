package com.wirecard.mpos.mswitch.tasks;

import com.wirecard.mpos.mswitch.ui.components.Buttons;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class CreateEmptyUpdate implements Task {
    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(Buttons.BUTTON.of("Create")),
                Click.on(Buttons.SUBMIT_BUTTON.of("Save")));
    }

    public static CreateEmptyUpdate create(){
        return Tasks.instrumented(CreateEmptyUpdate.class);
    }
}
