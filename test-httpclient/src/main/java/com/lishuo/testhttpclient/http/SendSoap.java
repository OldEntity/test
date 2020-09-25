package com.lishuo.testhttpclient.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program：test-httpclient
 * @Description：发送webservices请
 * @Author：LearnLi
 * @Create:2020-08-26 02:38
 */

public class SendSoap {
    public static void main(String[] args) {

        String soapXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:iim=\"http://ws.itf.imag.nc/IImageInterfaceService\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <iim:imageInterfaceService>\n" +
                "         <iim:string><![CDATA[ <?xml version='1.0' encoding='GBK'?><params><factorycode>shy</factorycode><servername>imageStateChange</servername><datasource>ncctest06</datasource><billinfo><datasource>ncctest06</datasource><billcode>1001A81000000005W16Y</billcode><state>1</state><billtype>F1-Cxx-07</billtype><pk_billtype>F1</pk_billtype><imagenum>23</imagenum><OrgNo>0001A210000000001LBL</OrgNo><groupid>0001A11000000000099S</groupid><opuserdatetime>2020-08-26 02:27:50</opuserdatetime><opusername>孟成</opusername><opuserpk>1001A21000000001B7R2</opuserpk><opuseraccount>0106132</opuseraccount><scantype>1</scantype></billinfo></params> ]]></iim:string>\n" +
                "      </iim:imageInterfaceService>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        sendSoapByHttpClient("http://122.144.221.6:12006/uapws/service/nc.imag.itf.ws.IImageInterfaceService?wsdl",soapXml);
    }


    public static String sendSoapByHttpClient(String urlStr, String connectStr) {
        String result = "";
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {

                if (null != urlStr && urlStr.contains("?wsdl")) {
                    urlStr = urlStr.split("\\?wsdl")[0];
                }
                HttpPost httpPost = new HttpPost(urlStr);
                httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
                httpPost.setHeader("Connection", "keep-alive");
                httpPost.setEntity(new StringEntity(connectStr));

                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity);
                System.out.println(result);
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
