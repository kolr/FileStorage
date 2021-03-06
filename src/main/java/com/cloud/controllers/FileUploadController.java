package com.cloud.controllers;

import com.cloud.entities.User;
import com.cloud.entities.beans.ClientFileBean;
import com.cloud.exceptions.user.UserNotLoggedInException;
import com.cloud.services.FileService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by nikit on 14.08.2016.
 */
@Controller
public class FileUploadController {
    private static final Logger LOGGER = Logger.getLogger(FileUploadController.class);

    @Inject
    private FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public
    @ResponseBody
    String provideUploadInfo() {
        return "You can load file from URL.";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(MultipartHttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        MultipartFile file = request.getFile("file");

        try {
            fileService.uploadFile(user, file);
        } catch (IOException e) {
            LOGGER.error(e);
        } catch (UserNotLoggedInException e) {
            LOGGER.error(e);
        }
        return "redirect:/files";
    }

    @RequestMapping(value = "/file/new", method = RequestMethod.POST)
    public String createFile(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String fileName = request.getParameter("fileName");

        try {
            fileService.createFile(user, fileName);
        } catch (IOException e) {
            LOGGER.error(e);
        } catch (UserNotLoggedInException e) {
            LOGGER.error(e);
        }
        return "redirect:/files";
    }

    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public String getFiles(HttpServletRequest request) {
        List<ClientFileBean> files = null;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            files = fileService.getAllFiles(user.getFolder());
            request.getSession().setAttribute("files", files);
        }
        return "redirect:/user/home_page";
    }

    @RequestMapping(value = "/files/file/remove", method = RequestMethod.POST)
    public String removeFile(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String fileName = request.getParameter("fileName");
        try {
            fileService.removeFile(user, fileName);
            LOGGER.info(String.format("File '%s' of %s %s has been removed", fileName,
                    user.getName(), user.getLastName()));
        } catch (IOException e) {
            LOGGER.error(e);
        } catch (UserNotLoggedInException e) {
            LOGGER.error(e);
        }
        return "redirect:/files";
    }

    @RequestMapping(value = "/files/file/edit", method = RequestMethod.POST)
    public String editFileName(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String fileName = request.getParameter("fileName");
        String newFileName = request.getParameter("newFileName");
        try {
            fileService.editFile(user, fileName, newFileName);
            LOGGER.info(String.format("File '%s' of %s %s has been removed", fileName,
                    user.getName(), user.getLastName()));
        } catch (IOException e) {
            LOGGER.error(e);
        } catch (UserNotLoggedInException e) {
            LOGGER.error(e);
        }
        return "redirect:/files";
    }


}
