package com.wirecard.mpos.mswitch.tasks;

import com.wirecard.mpos.mswitch.actions.WaitForProgress;
import com.wirecard.mpos.mswitch.ui.pages.SalesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class FilterSales implements Task {
    private String by;
    private String value;

    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        if(by.equalsIgnoreCase("merchant name")){
            actor.attemptsTo(Enter.theValue(value).into(SalesPage.MERCHANT_NAME_INPUT), WaitForProgress.waitUntilDissapear());
        }
    }

    public FilterSales(String by, String value) {
        this.by = by;
        this.value = value;
    }

    public static FilterSales filter(String by, String value){
        return Tasks.instrumented(FilterSales.class, by, value);
    }
}
