package com.zr.template.fileUpload;

/**
 * @Author: 曾睿
 * @Date: 2020/6/3 09:35
 */

import com.zr.template.common.RespBean;
import com.zr.template.domain.UploadFileResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class FileController {

    private final StorageService storageService;

    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }


    @PostMapping("/myUploadFile")
    public RespBean myUploadFile(@RequestParam("file") MultipartFile file){
        String url = storageService.myUploadFile(file);
        return RespBean.ok("解析成功",url);
    }

    /**
     * 文件上传
     * @param file 单个文件
     * @return 修改后的文件名
     */
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file){
        // 文件名
        String newFileName = storageService.storeFile(file);

        // 127.0.0.1:8080/xxx/文件名
        // 文件uri
        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/downloadFile/")
                .path(newFileName)
                .toUriString();
        return new UploadFileResponse(newFileName,fileDownloadUri,file.getContentType(),file.getSize());
    }

    /**
     * 多文件上传
     * @param files 多个文件的数组
     * @return
     */
    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        return Arrays.stream(files).map(this::uploadFile).collect(Collectors.toList());
    }

    /**
     * 文件下载
     * @param fileName
     * @param request
     * @return
     */
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        Resource resource = storageService.loadFileAsResource(fileName);

        String contentType = null;
        try{
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }catch (IOException ex){
            log.info("Could not determine file type");
        }

        if (contentType == null){
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
