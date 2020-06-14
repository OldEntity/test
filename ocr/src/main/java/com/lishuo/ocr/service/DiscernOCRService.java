package com.lishuo.ocr.service;

import com.alibaba.fastjson.JSON;
import com.lishuo.ocr.constant.ResultBean;
import com.lishuo.ocr.http.FileUtils;
import com.lishuo.ocr.http.SendRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @Program：test
 * @Description：识别ocr业务类
 * @Author：LearnLi
 * @Create:2020-03-27 16:22
 */
@Service
public class DiscernOCRService {

    @Value("${ocr.appid}")
    private String appid;
    @Value("${ocr.secret}")
    private String secret;
    @Value("${ocr.url}")
    private String url;


    Logger logger=LoggerFactory.getLogger(DiscernOCRService.class);
    public Object GetDiscernDetail(String discernType, MultipartFile multipartFile){
        Object data="";
        try {
            logger.info("[-------进入业务处理类]");
            File file= FileUtils.multipartFileToFile(multipartFile);
            data=SendRequest.request(appid,secret,discernType,file,url);
        } catch (Exception e) {

            logger.error("[-------文件转换失败或发送请求失败！]"+e.getMessage());
        }

            return data;
    }

}
