package com.hashtech.config;

import com.hashtech.businessframework.exception.interval.AppException;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class FileParse {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucketName}")
    private String bucketName;

    private static final String DIR = "backend";


    public String uploadFile(MultipartFile file) {

        String filePath = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String path = LocalDateTime.now().format(formatter);
            String fileName = file.getOriginalFilename();
            fileName = DIR + '/' + path + '/' + fileName;
            PutObjectArgs objectArgs = PutObjectArgs.builder().object(fileName)
                    .bucket(bucketName)
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(),file.getSize(),-1).build();
            minioClient.putObject(objectArgs);
            log.info("文件上传成功");
            filePath =  fileName;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("文件上传失败，请重新上传");
            throw new AppException("文件上传失败");
        }
        return filePath;
    }
}
