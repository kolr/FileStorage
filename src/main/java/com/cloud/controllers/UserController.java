package com.cloud.controllers;

import com.cloud.entities.User;
import com.cloud.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * ${APP}
 * Created by Rodion on 11.03.2016.
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    static {
        LOGGER.info("Change");
    }

    @Inject
    UserService userService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(HttpServletRequest request, Model model) {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        User user = userService.getUser(login);
        if (user != null) {
            if (user.getPass().equals(pass)) {
                model.addAttribute("currentUser", user);
            } else {
                model.addAttribute("errorMessage", "Login or Password was entered not correctly.");
            }
        }
        return "acc";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(HttpServletRequest request, Model model) {
        User newUser = generateUser(request);
        userService.addUser(newUser);
        model.addAttribute("lst", userService.getALl());
        return "users";
    }

    @RequestMapping(value = "/{user}/all")
    public String getAllUsers(Model model, @PathVariable String user) {
        User admin = userService.getUser(user);
        if (admin != null) {

        }
        return "users";
    }

    private User generateUser(HttpServletRequest request) {
        User user = new User();
        user.setEmail(request.getParameter("login"));
        user.setName(request.getParameter("name"));
        user.setLastName(request.getParameter("lastName"));
        user.setPass(request.getParameter("pass"));
        return user;
    }

}
