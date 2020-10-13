package com.zr.template.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 曾睿
 * @Date: 2020/6/3 09:32
 */

public interface StorageService {

    /**
     * 文件上传
     * @param file
     * @return
     */
    String storeFile(MultipartFile file);

    Resource loadFileAsResource(String fileName);

}
