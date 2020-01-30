package com.mycomp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

//import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtil {
    private static DataSource ds = null;

    static {
        Properties properties = new Properties();
        FileInputStream in;
        try {
            // 这里的配置文件路径,应该写成获取字节码的路径
            // (也就是,当项目发布到服务器上时,字节码的路径)
            String path = JDBCUtil.class.getClassLoader()
                    .getResource("db.properties").getPath();
            System.out.println(path);
            in = new FileInputStream(path);
            properties.load(in);
            // ds = BasicDataSourceFactory.createDataSource(properties);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, Statement statement,
            ResultSet res) {
        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
