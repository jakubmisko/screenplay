package com.wirecard.mpos.mswitch.tasks;

import com.wirecard.mpos.mswitch.ui.components.Buttons;
import com.wirecard.mpos.mswitch.ui.pages.TaxCategoriesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

import static com.wirecard.mpos.mswitch.ui.pages.TaxCategoriesPage.*;

public class CreateTaxCategory implements Task {
    private String name;
    private String country;
    private String standard;
    private String validFrom;
    private String rate;

    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(Buttons.BUTTON.of("Create")),
                Enter.theValue(name).into(NAME_INPUT),
                SelectFromOptions.byVisibleText(country).from(COUNTRY_SELECT),
                SelectFromOptions.byVisibleText(standard).from(IS_STANDARD_SELECT),
                Enter.theValue(validFrom).into(TaxCategoriesPage.VALID_FROM_INPUT),
                Enter.theValue(rate).into(TaxCategoriesPage.TAX_RATE_INPUT),
                Click.on(Buttons.SUBMIT_BUTTON.of("Save")));
    }

    public static CreateTaxCategory withParams(String name, String country, boolean standard, String validFrom, String rate) {
        return Tasks.instrumented(CreateTaxCategory.class, name, country, standard, validFrom, rate);
    }

    public CreateTaxCategory(String name, String country, boolean standard, String validFrom, String rate) {
        this.name = name;
        this.country = country;
        this.standard = standard ? "Yes" : "No";
        this.validFrom = validFrom;
        this.rate = rate;
    }
}
