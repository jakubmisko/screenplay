package com.wirecard.mpos.mswitch.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class Buttons {
    public static Target SUBMIT_BUTTON = Target.the("{0} submit button").locatedBy("//button[@type = 'submit' and text()='{0}']");
    public static Target BUTTON = Target.the("{0} button").locatedBy("//button[contains(.,'{0}')]");
}
