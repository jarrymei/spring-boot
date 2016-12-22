package com.example.controller;

import com.example.entity.Person;
import com.example.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by CPR199 on 2016-12-22.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    protected static Logger logger= LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;


    @RequestMapping("/save")
    public Person save(String name, String address, Integer age){
        logger.debug("save 开始");
        Person p=personService.save(new Person(null,name,age,address));
        logger.debug("save 结束");
        return p;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address){
        logger.debug("q1 开始");
        logger.debug("q1 接收参数address={}",address);
        List<Person> people=personService.findByAddress(address);
        return people;
    }

    @RequestMapping("/q2")
    public List<Person> q2(String name,String address){
        logger.debug("q2 开始");
        logger.debug("q2接收参数name={},address={}",name,address);
        return personService.findByNameAndAddress(name, address);
    }

    @RequestMapping("/q3")
    public List<Person> q3(String name,String address){
        logger.debug("q3 开始");
        logger.debug("q3接收参数name={},address={}",name,address);
        return personService.withNameAndAddressQuery(name, address);
    }

    @RequestMapping("/sort")
    public List<Person> sort(){
        logger.debug("sort 开始");
        List<Person> people=personService.findAll(new Sort(Sort.Direction.ASC,"age"));
        return people;
    }

    @RequestMapping("/page")
    public Page<Person> page(){
        logger.debug("page 开始");
        Page<Person> people=personService.findAll(new PageRequest(1,2));
        return people;
    }



}
