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
 */
public class FileService {
    private static final String USER_ERROR_WHILE_UPLOAD = "To add the file to system user must be logged in.";
    private static final String USER_ERROR_WHILE_CREATE = "To create a file in system user must be logged in.";
    private static final String USER_ERROR_WHILE_GET = "To get files user must be logged in.";


    public void uploadFile(User user, MultipartFile file) throws IOException, UserNotLoggedInException {
        if (user == null) {
            throw new UserNotLoggedInException(USER_ERROR_WHILE_UPLOAD);
        }

        Path.Builder pathBuilder = new Path.Builder();
        File uploaded = new File(pathBuilder.rootPath(Constants.ROOT_PATH).userPath(user.getFolder()).
                fileName(file.getOriginalFilename()).build());
        FileOutputStream fos = null;
        uploaded.createNewFile();
        fos = new FileOutputStream(uploaded);
        fos.write(file.getBytes());
        fos.close();
    }

    public void createFile(User user, String fileName) throws IOException, UserNotLoggedInException {
        if (user == null) {
            throw new UserNotLoggedInException(USER_ERROR_WHILE_CREATE);
        }

        Path.Builder pathBuilder = new Path.Builder();
        File uploaded = new File(pathBuilder.rootPath(Constants.ROOT_PATH).userPath(user.getFolder()).
                fileName(fileName).build() + ".txt");
        uploaded.createNewFile();
    }

    public List<ClientFileBean> getAllFiles(String currentPath) {
        List<ClientFileBean> result = new ArrayList<ClientFileBean>();
        Path.Builder builder = new Path.Builder();
        File directory = new File(builder.rootPath(Constants.ROOT_PATH).userPath(currentPath).build());
        for (File file : directory.listFiles()) {
            ClientFileBean temp = new ClientFileBean.Builder().name(file.getName()).size(123).build();
            result.add(temp);
        }
        return result;
    }
}
