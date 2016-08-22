package com.cloud.controllers;

import com.cloud.entities.User;
import com.cloud.exceptions.user.UserNotLoggedInException;
import com.cloud.services.FileService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.inject.Inject;


/**
 * Created by nikit on 14.08.2016.
 */

@Controller
public class FileUploadController {
    private static final Logger LOGGER = Logger.getLogger(FileUploadController.class);

    @Inject
    private FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can load file from URL.";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(MultipartHttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        MultipartFile file = request.getFile("file");

        try {
            fileService.uploadFile(user, file);
        } catch (IOException e) {
            LOGGER.error(e);
            return "bad file";
        } catch (UserNotLoggedInException e) {
            LOGGER.error(e);
            return "bad file";
        }
        return "good file";
    }

}
