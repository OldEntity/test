package com.lishuo.testjava.sqlscript.util;

import com.lishuo.testjava.common.common.DataSourceFactory;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;


/**
 * @Program：test-java
 * @Description：sql执行脚本
 * @Author：LearnLi
 * @Create:2020-08-21 17:05
 */

public class SqlScript {


    /**
     * 执行sql脚本文件 使用Spring工具类
     */
    public void runSqlBySpringUtils(String sqlPath) throws Exception {
        try {


           Connection conn= DataSourceFactory.getInstance().getConnection("127.0.0.1:1521/XE","yx","yx");
            ScriptRunner runner = new ScriptRunner(conn);
            runner.setEscapeProcessing(false);
            runner.setSendFullScript(true);
            runner.runScript(new InputStreamReader(new FileInputStream(sqlPath), "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
