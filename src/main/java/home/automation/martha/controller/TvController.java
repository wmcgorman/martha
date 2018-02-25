package home.automation.martha.controller;

import home.automation.martha.actor.Action;
import home.automation.martha.actor.Metadata;
import home.automation.martha.actor.tv.TvActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TvController {

    @Autowired
    private Environment env;

    @RequestMapping("/tv/{identifier}/{action}")
    void act(@PathVariable("identifier") String identifier,
            @PathVariable("action") Action action) {
        TvActor actor = new TvActor();

        String tvIp = env.getProperty("tv."+identifier);

        Metadata metadata = new Metadata(tvIp, action);
        actor.takeAction(metadata);
    }
}
