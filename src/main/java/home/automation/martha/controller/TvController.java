package home.automation.martha.controller;

import home.automation.martha.actor.tv.Command;
import home.automation.martha.actor.tv.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TvController {

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/tv/{identifier}", method = POST)
    void respond(@PathVariable("identifier") String identifier,
             @RequestBody ActionRequest requestBody) {

        String tvIp = environment.getProperty("tv."+identifier);
        Command command = CommandFactory.getCommandFor(requestBody, tvIp);
        command.execute();
    }
}
