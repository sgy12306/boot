package com.d;

import com.d.entity.Log;
import com.d.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class LogTest extends ApplicationTests {
    @Autowired
    private LogService logService;

    @Override
    public void test() {
        //execute();
    }

    void execute() {
        long s1 = System.currentTimeMillis();
        Log log = new Log();
        log.setContent("admin");
        List<Log> list = logService.list(log);
        Integer count = logService.count(log);
        Log log1 = logService.get(log);
        System.out.println(count);
        System.out.println(list.size());
        log.setCause("asa");
        Integer count2 = logService.count(log);
        System.out.println(count2);
        long s2 = System.currentTimeMillis();
        System.out.println(s2 - s1);
        List<Log> logs = logService.listByIdsCache(Arrays.asList(1, 2));
        System.out.println(logs.size());
    }
}