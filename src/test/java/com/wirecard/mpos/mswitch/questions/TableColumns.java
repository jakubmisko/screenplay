package com.wirecard.mpos.mswitch.questions;

import com.wirecard.mpos.mswitch.ui.components.Table;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class TableColumns implements Question<List<String>> {
    private String column;

    @Override
    public List<String> answeredBy(Actor actor) {
        return BrowseTheWeb
                .as(actor)
                .findAll(By.xpath(Table.COLUMN.of(column).getCssOrXPathSelector()))
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public TableColumns(String column) {
        this.column = column;
    }

    public static Question<List<String>> get(String columnLabel){
        return new TableColumns(columnLabel);

    }
}
