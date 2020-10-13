package com.zr.template.service.impl;

import com.zr.template.config.FileStorageProperties;
import com.zr.template.exception.FileStorageException;
import com.zr.template.service.StorageService;
import com.zr.template.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

/**
 * @Author: 曾睿
 * @Date: 2020/6/3 09:34
 */
@Service
public class StorageServiceImpl implements StorageService {

    private final Path fileStorageLocation;

    /**
     * 指定配置的构造函数
     */
    @Autowired
    public StorageServiceImpl(FileStorageProperties fileStorageProperties) {
        // 设置文件保存路径---在原有基础上加入时间文件夹，用以区分
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir() + UploadUtils.getTimePaperFormat()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("无法创建上传文件存储的目录");
        }
    }

    /**
     * 上传文件
     * @param file 要上传的文件
     * @return 返回新文件名
     */
    @Override
    public String storeFile(MultipartFile file) {
        // 文件名原始名
        String originalFilename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        // 新文件名（防止文件重名）
        String newFileName = System.currentTimeMillis() + "." + UploadUtils.getFileSuffix(originalFilename);
        try {
            // 文件名不合法
            if(!"xlsx".contains(UploadUtils.getFileSuffix(originalFilename))){
                throw new FileStorageException("文件类型不合法");
            }
            Path targetLocation = this.fileStorageLocation.resolve(newFileName);
            // 如果文件重名会做替换操作
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            // 文件保存的绝对路径
            String string = targetLocation.toAbsolutePath().toString();
            return newFileName;
        } catch (IOException ex) {
            throw new FileStorageException("无法保存文件" + originalFilename + "请重试!", ex);
        }
    }

    /**
     * 文件下载
     * @param fileName
     * @return
     */
    @Override
    public Resource loadFileAsResource(String fileName) {
        try{
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()){
                return resource;
            }else{
                throw new FileStorageException("File not found" + fileName);
            }
        }catch (MalformedURLException ex){
            throw new FileStorageException("File not found" + fileName);
        }
    }
}
