package com.macro.mall.tiny.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CosConfig {
    @Value("${tencentyun.cos.region}")
    private String TENCENTYUN_COS_REGION;
    @Value("${tencentyun.cos.secretId}")
    private String TENCENTYUN_COS_SECRETID;
    @Value("${tencentyun.cos.secretKey}")
    private String TENCENTYUN_COS_SECRETKEY;

    @Bean
    public COSClient cosClient() {
        COSCredentials cred = new BasicCOSCredentials(TENCENTYUN_COS_SECRETID, TENCENTYUN_COS_SECRETKEY);
        Region region = new Region(TENCENTYUN_COS_REGION);
        ClientConfig clientConfig = new ClientConfig(region);
        clientConfig.setHttpProtocol(HttpProtocol.https);
        return new COSClient(cred, clientConfig);
    }
}
