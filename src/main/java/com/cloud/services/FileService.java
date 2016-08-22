package com.cloud.services;

import com.cloud.Constants;
import com.cloud.entities.User;
import com.cloud.entities.beans.ClientFileBean;
import com.cloud.entities.variables.Path;
import com.cloud.exceptions.user.UserNotLoggedInException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 22.08.2016
 * Created by Rodion.
 *
 * Basic module for processing user's files.
 */
public class FileService {
    private static final String USER_ERROR_WHILE_UPLOAD = "To add the file to system user must be logged in.";
    private static final String USER_ERROR_WHILE_CREATE = "To create a file in system user must be logged in.";

    /**
     * Uploads single file to server from client.
     *
     * @param user - user, who uploaded file.
     * @param file - uploaded file.
     * @throws IOException - throws if errors with file has been occurred.
     * @throws UserNotLoggedInException - throws if user has not been logged in.
     */
    public void uploadFile(User user, MultipartFile file) throws IOException, UserNotLoggedInException {
        if (user == null) {
            throw new UserNotLoggedInException(USER_ERROR_WHILE_UPLOAD);
        }

        File uploaded = new File(new Path.Builder().rootPath(Constants.ROOT_PATH).userPath(user.getFolder()).
                fileName(file.getOriginalFilename()).build());
        uploaded.createNewFile();
        FileOutputStream fos = new FileOutputStream(uploaded);
        fos.write(file.getBytes());
        fos.close();
    }

    /**
     * Creates single file to server from client. (Just *.txt format)
     *
     * @param user - user, who creates file.
     * @param fileName - new file name.
     * @throws IOException - throws if errors with file has been occurred.
     * @throws UserNotLoggedInException - throws if user has not been logged in.
     */
    public void createFile(User user, String fileName) throws IOException, UserNotLoggedInException {
        if (user == null) {
            throw new UserNotLoggedInException(USER_ERROR_WHILE_CREATE);
        }

        File file = new File(new Path.Builder().rootPath(Constants.ROOT_PATH).userPath(user.getFolder()).
                fileName(fileName).build() + ".txt");
        file.createNewFile();
    }

    /**
     * Uploads single file to server from client.
     *
     * @param currentPath - directory, where to look for files.
     */
    public List<ClientFileBean> getAllFiles(String currentPath) {
        List<ClientFileBean> result = new ArrayList<ClientFileBean>();
        File directory = new File(new Path.Builder().rootPath(Constants.ROOT_PATH).userPath(currentPath).build());
        for (File file : directory.listFiles()) {
            ClientFileBean temp = new ClientFileBean.Builder().name(file.getName()).size(123).build();
            result.add(temp);
        }
        return result;
    }

    /**
     * Removes single file from server.
     *
     * @param user - user, who removes file.
     * @param fileName - removed file name.
     * @throws IOException - throws if errors with file has been occurred.
     * @throws UserNotLoggedInException - throws if user has not been logged in.
     */
    public void removeFile(User user, String fileName) throws IOException, UserNotLoggedInException {
        if (user == null) {
            throw new UserNotLoggedInException(USER_ERROR_WHILE_UPLOAD);
        }

        File file = new File(new Path.Builder().rootPath(Constants.ROOT_PATH).userPath(user.getFolder()).
                fileName(fileName).build());
        file.delete();
    }

    public boolean editFile(User user, String fileName, String newFileName) throws IOException, UserNotLoggedInException {
        if (user == null) {
            throw new UserNotLoggedInException(USER_ERROR_WHILE_UPLOAD);
        }

        File file = new File(new Path.Builder().rootPath(Constants.ROOT_PATH).userPath(user.getFolder()).
                fileName(fileName).build());
        File newFile = new File(new Path.Builder().rootPath(Constants.ROOT_PATH).userPath(user.getFolder()).
                fileName(newFileName).build());
        return file.renameTo(newFile);
    }
}
