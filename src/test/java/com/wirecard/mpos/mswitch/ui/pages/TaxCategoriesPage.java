package com.wirecard.mpos.mswitch.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

//@DefaultUrl(Config.HOST_URL + TaxCategoriesPage.PAGE_PATH)
public class TaxCategoriesPage /*extends PageObject*/ {

    static final String PAGE_PATH = "/taxCategories";

    public static Target NAME_INPUT = Target.the("Name of tax category").locatedBy("#name");
    public static Target COUNTRY_SELECT = Target.the("Country of tax category").locatedBy("#country");
    public static Target IS_STANDARD_SELECT = Target.the("Standard tax identifier").locatedBy("#standard");
    public static Target SAP_BY_DESIGN_CHECKBOX = Target.the("SAP by design check box").located(By.name("hasSapByDesignTaxCodes"));
    public static Target VALID_FROM_INPUT = Target.the("Valid from date").located(By.name("validFrom"));
    public static Target TAX_RATE_INPUT = Target.the("Tax rate value").located(By.name("taxRateValue"));

}
