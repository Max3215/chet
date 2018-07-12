package com.qmcs.chet.service.record;

import com.qmcs.common.page.QueryPage;
import com.qmcs.info.model.mybatis.model.Record;

import java.util.List;

/**
 * com.qmcs.chet.service.record
 *
 * @auther lb
 * @create 2017/12/20 16:49
 */
public interface RecordService {

    int insertRecord(Record record);

    List<Record> selectListByUserId(Long userId,QueryPage page);

    Record selectUserEndOne(Long userId,String openId);



}
