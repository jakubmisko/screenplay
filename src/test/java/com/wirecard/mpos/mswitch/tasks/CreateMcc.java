package com.wirecard.mpos.mswitch.tasks;

import com.wirecard.mpos.mswitch.ui.components.Buttons;
import com.wirecard.mpos.mswitch.ui.components.Input;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class CreateMcc implements Task{
    private String name;
    private int code;

    public CreateMcc(String name, int code) {
        this.name = name;
        this.code = code;
    }

    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Click.on(Buttons.BUTTON.of("Create")),
                Enter.theValue(String.valueOf(code)).into(Input.INPUT_WITH_ID.of("mcc")),
                Enter.theValue(name).into(Input.INPUT_WITH_ID.of("name")),
                WaitUntil.the(Buttons.SUBMIT_BUTTON.of("Save"), WebElementStateMatchers.isEnabled()),
                Click.on(Buttons.SUBMIT_BUTTON.of("Save")));
    }

    public static CreateMcc withParams(String name, int code){
        return Tasks.instrumented(CreateMcc.class, name, code);
    }
}
