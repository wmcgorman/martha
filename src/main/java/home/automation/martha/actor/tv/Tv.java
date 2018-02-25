package home.automation.martha.actor.tv;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Tv {

    private final String ip;

    public Tv(String ip) {
        this.ip = ip;
    }

    public void turnOn() {
        execute("*SCPOWR0000000000000001");
    }

    public void turnOff() {
        execute("*SCPOWR0000000000000000");
    }

    public void setVolume(String volume) {
        if(volume.length() != 2) {
            volume = "0" + volume;
        }

        execute("*SCVOLU00000000000000" + volume);
    }

    private void execute(String commandCode) {
        try (Socket echoSocket = new Socket(ip, 20060)) {
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            out.println(commandCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
