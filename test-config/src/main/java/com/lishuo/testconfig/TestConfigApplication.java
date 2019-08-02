package com.lishuo.testconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*@SpringBootApplication
@EnableDiscoveryClient*/
public class TestConfigApplication {


    public static void main(String[] args) {
    /*    SpringApplication.run(TestConfigApplication.class, args);*/
        int [] a ={1,22,33,44,55,66};

        System.out.println(a[Binary_Search(a,a.length,44)]);

    }

    /***
     *
     * @param a 数组原型
     * @param n 数组长度
     * @param key 目标数
     * @return
     */

   static int Binary_Search(int [] a,int n,int key)
    {
        int low,high,mid;
        low=1;
        high=n;

        while(low<=high)
        {
            mid=(low+high)/2;
            if(key<a[mid])
                high=mid-1;
            if(key>a[mid])
                low=mid+1;
            else
                return mid;
        }
        return 0;
    }

}
