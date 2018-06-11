package com.wirecard.mpos.mswitch.questions;

import com.wirecard.mpos.mswitch.ui.components.Table;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

public class TableCell implements Question<String> {
    private String column;
    private String row;

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb
                .as(actor)
                .find(By.xpath(Table.CELL.of(row, column).getCssOrXPathSelector()))
                .getText();
    }

    public TableCell(String column, String row) {
        this.column = column;
        this.row = row;
    }

    public static Question<String> get(int row, String columnLabel){
        return new TableCell(columnLabel, String.valueOf(row));

    }
}
