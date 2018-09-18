package com.zhiyou100.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import org.springframework.stereotype.Service;

import java.io.*;

public class OosUtil {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
 /*   private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private static  String accessKeyId = "LTAI7Vt6bpcpJGmT";
    private static String accessKeySecret = "4qzEJ1uk4emHCQAhCotOQb8GljVkgd";*/
    static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
    static final String accessKeyId = "LTAIsfClaxuTJSlp";
    static final String accessKeySecret = "IuDpvhV0Fgb7F6iQaz5qMWnNte3Dyh";

    /***
     * 上传文件
     * @param bucketName
     * @param objectName
     * @param inputStream
     */
    //lhwapartment
    public static void uploading(String bucketName, String objectName, InputStream inputStream) {

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 上传文件流。
        ossClient.putObject(bucketName, objectName, inputStream);
// 关闭OSSClient。
        ossClient.shutdown();
    }

    /***
     * 获取文件
     * @param bucketName
     * @param objectName
     */
    public static void download(String bucketName, String objectName, String target) {
        //创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(target));
// 关闭OSSClient。
        ossClient.shutdown();
    }


}
