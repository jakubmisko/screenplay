package com.wirecard.mpos.mswitch.ui.pages;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage{
    public static final Target USERNAME = Target.the("Username input field").locatedBy("#username");
    public static final Target PASSWORD = Target.the("Password input field").locatedBy("#password");
    public static final Target LOGIN = Target.the("Login button").locatedBy("//button[contains(text(), 'Log in')]");
    public static final Target FORGOT_PASSWORD = Target.the("Forgot password link").locatedBy("//a[@href='#forgottenCredentials");

    public static final String PAGE_PATH = "/login";
}
