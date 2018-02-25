package home.automation.martha.actor.tv;

public class TvSetVolumeCommand implements Command {

    private Tv tv;
    private String volume;

    public TvSetVolumeCommand(Tv tv, String volume) {
        this.tv = tv;
        this.volume = volume;
    }

    @Override
    public void execute() {
        tv.setVolume(volume);
    }
}
