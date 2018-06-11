package com.wirecard.mpos.mswitch;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/"/*, tags = "@dev"*/)
public class DefinitionTestSuite {}
