package home.automation.martha.actor.tv;

import home.automation.martha.actor.Action;

import java.util.HashMap;
import java.util.Map;

import static home.automation.martha.actor.Action.OFF;
import static home.automation.martha.actor.Action.ON;

public class TvCommands {
    private static Map<Action, String> actionCommand = new HashMap<Action, String>() {
        {
            put(ON, "*SCPOWR0000000000000001");
            put(OFF, "*SCPOWR0000000000000000");

        }
    };

    public static String getCommandFor(Action action) {
        return actionCommand.get(action);
    }
}
