package com.alin.message.dao;

import com.alin.message.domain.SmsRecord;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author：raozl
 * @Date：2023/5/5 10:13
 */
public interface SmsRecordDao extends CrudRepository<SmsRecord, Long> {


}