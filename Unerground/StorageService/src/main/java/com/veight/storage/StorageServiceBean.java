/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.storage;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author youyou
 */
@Stateless
public class StorageServiceBean implements StorageService {

    private String accessKeyId = "layxLTN9MH2KNMVZ";

    private String accessKeySecret = "naPTLOX6ginM2E0dtUZrRgbCAnWtiq";

    private String bucketName = "vi8";
    // 以杭州为例
    private String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";

    OSSClient client = null;

    @Inject
    Logger logger;

    @PostConstruct
    public void init() {
        //读取阿里云的配置文件信息
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 上传文件 上传到阿里云的文件名又系统随机生成
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public String putObject(File file) throws FileNotFoundException {
        //UUID的文件名
        String OSSFileName = UUID.randomUUID().toString();

        // 获取指定文件的输入流
        InputStream content = new FileInputStream(file);

        // 创建上传Object的Metadata
        ObjectMetadata meta = new ObjectMetadata();

        // 必须设置ContentLength
        meta.setContentLength(file.length());

        // 上传Object.
        PutObjectResult result = client.putObject(bucketName, OSSFileName, content, meta);
        // 打印ETag
//	return result.getETag();
        return OSSFileName;
    }
    
    

}
