package com.lishuo.testhttpclient.util;

import java.io.*;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-26 15:51
 */

public class TestImages {


    public static void main(String[] args) {
        tsetImage(getBytesByImagePath("C:\\Users\\Administrator\\Desktop\\TIM图片20190821102414.png"));
    }


    public static byte[] getBytesByImagePath(String imgSrc) {
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

    static void tsetImage(byte [] filecontent){
    OutputStream out;

    {
        try {
            String path="C:/Users/Administrator/Desktop/test/";
            Integer i=0;
            File file =new File(path+i.toString());

            while(file.exists()){
                i++;
                file=new File(path+i.toString());
            }
            System.out.println("打印出来是："+i);
            out = new FileOutputStream(path+i.toString());
            InputStream jjj = new ByteArrayInputStream(filecontent);
            byte[] buff = new byte[1024];
            int len = 0;
            while((len=jjj.read(buff))!=-1){
                out.write(buff, 0, len);
            }
            jjj.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }



}
