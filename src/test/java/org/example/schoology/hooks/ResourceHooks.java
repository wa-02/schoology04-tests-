package org.example.schoology.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.core.Internationalization;
import org.example.core.ScenarioContext;
import org.example.core.ui.DriverFactory;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.resources.Resources;

public class ResourceHooks {
    private ScenarioContext context;

    public ResourceHooks(final ScenarioContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario() {
        // this will be executed in all the scenarios
    }

    @After(value = "@deleteResource")
    public void deleteCourse() {
        DriverFactory.getDriver().get("https://app.schoology.com");
        String menu = Internationalization.getInstance().getValue("menuResources");
        new Home().clickResource(menu);
        new Resources().clickOnResourceActions(context.getValue("ResourceKey"));
        new Resources().deleteAction();
    }
}
