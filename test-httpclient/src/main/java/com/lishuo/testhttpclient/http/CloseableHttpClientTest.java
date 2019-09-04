package com.lishuo.testhttpclient.http;
import java.io.*;

import com.lishuo.testhttpclient.config.GetByteEncode;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-25 11:24
 */

public class CloseableHttpClientTest {

    public static void doGet() {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("http://www.thepaper.cn");
        try {
            // 很奇怪，使用CloseableHttpClient来请求澎湃新闻的首页，GTE请求也必须加上下面这个Header，但是使用HTTPClient则不需要
            get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
            HttpResponse response = client.execute(get);
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {



        String ip = "192.168.182.91";
        String port = "20001";



        byte [] bt=testPost(ip,port,image2Bytes("D:\\testimage.png"));
        String encoding = GetByteEncode.getEncoding(bt);
        System.out.println("字符编码是：" + encoding);
        System.out.println("原乱码输出：" + new String(bt));
        System.out.println("//***********************//");
        System.out.println("根据文件编码输出：" + new String(bt, encoding));
    }

    public static byte[] testPost(String ip, String port, byte[] filecontent) {
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpPost uploadFile = new HttpPost("http://" + ip + ":" + port);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            // 把文件加到HTTP的post请求中
            builder.addBinaryBody(
                    "file",
                    filecontent,
                    ContentType.APPLICATION_OCTET_STREAM,
                    "file"
            );
            org.apache.http.HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);
            response = httpClient.execute(uploadFile);
            InputStream is=response.getEntity().getContent();
            byte[] buffer=new byte[1024];
            int len=0;
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            while((len=is.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            bos.flush();
            return bos.toByteArray();
            /*org.apache.http.HttpEntity responseEntity = response.getEntity();
            String result = EntityUtils.toString(responseEntity, "gbk");
            result = java.net.URLDecoder.decode(result, "gb2312");
            String body = getContent("A", result);*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    public static byte[] image2Bytes(String imgSrc) {
        FileInputStream fin;
        byte[] bytes = null;
        try {
            fin = new FileInputStream(new File(imgSrc));
            bytes = new byte[fin.available()];
            //将文件内容写入字节数组
            fin.read(bytes);
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bytes;
    }
}


