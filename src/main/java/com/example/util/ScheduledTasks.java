package com.example.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CPR199 on 2016-12-23.
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 60000)
    public void execute() {
        System.out.println("now time:"+sf.format(new Date()));
    }

}
