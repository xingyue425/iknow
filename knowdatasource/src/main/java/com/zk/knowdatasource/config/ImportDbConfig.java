package com.zk.knowdatasource.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class ImportDbConfig {

    public static void getDb(){

        //JDBC驱动名
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        //数据库URL：这里的mysql2020是数据库名称
        String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/ticket?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        //数据库的用户名与密码
        String USER = "root";
        String PASS = "root";
        //通过DriverManager类获得该连接对象才能访问数据库
        Connection connection = null;
        //通过Connection获得该结果对象用于执行静态的SQL语句
        Statement statement = null;
        try {
            //注册JDBC驱动
            Class.forName(JDBC_DRIVER);
            //数据库的连接：通过DriverManager类的getConnection方法，传入三个参数：数据库URL、用户名、用户密码，实例化connection对象
            connection = DriverManager.getConnection(JDBC_URL,USER,PASS);
            //实例化statement对象
            statement = (Statement) connection.createStatement();
            //定义数据库查询语句：查询ceshi表中的uuid、Address两列数据
            String sql = "SELECT id,db_name,ip,port,user_name,password,driver_class_name,db_key " +
                    "        FROM sale_point t " +
                    "        WHERE t.id in (1,2)";
            //执行查询语句
            ResultSet rSet = statement.executeQuery(sql);
            //展开查询到的数据
            while(rSet.next()) {
                //这里getString()方法中的参数对应的是数据库表中的列名
                String get_name = rSet.getString("db_name");
                String get_sex = rSet.getString("ip");
                //输出数据
                System.out.println("数据库名称:"+get_name);
                System.out.print("数据库地址:"+get_sex);
            }
            //依次关闭对象
            rSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
