package com.cloud.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Rodion on 10.03.2016.
 */

@Controller
public class HelloWorldController {
    private static final Logger LOGGER = Logger.getLogger(HelloWorldController.class);

    static {
        LOGGER.info("HelloWorldController initialized.");
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        LOGGER.info("Called hello() method.");
        model.addAttribute("greeting", "Hello Cloud");
        LOGGER.info("Passed model => " + model.toString());
        return "homepage";
    }
}
