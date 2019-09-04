package com.lishuo.testhttpclient.http;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Program：test
 * @Description：模拟get请求
 * @Author：LearnLi
 * @Create:2019-08-25 10:48
 */

public class SimulationHTTP {


    private static final Logger logger = LoggerFactory.getLogger(SimulationHTTP.class);

    /**
     * 模拟HttpGet 请求
     * @param url
     * @return
     */
    public static String simulationGet(String url){
        //单位毫秒
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(3000).setConnectTimeout(3000)
                .setSocketTimeout(3000).build();//设置请求的状态参数

        CloseableHttpClient httpclient = HttpClients.createDefault();//创建 CloseableHttpClient
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);//返回请求执行结果
            int statusCode = response.getStatusLine().getStatusCode();//获取返回的状态值
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            } else {
                String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                return result;
            }
        } catch (Exception e) {
            logger.error("httpget Exception handle-- > " + e);
        } finally {
            if (response != null){
                try {
                    response.close();//关闭response
                } catch (IOException e) {
                    logger.error("httpget IOException handle-- > " + e);
                }
            }
            if(httpclient != null){
                try {
                    httpclient.close();//关闭httpclient
                } catch (IOException e) {
                    logger.error("httpget IOException handle-- > " + e);
                }
            }
        }
        return null;
    }

}
