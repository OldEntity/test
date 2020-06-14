package com.lishuo.testjava.Lambda.main;

import com.lishuo.testjava.Lambda.api.Person;
import com.lishuo.testjava.pojo.Tbuser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-12 14:54
 */
interface BuilderMessage {
    String buildeMessage();
}

public class Main {


    public static void main(String[] args) {

        List<Tbuser> list = new ArrayList<>();
        list.add(new Tbuser("admin", "admin", "Learnli", "0", 22));
        list.add(new Tbuser("user", "user", "比企谷", "1", 15));
        list.add(new Tbuser("user1", "user", "雪之下", "1", 16));
        list.add(new Tbuser("user2", "user", "步", "1", 15));
        Integer s=1;
        s=2;
//        list.stream().forEach(tbuser -> System.out.println(tbuser.getAge()));
        list.stream().forEach(tbuser ->{
//            System.out.println(s);
                //s=tbuser.getAge();
                }
        );

//        System.out.println(Main.class.getClass().toString());
//        System.out.println(merge(chineseOfArr(new String[]{"贰零壹捌","零壹拾","壹拾陆"})));
//        System.out.println(moneyUtil(" $ 123 456 "));
        File file = new File("d:write.txt");
        File file1 = new File("d:sss.txt");


        try {
            copy_1(file, file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void copy_1(File src, File desc) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }
        fos.close();
        fis.close();
    }


/*


    static String moneyUtil(String str){
        String money=str.replaceAll(" " ,"");
        System.out.println(money);
        String m="";
        String symbol="";
        for (int i=0;i<money.length();i++){
            if(money.charAt(i)=='$'){
                symbol="$";
            }else if(money.charAt(i)=='￥'){
                symbol="￥";
            }
            if(Character.isDigit(money.charAt(i))){
                m+=String.valueOf(money.charAt(i));
            }

        }
        if(!"".equals(m)){
            Double res=Double.valueOf(m)/100;
            m=res.toString();
        }

        return symbol+m;
    }

    static String merge(List<int[]> list){
        String resStr="";
        for (int i=0;i<list.size();i++){
            String date="";

            if(i==0){
                for (Integer num:list.get(i)) {
                    date+=num.toString();
                }
            }else{
                if(list.get(i).length<3){
                    for (Integer num:list.get(i)) {
                        date+=num.toString();
                    }
                }else{
                    date=String.valueOf(list.get(i)[0]*list.get(i)[1]+list.get(i)[2]);
                }
            }

            if(i==list.size()-1){
                resStr+=date;
            }else{
                resStr+=date+"-";
            }
        }
        return resStr;
    }

    static List<int[]> chineseOfArr(String [] strs){
        List<int []> list=new ArrayList();
        for(int i=0;i<strs.length;i++){
            int [] num=new int[strs[i].length()];
            for (int j=0;j<strs[i].length();j++){
                num[j]=chineseOfNumber(strs[i].charAt(j));
            }
            list.add(num);
        }
        return list;

    }
    static int chineseOfNumber(char str){
        int result=-1;
        switch(str){
            case '零': result=0; break;
            case '壹': result=1; break;
            case '贰': result=2; break;
            case '叁': result=3; break;
            case '肆': result=4; break;
            case '伍': result=5; break;
            case '陆': result=6; break;
            case '柒': result=7; break;
            case '捌': result=8; break;
            case '玖': result=9; break;
            case '拾': result=10;break;
        }
        return result;
    }
*/


}


