package com.cloud.controllers;

import com.cloud.entities.User;
import com.cloud.entities.beans.RegistrationBean;
import com.cloud.entities.beans.SignInBean;
import com.cloud.dao.UserService;
import com.cloud.exceptions.user.LoginAlreadyExistException;
import com.cloud.validation.ValidationManager;
import org.apache.log4j.Logger;
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

    @Inject
    ValidationManager validationManager;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        SignInBean credentials = new SignInBean(email, pass);
        if (validationManager.validate(credentials, SignInBean.class)) {
            User user = userService.get(credentials.getEmail());
            if (user != null) {
                request.getSession().setAttribute("user", user);
                model.addAttribute("currentUser", user);
            }
        } else {
            model.addAttribute("errorMessage", "Login or Password was entered not correctly.");
        }
        return "redirect:acc";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(HttpServletRequest request) {
        User registeredUser = null;
        RegistrationBean registrationBean = generateRegistrationBean(request);
        if (validationManager.validate(registrationBean, RegistrationBean.class)) {
            registeredUser = convertToUser(registrationBean);
            request.getSession().setAttribute("user", registeredUser);
            try {
                userService.add(registeredUser);
            } catch (LoginAlreadyExistException e) {
                LOGGER.error(e);
            }
        } else {
            LOGGER.error("An Error while validation occurred.");
        }
        return "redirect:acc";
    }

    @RequestMapping(value = "acc")
    public String getAccountPage(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("currentUser", user);
        } else {
            model.addAttribute("errorMessage", "Login or Password was entered not correctly!");
        }
        return "acc";
    }

    private RegistrationBean generateRegistrationBean(HttpServletRequest request) {
        RegistrationBean user = new RegistrationBean(request.getParameter("email"), request.getParameter("name"),
                request.getParameter("lastName"), request.getParameter("password"));
        return user;
    }

    private User convertToUser(RegistrationBean registrationBean) {
        User user = new User();
        user.setEmail(registrationBean.getEmail());
        user.setName(registrationBean.getName());
        user.setLastName(registrationBean.getLastname());
        user.setPassword(registrationBean.getPassword());
        return user;
    }

}
