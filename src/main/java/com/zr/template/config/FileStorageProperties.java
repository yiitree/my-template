package com.zr.template.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 文件上传相关自定义配置
 * @Author: 曾睿
 * @Date: 2020/6/3 09:18
 */
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

    /**
     * 上传路径
     */
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
