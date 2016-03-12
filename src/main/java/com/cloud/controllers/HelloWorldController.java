package com.cloud.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ${APP}
 * Created by Rodion on 10.03.2016.
 */

@Controller
public class HelloWorldController {
    private static final Logger LOGGER = Logger.getLogger(HelloWorldController.class);

    static {
        LOGGER.info("HelloWorldController initialized.");
        LOGGER.info("Nikita joined");
        LOGGER.info("Welcome, Nikita");
        LOGGER.info("I`m glad to be here");
        LOGGER.info("What's up?");
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("greeting", "Hello Cloud");
        return "homepage";
    }
}
