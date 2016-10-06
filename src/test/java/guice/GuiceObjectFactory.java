package test.java.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cucumber.runtime.java.ObjectFactory;

public class GuiceObjectFactory implements ObjectFactory {
    private final Injector injector;

    public GuiceObjectFactory() {
        this(Guice.createInjector(new ScenarioModule(), new MonetGuiceModule()));
    }

    public GuiceObjectFactory(Injector injector) {
        this.injector = injector;
    }

    public void start() {
        injector.getInstance(ScenarioScope.class).enterScope();
    }

    public void stop() {
        injector.getInstance(ScenarioScope.class).exitScope();
    }

    public void addClass(Class<?> aClass) {}

    public <T> T getInstance(Class<T> aClass) {
        return this.injector.getInstance(aClass);
    }
}
