package com.lishuo.testconfig.base;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TestTwo {
    //有向图的邻接矩阵表示法
    static int [] [] matrix = {
            {1,1,1,1,0,0,0},
            {0,1,0,1,1,0,0},
            {0,0,1,0,0,1,0},
            {0,0,1,1,0,1,1},
            {0,0,0,1,1,0,1},
            {0,0,0,0,0,1,0},
            {0,0,0,0,0,1,1} };

    static int [] indegree = new int [7];
    static int [] num = new int [7];

    static void topsort() {
        Queue<Integer> q = new LinkedList<>();
        int counter = 0;

        for(int i = 0; i < 7; i++)
            if (indegree[i] == 0)
                q.offer(i);

        while( !q.isEmpty() ) {
            int v = q.poll();
            num[v] = counter++;

            for(int i = 0; i < 7; i++)
                if(v != i && matrix[v][i] == 1 && --indegree[i] == 0)
                    q.offer(i);
        }
    }

    public static void main(String [] args) {
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++)
                if(matrix[j][i] == 1)
                    indegree[i]++;
            indegree[i]--;
        }

        topsort();
        System.out.println("各点拓扑编号：" + Arrays.toString(num));
    }

}