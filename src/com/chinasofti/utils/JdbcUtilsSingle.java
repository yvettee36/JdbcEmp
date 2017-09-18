package com.chinasofti.utils;

import java.sql.*;

/**
 * Created by yvettee on 2017/9/17.
 */
public class JdbcUtilsSingle {
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String user = "scott";
    private String password = "tiger";

    private static JdbcUtilsSingle instance = null;

    private JdbcUtilsSingle() {

    }

    //懒汉式
    public static JdbcUtilsSingle getInstance() {
        if (instance == null) {
            instance = new JdbcUtilsSingle();
        }
        return instance;
    }

    //    注册驱动
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    //    建立连接
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    //    释放连接
    public void release(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;//如果rs没有被关闭，就置为空，变成一个垃圾对象，被垃圾回收器回收
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ps = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}