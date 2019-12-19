package com.bjtu.arima.arima_web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectData {

    public double[] getData(String tableName) throws SQLException {
        String SELECT = "select* from "+tableName;
        Connection con = DBConnection.dBConnection();
        ResultSet rs;// 创建结果集
        PreparedStatement pstmt = con.prepareStatement(SELECT);// 创建一个PreparedStatement对象
        rs = pstmt.executeQuery();

        // 为初始化数组的大小提供方便
        int sample = 0;
        while (rs.next()) {
            sample++;
        }

        double[] data = new double[sample];
        rs = pstmt.executeQuery();// 特别重要，否则取到的全是0。因为执行上面的while(rs.next())后，ResultSet对象的下标已指到0。
        // API：当生成ResultSet对象的Statement对象关闭、重新执行或用来从多个结果的序列获取下一个结果时，ResultSet对象将自动关闭。
        for (int i = 0; rs.next(); i++) {
            data[i] =  rs.getDouble(1);
        }
        pstmt.close();
        rs.close();
        con.close();
        return data;
    }

    public int[][] getAllData(String tableName) throws SQLException {
        String SELECT = "select* from "+tableName;
        int k = 3;// 3个属性

        Connection con = DBConnection.dBConnection();
        ResultSet rs;// 创建结果集
        PreparedStatement pstmt = con.prepareStatement(SELECT);// 创建一个PreparedStatement对象
        rs = pstmt.executeQuery();

        // 为初始化数组的大小提供方便
        int sample = 0;
        while (rs.next()) {
            sample++;
        }

        int[][] dataAll = new int[sample][k];
        rs = pstmt.executeQuery();// 特别重要，否则取到的全是0。因为执行上面的while(rs.next())后，ResultSet对象的下标已指到0。
        // API：当生成ResultSet对象的Statement对象关闭、重新执行或用来从多个结果的序列获取下一个结果时，ResultSet对象将自动关闭。
        for (int i = 0; rs.next(); i++) {
            for (int j = 0; j < k; j++) {
                dataAll[i][j] = rs.getInt(j + 1);
            }
        }

        pstmt.close();
        rs.close();
        con.close();
        return dataAll;
    }

    public String[] getOneStringData(String tableName,int column) throws SQLException {
        String SELECT = "select* from "+tableName;
        int k = 3;// 3个属性

        Connection con = DBConnection.dBConnection();
        ResultSet rs;// 创建结果集
        PreparedStatement pstmt = con.prepareStatement(SELECT);// 创建一个PreparedStatement对象
        rs = pstmt.executeQuery();

        // 为初始化数组的大小提供方便
        int sample = 0;
        while (rs.next()) {
            sample++;
        }

        String[] dataOneString = new String[sample];
        rs = pstmt.executeQuery();// 特别重要，否则取到的全是0。因为执行上面的while(rs.next())后，ResultSet对象的下标已指到0。
        // API：当生成ResultSet对象的Statement对象关闭、重新执行或用来从多个结果的序列获取下一个结果时，ResultSet对象将自动关闭。
        for (int i = 0; rs.next(); i++) {
            dataOneString[i] = rs.getString(column);
        }

        pstmt.close();
        rs.close();
        con.close();
        return dataOneString;
    }

    public int[] getOneIntData(String tableName,int column) throws SQLException {
        String SELECT = "select* from "+tableName;
        int k = 3;// 3个属性

        Connection con = DBConnection.dBConnection();
        ResultSet rs;// 创建结果集
        PreparedStatement pstmt = con.prepareStatement(SELECT);// 创建一个PreparedStatement对象
        rs = pstmt.executeQuery();

        // 为初始化数组的大小提供方便
        int sample = 0;
        while (rs.next()) {
            sample++;
        }

        int[] dataOneInt= new int[sample];
        rs = pstmt.executeQuery();// 特别重要，否则取到的全是0。因为执行上面的while(rs.next())后，ResultSet对象的下标已指到0。
        // API：当生成ResultSet对象的Statement对象关闭、重新执行或用来从多个结果的序列获取下一个结果时，ResultSet对象将自动关闭。
        for (int i = 0; rs.next(); i++) {
            dataOneInt[i] = rs.getInt(column);
        }

        pstmt.close();
        rs.close();
        con.close();
        return dataOneInt;
    }

    public static void main(String[] args) {
        try {
            SelectData selectData = new SelectData();
            int[] data = selectData.getOneIntData("info4hawkes",1);
            String[] dataString = selectData.getOneStringData("info4hawkes",3);
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + "\t");
                System.out.print(dataString[i]);
                System.out.println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}