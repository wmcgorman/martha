package home.automation.martha.actor.tv;

import home.automation.martha.actor.Metadata;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import static home.automation.martha.actor.tv.TvCommands.getCommandFor;

public class TvActor {

    public void takeAction(Metadata metadata) {
        try (Socket echoSocket = new Socket(metadata.getTarget(), 20060)) {
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            out.println(getCommandFor(metadata.getAction()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
