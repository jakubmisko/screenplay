package com.wirecard.mpos.mswitch.steps;

import com.wirecard.mpos.mswitch.actions.WaitForProgress;
import com.wirecard.mpos.mswitch.questions.TableCell;
import com.wirecard.mpos.mswitch.tasks.FilterAuthLogs;
import com.wirecard.mpos.mswitch.tasks.SortAuthLogs;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthStepdefs {

    @When("^he filter logs by (.*) (.*)$")
    public void filterAuthLogs(String by, String value){
        OnStage.theActorInTheSpotlight().attemptsTo(FilterAuthLogs.filter(by, value), WaitForProgress.waitUntilDissapear());
    }

    @And("^he sort logs by (.*) (.*)")
    public void heSortLogsByDateDescending(String by, String order) throws Throwable {
        OnStage.theActorInTheSpotlight().attemptsTo(SortAuthLogs.sort(by, order), WaitForProgress.waitUntilDissapear());
    }

    @Then("^(\\d+) (?:st|nd|rd|th) row Date should be from (.*)$")
    public void stRowShoudBeFromToday(int rowNum, String date) throws Throwable {
        SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy");
        if(date.equalsIgnoreCase("today")){
            date = format.format(new Date());
        }
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TableCell.get(rowNum, "Date"), Matchers.containsString(date)));
    }
}
