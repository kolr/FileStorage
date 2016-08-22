package com.cloud.entities.beans;

/**
 * 22.08.2016
 * Created by Rodion.
 */
public class ClientFileBean {
    private String name;
    private long size;

    private ClientFileBean(Builder builder) {
        this.name = builder.name;
        this.size = builder.size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public static class Builder {
        private String name;
        private long size;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder size(long size) {
            this.size = size;
            return this;
        }

        public ClientFileBean build() {
            return new ClientFileBean(this);
        }
    }
}
