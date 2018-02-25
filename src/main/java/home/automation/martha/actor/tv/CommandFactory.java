package home.automation.martha.actor.tv;

import home.automation.martha.actor.Action;
import home.automation.martha.controller.ActionRequest;
import home.automation.martha.exception.InvalidRequestException;

public class CommandFactory {

    public static Command getCommandFor(ActionRequest actionRequest, String targetDevice) {
        if (actionRequest.getAction().equals(Action.ON)) {
            return new TvOnCommand(new Tv(targetDevice));
        } else if (actionRequest.getAction().equals(Action.OFF)) {
            return new TvOffCommand(new Tv(targetDevice));
        } else if(actionRequest.getAction().equals(Action.VOLUME)) {
            String volume = actionRequest.getMetadata().get("value");
            if(volume == null || volume.length() > 2) {
                throw new InvalidRequestException("Volume is mandatory and must be less than 100");
            }

            return new TvSetVolumeCommand(new Tv(targetDevice), actionRequest.getMetadata().get("value"));
        }

        return null;
    }

}
