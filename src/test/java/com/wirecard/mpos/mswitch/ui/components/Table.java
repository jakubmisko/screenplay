package com.wirecard.mpos.mswitch.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class Table {
    public static final Target HEADER = Target.the("{0} table header").locatedBy("//div[@class='ng-table-header ng-scope']/span[contains(.,'{0}')]");
    public static final Target CELL = Target.the("{0} row and {1} column in table").locatedBy("//tr[{0}]/td[@data-title=\"'{1}'\"]");
    public static final Target COLUMN = Target.the("{{0} columns in table").locatedBy("//td[@data-title=\"'{0}'\"]");
}
