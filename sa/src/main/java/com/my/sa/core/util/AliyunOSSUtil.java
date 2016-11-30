package com.my.sa.core.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.my.sa.configuration.properties.AliyunOSSProperties;

import eu.medsea.mimeutil.MimeUtil;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.UUID;

/**
 * 访问地址 http://incog-auction.img-cn-shanghai.aliyuncs.com/文件名
 */
public class AliyunOSSUtil {

    private static String endpoint = null;
    private static String accessKeyId = null;
    private static String accessKeySecret = null;
    private static String bucketName = null;
    private static String path = null;

    public static void init(AliyunOSSProperties aliyunOSS) {
        endpoint = aliyunOSS.getEndpoint();
        accessKeyId = aliyunOSS.getAccessKeyId();
        accessKeySecret = aliyunOSS.getAccessKeySecret();
        bucketName = aliyunOSS.getBucketName();
        path = "http://" + bucketName + ".img-" + endpoint.substring(4) + "/";
        MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
        System.out.println("Aliyun OSS Init...");
    }

    public static String upload(MultipartFile file) throws Exception {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(file.getInputStream());
        return upload(bufferedInputStream, file.getOriginalFilename());
    }

    public static String upload(InputStream inputStream, String fileName) throws Exception {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        return upload(bufferedInputStream, fileName);
    }

    public static String upload(BufferedInputStream bufferedInputStream, String fileName) throws Exception {
        if (endpoint == null || accessKeyId == null || accessKeySecret == null || bucketName == null) {
            throw new RuntimeException("Aliyun OSS:must invoke the init method!");
        }
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ObjectMetadata meta = new ObjectMetadata();
        Collection<?> mimeTypes = MimeUtil.getMimeTypes(bufferedInputStream);
        meta.setContentType(mimeTypes.toString());
        fileName = UUID.randomUUID().toString() + "." + fileName.split("\\.")[1];
        client.putObject(bucketName, fileName, bufferedInputStream);
        return path + fileName;
    }

}
