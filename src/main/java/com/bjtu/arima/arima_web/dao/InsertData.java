package com.bjtu.arima.arima_web.dao;

import com.bjtu.arima.arima_web.domain.ActiveRequest;
import com.bjtu.arima.arima_web.domain.NumComment;
import com.bjtu.arima.arima_web.domain.NumRetweet;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertData {
    public void insertBatchIfo(String tableName, ActiveRequest activeRequest) throws SQLException {
        Connection con = DBConnection.dBConnection();
        String sql="INSERT INTO "+tableName+" ( PubInfoTopicID, TopicName, PublishTime)"+" VALUES"+" ( ?,?,? );";
        java.sql.PreparedStatement ptmt = null;

        try {
            con.setAutoCommit(false);// 关闭事务
            ptmt = con.prepareStatement(sql);

        } catch (SQLException e2) {
            e2.printStackTrace();
        }

        try {
            ptmt.setInt(1, activeRequest.getPubInfoTopicID());
            ptmt.setString(2, activeRequest.getTopicName());
            ptmt.setDate(3, activeRequest.getPublishTime());
            ptmt.addBatch();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ptmt.executeBatch();//执行给定的SQL语句，该语句可能返回多个结果
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.close();
    }

    public void insertBatchRet(String tableName, ActiveRequest activeRequest) throws SQLException {
        Connection con = DBConnection.dBConnection();
        String sql="INSERT INTO "+tableName+" ( PubInfoTopicID, relative_time_second, number_of_followers)"+" VALUES"+" ( ?,?,? );";
        java.sql.PreparedStatement ptmt = null;

        try {
            con.setAutoCommit(false);// 关闭事务
            ptmt = con.prepareStatement(sql);

        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        for(NumRetweet numRetweet:activeRequest.getNumRetweet()){
            try {
                ptmt.setInt(1, activeRequest.getPubInfoTopicID());
                ptmt.setInt(2, numRetweet.getRelTime());
                ptmt.setInt(3, numRetweet.getNumFollower());
                ptmt.addBatch();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            ptmt.executeBatch();//执行给定的SQL语句，该语句可能返回多个结果
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.close();
    }

    public void insertBatchCom(String tableName, ActiveRequest activeRequest) throws SQLException {
        Connection con = DBConnection.dBConnection();
        String sql="INSERT INTO "+tableName+" ( PubInfoTopicID, relative_time_second, number_of_followers)"+" VALUES"+" ( ?,?,? );";
        java.sql.PreparedStatement ptmt = null;

        try {
            con.setAutoCommit(false);// 关闭事务
            ptmt = con.prepareStatement(sql);

        } catch (SQLException e2) {
            e2.printStackTrace();
        }

        for(NumComment numComment:activeRequest.getNumComment()){
            try {
                ptmt.setInt(1, activeRequest.getPubInfoTopicID());
                ptmt.setInt(2, numComment.getRelTime());
                ptmt.setInt(3, numComment.getNumFollower());
                ptmt.addBatch();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            ptmt.executeBatch();//执行给定的SQL语句，该语句可能返回多个结果
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.close();
    }
}
