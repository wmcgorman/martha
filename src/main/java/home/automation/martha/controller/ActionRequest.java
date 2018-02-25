package home.automation.martha.controller;

import home.automation.martha.actor.Action;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class ActionRequest {

    @NotNull
    private Action action;
    private Map<String, String> metadata;

    public ActionRequest(Action action) {
        this.action = action;
    }

    public ActionRequest(Action action, Map<String, String> metadata) {
        this.action = action;
        this.metadata = metadata;
    }

    public ActionRequest(){}

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
