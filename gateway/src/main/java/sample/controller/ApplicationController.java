package sample.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * If everything works right this class was
 * created by konraifen88 on 26.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Controller
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "service2")
public class ApplicationController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = {"/home", "/"})
    public String greetingHome() {
        return "home";
    }
}
