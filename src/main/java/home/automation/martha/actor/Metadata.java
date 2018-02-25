package home.automation.martha.actor;

public class Metadata {

    private String target;
    private Action action;

    public Metadata(String target, Action action) {
        this.target = target;
        this.action = action;
    }

    public String getTarget() {
        return target;
    }

    public Action getAction() {
        return action;
    }
}
