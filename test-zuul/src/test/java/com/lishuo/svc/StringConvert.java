package com.lishuo.svc;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-04-30 09:32
 */

public class StringConvert {




    private static final Log logger = LogFactory.getLog(StringConvert.class);

    private static final String fileName = "D:/csv.txt";

    private static final String fileName2 = "D:/csv2.txt";

    public static void main(String[] args) {

        //获取文件内容，读文件
        BufferedReader br = null;
        List<Pojo> list = new ArrayList<Pojo>();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "GB2312")); //这里可以控制编码
            String line = "";
            String[] linearry = null;
            Pojo c = null;
            logger.info("ll"+Bianma.getEncoding(line));
            while ((line = br.readLine()) != null) {


                logger.info("流读文件："+Bianma.getEncoding(line));


                linearry = StringSplit.commaDivider(line);
                c = new Pojo();
                //组装对象到对应数据类型


                String kk=linearry[0];
                logger.info(kk+Bianma.getEncoding(kk));


                /*logger.info("是否和String相同"+kk=="1");
                logger.info("Sting编码为"+Bianma.getEncoding("阿斯蒂芬"));
                logger.info("kk的编码为"+Bianma.getEncoding(kk));*/
                c.setA_int(Integer.parseInt("1"));
                c.setB_str("'" + linearry[1] + "'");
                c.setC_str("'" + linearry[2] + "'");
                c.setD_float(Float.parseFloat(linearry[3]));
                c.setE_date(DateUtil.getYMD(DateUtil.stringToDate(linearry[4], "YYYY-MM-DD")));
                list.add(c);
            }





        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //写入文件
        writeFile(list);

    }
    //写入文件
    public static void writeFile(List<Pojo> list) {

        File file = new File(fileName2);
        BufferedWriter bw = null;
        try {
            if (!file.exists()) { // 只处理不存在的文件
                logger.info("开始创建新文件。" + fileName2);
                file.createNewFile();// 文件不存在就新建一个文件出来
                bw = new BufferedWriter(new FileWriter(file));// 生成一个新文件
                int count = 0;
                for (Pojo c : list) {
                    String line = c.toString();
                    bw.write(line);
                    bw.newLine();
                    bw.flush();
                    count++;
                }
                logger.info("共写入" + count + "条");
            }

        } catch (IOException e) {
            logger.info("IO流异常", e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    logger.info("IO流关闭异常", e);
                }
            }
        }
    }
}
