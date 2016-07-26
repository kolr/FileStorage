package com.cloud.serveces;

/**
 * Created by nikit on 26.07.2016.
 */
import org.apache.commons.lang.RandomStringUtils;

import java.io.File;

public class RegistrationService {
    private static final String ROOT = "D:\\Cloud\\";
    //private static String path;
    
    public static String generateFolderName(){
        String result = RandomStringUtils.random(16, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
        return result;
    }
    public static void createDirectory(String path){
        File newDirectory = new File(ROOT + path);
        if (!newDirectory.exists()){
            newDirectory.mkdirs();
        }
    }

}
