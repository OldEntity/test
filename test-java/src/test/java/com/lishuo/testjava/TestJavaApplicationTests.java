package com.lishuo.testjava;

import com.lishuo.testjava.pojo.Tbuser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJavaApplicationTests {






    @Test
    public void ecd() {



    }





    @Test
    public void contextLoads() {
        List<Tbuser> list = new ArrayList<>();
        list.add(new Tbuser("admin", "admin", "Learnli", "0", 22));
        list.add(new Tbuser("user", "user", "比企谷", "1", 15));
        list.add(new Tbuser("user1", "user", "雪之下", "1", 16));
        list.add(new Tbuser("user2", "user", "步", "1", 15));

        /**
         * 1.forEach()进行遍历集合
         *    item：可以是任意值。类似于for循环中的循环值
         */
        list.forEach(item -> {
            //设置值
            item.setNickname(item.getNickname() + "测试");
            //输出语句
            System.out.println(item.toString());
        });


        /**
         * 2.stream()流操作
         */

      /*  //2.1. 去重 distinct() 去重；collect(Collectors.toList())。封装成集合
        List<Tbuser> distinctList = list.stream().distinct().collect(Collectors.toList());


        //2.2 排序  sorted((第一个对象，第二个对象)->返回值)  （升降序看是第几个对象与第几个对象比较）
        List<Tbuser> sortedList = list.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).collect(Collectors.toList());

        //2.3 过滤 ， filter(item->{})   item为每一项。 按照自己的需求来筛选list中的数据
        List<Tbuser> filterList = list.stream().filter(item -> item.getAge() > 3).collect(Collectors.toList());

        //2.4 map(), 提取对象中的某一元素.  用每一项来获得属性（也可以直接用  对象::get属性()）
        List<String> mapList1 = list.stream().map(Person::getName).collect(Collectors.toList());
        List<String> mapList2 = list.stream().map(item -> item.getName()).collect(Collectors.toList());
        //2.5 统计 sum() 。mapToDouble() 转换成double。还有其他类型转换。可以自己研究。
        //           max(),min(),average()
        double sum = list.stream().mapToDouble(Person::getAge).sum();
        //2.6 分组   Collectors.groupingBy(属性名)
        Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));
        //2.7 多重分组 Collectors.groupingBy(属性，Collectors.groupingBy(属性))
        Map<String, Map<Integer, List<Person>>> map2 = list.stream().collect(Collectors.groupingBy(t -> t.getName(), Collectors.groupingBy(t -> t.getAge())));
        //2.8 分组并计算综合        Collectors.summarizingLong()
        Map<String, Map<Integer, LongSummaryStatistics>> map3 = list.stream().collect(Collectors.groupingBy(t -> t.getName(), Collectors.groupingBy(t -> t.getAge(), Collectors.summarizingLong(Person::getSize))));
*/
        /**
         *  3.  集合比较的简写方式
         */
        /*list.sort((o1, o2) -> {
            return o1.getAge() - o2.getAge();
        });*/
    }

    @Test
    public void test1() {

        String s1 = "张三";  //定义一个字符串张三
        try {
            byte[] b = s1.getBytes("GB2312");   //UTF-8的方式取出
            String s2 = new String(b, StandardCharsets.UTF_8);   //UTF_8的方法转成字符串
            System.out.println(s2);

            System.out.println(new String(s2.getBytes("GBK"), "GBK"));               //同样的方式转换成GBK编码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }



    @Test
    public void test2(){
        Map<String,String> map=new HashMap();
        System.out.println(map.containsKey("aa"));
    }

}


