package home.automation.martha.actor.tv;

public class TvOffCommand implements Command {

    private Tv tv;

    public TvOffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}
