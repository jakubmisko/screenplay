package com.wirecard.mpos.mswitch.ui.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;


//@DefaultUrl(Config.HOST_URL +SalesPage.PAGE_PATH)
public class SalesPage /*extends PageObject*/ {

    static final String PAGE_PATH = "/sales";

    public static final Target STATUS_SELECT = Target.the("Sale status filter").locatedBy("");
    public static final Target MERCHANT_NAME_INPUT = Target.the("Merchant name search field").located(By.name("merchant.name*"));
}
