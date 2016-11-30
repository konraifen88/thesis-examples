package sample.controller;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sample.service.RabbitMessageSender;


/**
 * If everything works right this class was
 * created by konraifen88 on 26.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@RestController
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "revert-service")
@Data
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebApplicationController {

    private final Logger log = LoggerFactory.getLogger(WebApplicationController.class);

    private String queue;

    @NonNull
    private RabbitMessageSender sender;

    @RequestMapping(value = "/admin")
    public String adminOnly() {
        return "This is an admin only Page";
    }

    @RequestMapping(value = "/user")
    public String userOnly() {
        return "This is an user Page, but also available for admins";
    }

    @RequestMapping(value = "/reverse/{name}")
    @ResponseBody
    public String reverse(@PathVariable("name") String name) {
        log.debug("revert endpoint called", name);
        if (name == null) {
            name = "Hello World!";
        }
        String result = sender.sendMessage(queue, name);
        return "Sent " + name + " and received " + result;
    }
}
