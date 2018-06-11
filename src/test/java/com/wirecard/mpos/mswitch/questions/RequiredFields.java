package com.wirecard.mpos.mswitch.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.List;
import java.util.stream.Collectors;

public class RequiredFields implements Question<List<String>> {
    @Override
    public List<String> answeredBy(Actor actor) {
       return BrowseTheWeb
               .as(actor)
               .findAll("//div[contains(@class, 'has-error')]/label")
               .stream()
                   .map(WebElementFacade::getText)
                   .collect(Collectors.toList());
    }

    public static RequiredFields highlighted(){
        return new RequiredFields();
    }
}
