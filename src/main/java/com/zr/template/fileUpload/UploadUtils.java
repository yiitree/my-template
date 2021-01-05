package com.zr.template.fileUpload;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

/**
 * 文件上传工具包
 */
public class UploadUtils {

    /**
     * 获取格式 /2020/10/，用于区分上传目录
     * @return 获取格式
     */
    public static String getTimePaperFormat() {
        Calendar c = Calendar .getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        return "/" + year + "/" + (month+1) + "/";
    }

    /**
     * 获取文件后缀名
     * @param name 文件名   xxx.jpg
     * @return 文件后缀     .jpg
     */
    public static String getFileSuffix(String name){
        name = name.replace('\\', '/');
        name = name.substring(name.lastIndexOf("/") + 1);
        int index = name.lastIndexOf(".");
        String ext = null;
        if (index >= 0) {
            ext = StringUtils.trimToNull(name.substring(index + 1));
        }
        return ext;
    }

    /**
     * 自动按照时间为前缀修改保存文件名称
     * 获取上传位置 + 文件名称
     * @param name 文件名
     * @param path 文件保存路径
     * @param pathPrefix 文件保存前缀
     * @return
     */
    public static String getFileFKey(String name,String path,String pathPrefix){
        // 用于文件名，防止重复
        String uuid = UUID.randomUUID().toString();
        // 获取日期前缀
        String datePrefix = getTimePaperFormat();
        String absPath = pathPrefix + path + datePrefix;
        if (!new File(absPath).exists()) {
            new File(absPath).mkdirs();
        }
        //获取当前文件后缀
        String suffix = getFileSuffix(name);
        return path + datePrefix + uuid + "." + suffix;
    }

    /**
     * 自定义上传文件名称
     * 获取上传位置 + 文件名称
     * @param name 文件名
     * @param path 文件保存路径
     * @return
     */
    public static String getMyFileFKey(String myName, String name,String path,String pathPrefix){
        //用于文件名，防止重复
        String uuid = myName;
        //获取日期前缀
        String datePrefix = getTimePaperFormat();
        String absPath = pathPrefix + path + datePrefix;
        if (!new File(absPath).exists()) {
            new File(absPath).mkdirs();
        }
        //获取当前文件后缀
        String suffix = getFileSuffix(name);
        return path + datePrefix + uuid + "." + suffix;
    }

    /**
     * 新建目录组装路径 + 名称
     * @param fKey
     * @return
     */
    public static String getFilePath(String fKey,String pathPrefix) {
        fKey = StringUtils.trimToNull(fKey);
        if (fKey == null) {
            return null;
        } else {
            return pathPrefix + fKey;
        }
    }

    public static String getFileShowPath(String fkey,String pathPrefix,String scheme){
        String prefix = scheme;
        if(fkey.contains(pathPrefix)){
            fkey = fkey.replaceAll(pathPrefix,"");
        }
        if(StringUtils.isBlank(fkey)){
            return null;
        }
        if(fkey.contains("http")){
            return fkey;
        }
        return prefix + "/files/" + fkey;
    }

}


