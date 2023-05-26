package com.alin.messageByme.controller;

import com.alin.messageByme.dao.SmsRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：raozl
 * @Date：2023/5/5 10:35
 */
@RestController
public class SmsRecordController {


    @Autowired
    private SmsRecordDao smsRecordDao;

    /**
     * test insert
     */
    @GetMapping("/insert")
    public String insert(Integer phone) {
        return null;
    }

    /**
     * test query
     */
    @GetMapping("/query")
    public String query() {

        return null;
    }
}
