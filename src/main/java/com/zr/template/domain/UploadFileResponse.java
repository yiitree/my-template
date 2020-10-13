package com.zr.template.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 曾睿
 * @Date: 2020/6/3 09:36
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UploadFileResponse {

    // 文件名
    private String fileName;

    // 文件路径
    private String fileDownloadUri;

    // 文件类型
    private String fileType;

    // 文件大小
    private long fileSize;

}
