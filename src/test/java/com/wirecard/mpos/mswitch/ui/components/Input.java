package com.wirecard.mpos.mswitch.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class Input {
    public static Target INPUT_WITH_NAME = Target.the("Input field with name {0}").locatedBy("//input[@name='{0}']");
    public static Target INPUT_WITH_ID = Target.the("Input field with id {0}").locatedBy("//input[@id='{0}']");
    public static Target SELECT_WITH_ID = Target.the("Select with id {0}").locatedBy("//select[@id='{0}']");
}
