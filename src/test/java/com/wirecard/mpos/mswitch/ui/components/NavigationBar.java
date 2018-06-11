package com.wirecard.mpos.mswitch.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class NavigationBar {
    public static Target MAIN_SECTION = Target.the("{0} main section").locatedBy("//ul/li/*/span[contains(text(), '{0}')]");
    public static Target SUB_SECTION = Target.the("{0} sub section").locatedBy("//ul[contains(@class, 'dropdown-menu ng-scope')]/li/a/span[contains(text(), '{0}')]");
}
