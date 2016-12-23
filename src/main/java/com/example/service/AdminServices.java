package com.example.service;

import com.example.entity.Admin;
import com.example.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CPR199 on 2016-12-22.
 */
@Service
public class AdminServices {

    @Autowired
    private AdminMapper adminMapper;

    public List<Admin> getAll() {
        return adminMapper.getAll();
    }
}
