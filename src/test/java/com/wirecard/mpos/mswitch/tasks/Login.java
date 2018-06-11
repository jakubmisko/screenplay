package com.wirecard.mpos.mswitch.tasks;

import com.wirecard.mpos.mswitch.users.CredentialsManager;
import com.wirecard.mpos.mswitch.users.UserCredentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.wirecard.mpos.mswitch.ui.pages.LoginPage.*;


public class Login implements Task {

    @Override
    @Step("{0 }enters credentials")
    public <T extends Actor> void performAs(T actor) {
        UserCredentials credentials = CredentialsManager.getCredentials();
        actor.attemptsTo(Enter.theValue(credentials.getUsername()).into(USERNAME),
                Enter.theValue(credentials.getPassword()).into(PASSWORD),
                WaitUntil.the(LOGIN, WebElementStateMatchers.isEnabled()),
                Click.on(LOGIN)
        );
    }

    public static Login enterCredentials(){
        return Tasks.instrumented(Login.class);
    }

}
