package com.qmcs.sms.api;

import com.qmcs.info.model.mybatis.model.Record;

/**
 * 短信记录
 * Created by suyl on 2017/5/30.
 */
public interface SmsRecordService {

    /**
     * 保存短信记录
     * @param record
     * @return
     */
    int insetRecord(Record record);

}
