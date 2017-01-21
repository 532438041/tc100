package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.Message;

public interface MessageDao extends BaseDao<Message>{

	List<Message> getMsgList(Message reqParam);
    
}