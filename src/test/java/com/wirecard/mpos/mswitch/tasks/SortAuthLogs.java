package com.wirecard.mpos.mswitch.tasks;

import com.wirecard.mpos.mswitch.ui.components.Table;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SortAuthLogs implements Task {
    private String by;
    private String order;

    @Override
    @Step
    public <T extends Actor> void performAs(T actor) {
        boolean ascending = BrowseTheWeb.as(actor).findBy("//div[@class='ng-table-header ng-scope']/span[contains(., '"+by+"')]/../..").getAttribute("class").contains("sort-asc");
        if((ascending && !order.equalsIgnoreCase("ascending")) || (!ascending && order.equalsIgnoreCase("ascending"))){
            actor.attemptsTo(Click.on(Table.HEADER.of(by)));
        }
    }

    public SortAuthLogs(String by, String order) {
        this.by = by;
        this.order = order;
    }

    public static SortAuthLogs sort(String by, String order){
        return Tasks.instrumented(SortAuthLogs.class, by, order);
    }
}
