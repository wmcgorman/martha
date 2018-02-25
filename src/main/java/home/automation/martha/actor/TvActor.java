package home.automation.martha.actor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wmcgorman on 24/02/2018.
 */
public class TvActor {

    public void act(Metadata metadata) {
        try (Socket echoSocket = new Socket(metadata.getTarget(), 20060)) {

            PrintWriter out =
                    new PrintWriter(echoSocket.getOutputStream(), true);

            out.println(TvActionMapper.getCommandFrom(metadata.getAction()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class TvActionMapper {

    private static Map<Action, String> actionCommand = new HashMap<Action, String>() {
        {
            put(Action.POWER_ON, "*SCPOWR0000000000000000");
            put(Action.POWER_OFF, "*SCPOWR0000000000000001");

        }
    };

    public static String getCommandFrom(Action action) {
        return actionCommand.get(action);
    }
}
