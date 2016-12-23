package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by CPR199 on 2016-12-21.
 */
@Controller
public class IndexController {

    @Value("${author.nickName}")
    private String nickName;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", nickName);
        return mv;
    }
}
