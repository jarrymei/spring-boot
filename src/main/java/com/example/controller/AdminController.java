package com.example.controller;

import com.example.entity.Admin;
import com.example.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by CPR199 on 2016-12-21.
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping("/list")
    public List<Admin> list() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>AdminController.list<<<<<<<<<<<<<<<<<<<<<<<");
        List<Admin> list = adminService.getList();
        return list;
    }

    @RequestMapping("/get")
    public Admin get() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>AdminController.get<<<<<<<<<<<<<<<<<<<<<<<");
        Admin admin = adminService.get(1);
        return admin;
    }

    @RequestMapping("/add")
    public String add() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>AdminController.add<<<<<<<<<<<<<<<<<<<<<<<");
        adminService.add();
        return "添加成功";
    }

    @RequestMapping("/del")
    public String del() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>AdminController.del<<<<<<<<<<<<<<<<<<<<<<<");
        adminService.del();
        return "删除成功";
    }
}
