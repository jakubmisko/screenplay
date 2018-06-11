package com.wirecard.mpos.mswitch.tasks;

import com.wirecard.mpos.mswitch.actions.WaitForProgress;
import com.wirecard.mpos.mswitch.ui.components.Buttons;
import com.wirecard.mpos.mswitch.ui.components.Input;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

import java.util.Random;

public class CreateTerminal implements Task {
    private String terminalType;
    private String serialNum;
    private String description;
    private String location;
    private String merchant;
    private String status;

    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        //todo status and desc
        actor.attemptsTo(Click.on(Buttons.BUTTON.of("Create")),
                WaitForProgress.waitUntilDissapear(),
                SelectFromOptions.byVisibleText(terminalType).from(Input.SELECT_WITH_ID.of("terminalType")),
                Enter.theValue(serialNum).into(Input.INPUT_WITH_NAME.of("serialNo")),
                Enter.theValue(location).into(Input.INPUT_WITH_NAME.of("location")),
                SelectFromOptions.byVisibleText(merchant).from(Input.SELECT_WITH_ID.of("merchant")),
                Click.on(Buttons.SUBMIT_BUTTON.of("Save")));
    }

    public CreateTerminal(String terminalType, String serialNum, String description, String location, String merchant, String status) {
        this.terminalType = terminalType;
        this.serialNum = serialNum;
        this.description = description;
        this.location = location;
        this.merchant = merchant;
        this.status = status;
    }

    public static CreateTerminal withParams(String type, String serialNumStartingWith, String location, String merchant){
        return Tasks.instrumented(CreateTerminal.class, type, serialNumStartingWith+String.valueOf(new Random().nextInt(Integer.MAX_VALUE)), null, location, merchant, null);
    }
}
