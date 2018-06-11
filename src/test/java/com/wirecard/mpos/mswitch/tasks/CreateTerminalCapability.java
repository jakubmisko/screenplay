package com.wirecard.mpos.mswitch.tasks;

import com.wirecard.mpos.mswitch.ui.components.Buttons;
import com.wirecard.mpos.mswitch.ui.components.Input;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class CreateTerminalCapability implements Task {
    private String name;
    private String EMVTerminalType;
    private String capabilities;
    private String additionalCapabilities;
    private String EMVTransactionCategoryCode;

    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(Buttons.BUTTON.of("Create")),
                Enter.theValue(name).into(Input.INPUT_WITH_NAME.of("name")),
                //todo strange name
                Enter.theValue(capabilities).into(Input.INPUT_WITH_NAME.of("field")),
                Click.on(Buttons.SUBMIT_BUTTON.of("Save")));
    }

    public CreateTerminalCapability(String name, String EMVTerminalType, String capabilities, String additionalCapabilities, String EMVTransactionCategoryCode) {
        this.name = name;
        this.EMVTerminalType = EMVTerminalType;
        this.capabilities = capabilities;
        this.additionalCapabilities = additionalCapabilities;
        this.EMVTransactionCategoryCode = EMVTransactionCategoryCode;
    }

    public static CreateTerminalCapability withParams(String name, String capabilities){
        return Tasks.instrumented(CreateTerminalCapability.class, name, null, capabilities, null, null);
    }
}
