package com.example.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by silence on 2017/2/7.
 */
public class BatchTest {

    public static Logger log = Logger.getLogger(BatchTest.class);

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String url = "jdbc:mysql://localhost:3306/shishuocms";
        String user = "root";
        String password = "meijiajie";
        Connection conn = null;
        PreparedStatement ps = null;
        int sumNumber = 100000;
        int countNumber = 1000000;
        try {
            Long start = System.currentTimeMillis();
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            String sql = "INSERT into person(address,age,name) VALUES (?,?,?)";
            ps = conn.prepareStatement(sql);
            int size = sumNumber;
            int secend = 0;
            while (secend < countNumber) {
                for(int x = secend; x < size;x++){
                    ps.setString(1,"湖北武汉");
                    ps.setInt(2,24);
                    ps.setString(3,"silence"+(x+1));
                    ps.addBatch();
                }
                secend += sumNumber;
                size += sumNumber;
                ps.executeBatch();
                conn.commit();
            }
            Long end = System.currentTimeMillis();
            log.info("插入成功");
            log.info("用时"+(end-start)+"ms");
        } catch (Exception e) {
            try {
                e.printStackTrace();
                conn.rollback();
                log.info(e.getMessage());
                log.info("插入失败");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
