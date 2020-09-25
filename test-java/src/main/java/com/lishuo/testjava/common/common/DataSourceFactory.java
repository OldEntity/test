package com.lishuo.testjava.common.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * @Program：imagesystem
 * @Description：获得数据库连接
 * @Author：LearnLi
 * @Create:2020-06-17 16:08
 */
@Component
public class DataSourceFactory {


    private static Logger logger = LoggerFactory.getLogger(DataSourceFactory.class);



    /**
     * 预实例化，进来即被实例化
     */
    private static DataSourceFactory instance = new DataSourceFactory();
    /**
     * 延迟加载
     */
    private static DataSourceFactory instacce = null;

    //私有化
    private DataSourceFactory() {

    }

    static {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    public static DataSourceFactory getInstance() {
        //return instance对应实例化
        if (instance == null) {
            //加锁
            synchronized (DataSourceFactory.class) {
                //双重检查
                if (instance == null) {
                    instance = new DataSourceFactory();
                }
            }
        }
        //对应延迟加载
        return instance;
    }

    /**
     * 获得connection连接
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection(String url,String username,String password) throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    /**
     * 释放连接
     *
     * @param conn
     * @param stmt
     * @param resultSet
     */
    public void free(Connection conn, Statement stmt, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                logger.error("结果集关闭失败！");
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                logger.error("预处理对象关闭失败！");
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    logger.error("jdbc连接关闭失败！");
                    e.printStackTrace();
                }
            }
        }


    }


}
