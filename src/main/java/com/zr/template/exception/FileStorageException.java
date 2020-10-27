package com.zr.template.exception;

/**
 * @Author: 曾睿
 * @Date: 2020/6/3 09:33
 */
public class FileStorageException extends RuntimeException {

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
