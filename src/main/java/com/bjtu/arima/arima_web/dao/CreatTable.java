package com.bjtu.arima.arima_web.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class CreatTable {
    public void addTable(String tableName) throws SQLException {
        Connection con = DBConnection.dBConnection();
        Statement stmt = con.createStatement();
        String creatsql = "CREATE TABLE "+tableName+" ("
                + "Number"
                + " Double);";
        if(0 == stmt.executeLargeUpdate(creatsql)){
            System.out.println("成功创建表！");
        }
        else{
            System.out.println("创建表失败！");
        }
        stmt.close();
        con.close();
    }

    public static void main(String[] args) throws SQLException {
        CreatTable creatTable = new CreatTable();
        creatTable.addTable("test111");
    }
}
