package guice;

import com.google.inject.AbstractModule;

public class ScenarioModule extends AbstractModule {

    @Override
    protected void configure() {
        ScenarioScope scenarioScope = new SequentialScenarioScope();
        bindScope(ScenarioScoped.class, scenarioScope);
        bind(ScenarioScope.class).toInstance(scenarioScope);
    }
}
