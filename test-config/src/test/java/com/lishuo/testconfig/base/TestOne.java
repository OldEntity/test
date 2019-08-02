package com.lishuo.testconfig.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-05-07 11:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOne {


    @Test
    public void test1(){
        String ll;

    }



     int Binary_Search(int [] a,int n,int key)
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
