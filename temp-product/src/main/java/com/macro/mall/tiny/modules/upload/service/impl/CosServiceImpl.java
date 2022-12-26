package com.macro.mall.tiny.modules.upload.service.impl;

import com.macro.mall.tiny.modules.upload.dto.CosCallbackResult;
import com.macro.mall.tiny.modules.upload.service.CosService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.CannedAccessControlList;
import com.qcloud.cos.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CosServiceImpl implements CosService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CosServiceImpl.class);

    @Value("${tencentyun.cos.bucketName}")
    private String TENCENTYUN_COS_BUCKET_NAME;
    @Value("${tencentyun.cos.endpoint}")
    private String TENCENTYUN_COS_ENDPOINT;
    @Value("${tencentyun.cos.dir.prefix}")
    private String TENCENTYUN_COS_DIR_PREFIX;

    @Autowired
    private COSClient cosClient;

    /**
     * 签名生成
     */
    @Override
    public CosCallbackResult upload(MultipartFile file) {
        CosCallbackResult result = new CosCallbackResult();

        try {
            String originalfileName = file.getOriginalFilename();

            // 获得文件流
            InputStream inputStream = file.getInputStream();
            // 存储目录
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dir = TENCENTYUN_COS_DIR_PREFIX + sdf.format(new Date()) + "/" + originalfileName;

            // 上传文件
            cosClient.putObject(new PutObjectRequest(TENCENTYUN_COS_BUCKET_NAME, dir, inputStream, null));
            cosClient.setBucketAcl(TENCENTYUN_COS_BUCKET_NAME, CannedAccessControlList.PublicRead);
            String action = "http://" + TENCENTYUN_COS_BUCKET_NAME + "." + TENCENTYUN_COS_ENDPOINT + "/" + dir;
            result.setUrl(action);
            result.setFilename(originalfileName);
            result.setSize(file.getSize());
            result.setMimeType(file.getContentType());
        } catch (Exception e) {
            LOGGER.error("上传失败", e);
        }
        return result;
    }
}
