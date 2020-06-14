package com.lishuo.ocr.http;

import okhttp3.*;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;

/**
 * @Program：test
 * @Description：发送请求
 * @Author：LearnLi
 * @Create:2020-03-27 16:02
 */

public class SendRequest {




        private static TrustManager[] buildTrustManagers() {
            return new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void
                        checkClientTrusted(java.security.cert.X509Certificate[] chain, String
                                authType) {
                        }
                        @Override
                        public void
                        checkServerTrusted(java.security.cert.X509Certificate[] chain, String
                                authType) {
                        }
                        @Override
                        public java.security.cert.X509Certificate[]
                        getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };
        }
        public static String request(String appid, String secret, String type,File file,String url)
        {
            System.out.println("获得的URL地址使："+url);

            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("appid", appid)
                    .addFormDataPart("secret", secret)
                    .addFormDataPart("type", type)
                    .addFormDataPart("file", file.getName(),
                            RequestBody.create(MediaType.parse("image/*"), file))
                    .build();
            Request request = new Request.Builder()
                    .url("https://"+url+"/api/sync/recognition")
                    .post(requestBody)
                    .build();
            try {
                TrustManager[] trustAllCerts = buildTrustManagers();
                final SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, trustAllCerts, new
                        java.security.SecureRandom());
                final SSLSocketFactory sslSocketFactory =
                        sslContext.getSocketFactory();
                OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
                okHttpClient.sslSocketFactory(sslSocketFactory,
                        (X509TrustManager) trustAllCerts[0]);
                okHttpClient.hostnameVerifier((hostname, session) -> true);
                Response response =
                        okHttpClient.build().newCall(request).execute();
                return response.body().string();
            } catch(Exception e){
                return "error";
            }
        }


}
