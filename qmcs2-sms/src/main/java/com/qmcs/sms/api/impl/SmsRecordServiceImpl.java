package com.qmcs.sms.api.impl;

import com.qmcs.info.model.mybatis.mapper.RecordMapper;
import com.qmcs.info.model.mybatis.model.Record;
import com.qmcs.sms.api.SmsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 短信记录
 */
@Service
public class SmsRecordServiceImpl implements SmsRecordService{

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public int insetRecord(Record record) {
        return recordMapper.insert(record);
    }
}
