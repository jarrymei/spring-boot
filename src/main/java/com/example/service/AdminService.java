package com.example.service;

import com.example.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by CPR199 on 2016-12-21.
 */
@Service
public class AdminService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Admin> getList() {
        String sql = "select * from admin";
        return (List<Admin>) jdbcTemplate.query(sql, new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
                Admin admin = new Admin();
                admin.setAdminId(resultSet.getInt("adminId"));
                admin.setName(resultSet.getString("name"));
                admin.setPassword(resultSet.getString("password"));
                admin.setCreateTime(resultSet.getDate("createTime"));
                return admin;
            }
        });
    }

    public Admin get(int adminId) {
        String sql = "select * from admin where adminId='?'";
        String s = sql.replace("?", String.valueOf(adminId));
        return (Admin) jdbcTemplate.queryForObject(s, new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
                Admin admin = new Admin();
                admin.setAdminId(resultSet.getInt("adminId"));
                admin.setName(resultSet.getString("name"));
                admin.setPassword(resultSet.getString("password"));
                admin.setCreateTime(resultSet.getDate("createTime"));
                return admin;
            }
        });
    }

    public void add() {
        String sql = "INSERT INTO admin VALUES (5 ,'mjj343j', '123', '2012-08-08', 2, NULL)";
        jdbcTemplate.execute(sql);
    }

    public void del() {
        String sql = "DELETE FROM admin WHERE adminId=4 ";
        jdbcTemplate.execute(sql);
    }

    public static void main(String[] args) {
        String sql = "select * from admin where adminId='?'";
        String a = sql.replace("?", "1");
        System.out.print(a);
    }
}
