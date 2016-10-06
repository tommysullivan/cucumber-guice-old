package test.java.common;

import com.saucelabs.saucerest.SauceREST;
import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Saucelabs {

    private String sessionId;
    private String username;
    private String accesskey;

    public void UpdateResults(boolean testResult) throws JSONException, IOException {
        SauceREST saucerest = new SauceREST(username, accesskey);
        Map<String, Object> updates = new HashMap<String, Object>();
        updates.put("passed", testResult);
        saucerest.updateJobInfo(sessionId, updates);
    }

    public String getVideoUrl(){
        return "https://saucelabs.com/beta/tests/" + sessionId + "/watch\n";
    }

    public String getSauceJobLink()
    {
        SauceREST saucerest = new SauceREST(username, accesskey);
        return saucerest.getPublicJobLink(sessionId);
    }
}

