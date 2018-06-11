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
import java.util.UUID;

public class CreatePartner implements Task {
    private final String supportEmail;
    private final String serviceCharge;
    private String name;
    private String email;
    private String country;
    private String supportPhone;

    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Click.on(Buttons.BUTTON.of("Create")),
                Enter.theValue(name).into(Input.INPUT_WITH_ID.of("name")),
                Enter.theValue(supportPhone).into(Input.INPUT_WITH_ID.of("supportPhone")),
                Enter.theValue(supportEmail).into(Input.INPUT_WITH_ID.of("supportEmail")),
                SelectFromOptions.byVisibleText(country).from(Input.SELECT_WITH_ID.of("country")),
                WaitForProgress.waitUntilDissapear(),
                Enter.theValue(serviceCharge).into(Input.INPUT_WITH_NAME.of("serviceChargeRate")),
                //select first tax category from list
                SelectFromOptions.byIndex(1).from(Input.SELECT_WITH_ID.of("serviceChargeTaxCategory")),
                SelectFromOptions.byIndex(1).from(Input.SELECT_WITH_ID.of("tipTaxCategory")),
                Click.on(Buttons.SUBMIT_BUTTON.of("Save")));
    }

    public CreatePartner(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
        supportPhone = "0"+new Random().nextInt(Integer.MAX_VALUE);
        supportEmail = UUID.randomUUID()+"@mail.com";
        serviceCharge = String.valueOf(new Random().nextInt(100));
    }

    public static CreatePartner withParams(String name, String email, String country){
        return Tasks.instrumented(CreatePartner.class, name, email, country);
    }
}
