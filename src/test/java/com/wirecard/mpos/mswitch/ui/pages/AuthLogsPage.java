package com.wirecard.mpos.mswitch.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AuthLogsPage /*extends PageObject*/ {
    public static final Target DATE_INPUT = Target.the("Date search input").locatedBy("//input[@options='dateRangePickerOption]");
    public static final Target USERNAME_INPUT = Target.the("User name search input").located(By.name("user.username*"));
    public static final Target FIRST_NAME_INPUT = Target.the("First name search input").located(By.name("user.firstName*"));
    public static final Target LAST_NAME_INPUT = Target.the("Last name search input").located(By.name("user.lastName*"));
    public static final Target EMAIL_INPUT = Target.the("Email search input").located(By.name("user.email*"));
    public static final Target DEVICE_SELECT = Target.the("Device search select").located(By.name("device"));
    public static final Target BROWSER_INPUT = Target.the("Browser search input").located(By.name("browser"));
    public static final Target BROWSER_VERSION_INPUT = Target.the("Browser version search input").located(By.name("browserVersion*"));
    public static final Target OPERATING_SYSTEM_INPUT = Target.the("OS search input").located(By.name("operationSystem*"));
    public static final Target SERVER_VERSION_INPUT = Target.the("Switch server version search input").located(By.name("switchServerVersion*"));
}
