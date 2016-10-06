package guice;

import com.google.inject.Key;
import com.google.inject.OutOfScopeException;
import com.google.inject.Provider;

import java.util.HashMap;
import java.util.Map;

public class SequentialScenarioScope implements ScenarioScope {

    private Map<Key<?>, Object> scenarioValues = null;

    public <T> Provider<T> scope(final Key<T> key, final Provider<T> unscoped) {
        return new Provider<T>() {
            public T get() {
                if (scenarioValues == null) {
                    throw new OutOfScopeException("Cannot access " + key + " outside of a scoping block");
                }

                @SuppressWarnings("unchecked")
                T current = (T) scenarioValues.get(key);
                if (current == null && !scenarioValues.containsKey(key)) {
                    current = unscoped.get();
                    scenarioValues.put(key, current);
                }
                return current;
            }
        };
    }

    public void enterScope() {
        checkState(scenarioValues == null, "A scoping block is already in progress");
        scenarioValues = new HashMap<Key<?>, Object>();
    }

    public void exitScope() {
        checkState(scenarioValues != null, "No scoping block in progress");
        scenarioValues = null;
    }

    private void checkState(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalStateException(errorMessage);
        }
    }

}
