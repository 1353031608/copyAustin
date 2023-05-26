package com.alin.messageByme.dao;

import com.alin.messageByme.domain.MessageTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @Author：raozl
 * @Date：2023/5/4 17:37
 */
@Component
public interface MessageTemplateDao extends CrudRepository<MessageTemplate, Long> {

}
