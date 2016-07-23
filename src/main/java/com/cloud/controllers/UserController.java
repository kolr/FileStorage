package com.cloud.controllers;

import com.cloud.entities.User;
import com.cloud.entities.beans.SignInBean;
import com.cloud.dao.UserService;
import org.apache.log4j.Logger;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Inject
    UserService userService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        SignInBean credentials = new SignInBean(email, pass);
        LOGGER.info(credentials);
        //User user = userService.get(Integer.valueOf(credentials.getEmail()));
        User user = userService.get(credentials.getEmail());
        LOGGER.info("User:" + user);
        if (user != null) {
            if (user.getPassword().equals(pass)) {
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
        userService.add(newUser);
        model.addAttribute("lst", userService.getAll());
        return "users";
    }

    private User generateUser(HttpServletRequest request) {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setLastName(request.getParameter("lastName"));
        user.setPassword(request.getParameter("password"));
        return user;
    }

}
