package com.lishuo.ocr.http;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2020-03-27 16:39
 */

public class FileUtils {
//    multipart转file
    public static File multipartFileToFile(MultipartFile file) {

        File toFile = null;
        InputStream ins = null;
        try {
            if (file.equals("") || file.getSize() <= 0) {
                file = null;
            } else {
                ins = file.getInputStream();
                toFile = new File(file.getOriginalFilename());
                inputStreamToFile(ins, toFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ins)
                    ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return toFile;
    }


    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除本地临时文件
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }
}