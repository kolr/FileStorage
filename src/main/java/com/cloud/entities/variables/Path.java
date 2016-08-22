package com.cloud.entities.variables;

import java.io.File;

/**
 * 22.08.2016
 * Created by Rodion.
 */
public class Path {
    private String rootPath;
    private String userPath;
    private String fileName;

    private Path(Builder builder) {
        this.rootPath = builder.rootPath;
        this.userPath = builder.userPath;
        this.fileName = builder.fileName;
    }

    public String getRootPath() {
        return rootPath;
    }

    public String getUserPath() {
        return userPath;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return rootPath + userPath + File.separator + fileName;
    }

    public static class Builder {
        private String rootPath = "";
        private String userPath = "";
        private String fileName = "";

        public Builder() {
        }

        public Builder rootPath(String rootPath) {
            this.rootPath = rootPath;
            return this;
        }

        public Builder userPath(String userPath) {
            this.userPath = userPath;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public String build() {
            return new Path(this).toString();
        }
    }
}
