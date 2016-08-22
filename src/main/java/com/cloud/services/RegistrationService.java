package com.cloud.services;

/**
 * Created by nikit on 26.07.2016.
 */

import com.cloud.Constants;
import org.apache.commons.lang.RandomStringUtils;

import java.io.File;

public class RegistrationService {

    public static String generateFolderName() {
        String result = RandomStringUtils.random(16, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
        return result;
    }

    public static void createDirectory(String path) {
        File newDirectory = new File(Constants.ROOT_PATH + path);
        if (!newDirectory.exists()) {
            newDirectory.mkdirs();
        }
    }

}
