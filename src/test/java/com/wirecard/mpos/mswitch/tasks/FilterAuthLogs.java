package com.wirecard.mpos.mswitch.tasks;

import com.wirecard.mpos.mswitch.ui.pages.AuthLogsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class FilterAuthLogs implements Task {
    private String by;
    private String value;

    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        Performable task;
        if(by.equalsIgnoreCase("device")){
            task = SelectFromOptions.byValue(value).from(AuthLogsPage.DEVICE_SELECT);
        } else if(by.equalsIgnoreCase("date")){
            task = Enter.theValue(value).into(AuthLogsPage.DATE_INPUT);
        } else if(by.equalsIgnoreCase("username")){
            task = Enter.theValue(value).into(AuthLogsPage.USERNAME_INPUT);
        }else if(by.equalsIgnoreCase("first name")){
            task = Enter.theValue(value).into(AuthLogsPage.FIRST_NAME_INPUT);
        }else if(by.equalsIgnoreCase("last name")){
            task = Enter.theValue(value).into(AuthLogsPage.LAST_NAME_INPUT);
        }else if(by.equalsIgnoreCase("email")){
            task = Enter.theValue(value).into(AuthLogsPage.EMAIL_INPUT);
        }else if(by.equalsIgnoreCase("browser")){
            task = Enter.theValue(value).into(AuthLogsPage.BROWSER_INPUT);
        }else if(by.equalsIgnoreCase("browser version")){
            task = Enter.theValue(value).into(AuthLogsPage.BROWSER_VERSION_INPUT);
        }else if(by.equalsIgnoreCase("operating system") || by.equalsIgnoreCase("os")){
            task = Enter.theValue(value).into(AuthLogsPage.OPERATING_SYSTEM_INPUT);
        }else/* if(by.equalsIgnoreCase("server version"))*/{
            task = Enter.theValue(value).into(AuthLogsPage.SERVER_VERSION_INPUT);
        }

        actor.attemptsTo(task);
    }

    public FilterAuthLogs(String by, String value) {
        this.by = by;
        this.value = value;
    }

    public static FilterAuthLogs filter(String by, String value){
        return Tasks.instrumented(FilterAuthLogs.class, by, value);
    }
}
