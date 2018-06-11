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
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class CreateUser implements Task {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String timeZone;
    private String role;
    private String status;

    public CreateUser(String username, String password, String firstName, String lastName, String email, String phone, String timeZone, String role, String status) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.timeZone = timeZone;
        this.role = role;
        this.status = status;
    }

    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Click.on(Buttons.BUTTON.of("Create")),
                WaitForProgress.waitUntilDissapear(),
                Enter.theValue(username).into(Input.INPUT_WITH_ID.of("username")),
                Enter.theValue(firstName).into(Input.INPUT_WITH_ID.of("firstName")),
                Enter.theValue(lastName).into(Input.INPUT_WITH_ID.of("lastName")),
                Enter.theValue(email).into(Input.INPUT_WITH_ID.of("email")),
                SelectFromOptions.byVisibleText(timeZone).from(Input.SELECT_WITH_ID.of("timeZone")),
                SelectFromOptions.byVisibleText(role).from(Input.SELECT_WITH_ID.of("role")),
                SelectFromOptions.byVisibleText(status).from(Input.SELECT_WITH_ID.of("status")),
                Click.on(Buttons.SUBMIT_BUTTON.of("Save")));
    }

    public static CreateUser withParams(String username, String firstName, String lastName, String role){
        return Tasks.instrumented(CreateUser.class, username+new Random().nextInt(Integer.MAX_VALUE), null, firstName, lastName, RandomStringUtils.randomAlphabetic(5)+"@mail.com", null, "Europe/Bratislava", role, "Enabled");
    }
}
