package com.my.sa.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The Class AliyunOSSProperties
 * 阿里云OSS服务配置信息
 * 项目启动时，由application.properties里的数据自动进行初始化
 */
@ConfigurationProperties(prefix = "aliyun.oss", ignoreUnknownFields = false)
public class AliyunOSSProperties {

    private String endpoint;
    private String bucketName;
    private String accessKeyId;
    private String accessKeySecret;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}
