package com.lishuo.svc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-04-30 09:45
 */

public class DateUtil {



    public static String getYMD(Date date) {
        String strYMD = "";
        //Date currentDateTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        strYMD = formatter.format(date);
        return strYMD;
    }

    public static Date stringToDate(String str, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            // Fri Feb 24 00:00:00 CST 2012
            date = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
