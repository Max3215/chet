package com.qmcs.chet.service.impl.record;

import com.qmcs.common.page.QueryPage;
import com.qmcs.info.model.mybatis.mapper.RecordMapper;
import com.qmcs.info.model.mybatis.model.Record;
import com.qmcs.chet.service.record.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.qmcs.chet.service.impl.record
 *
 * @auther lb
 * @create 2017/12/20 16:50
 */
@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RecordMapper recordMapper;


    @Override
    public int insertRecord(Record record) {
        return recordMapper.insert(record);
    }

    @Override
    public List<Record> selectListByUserId(Long userId,QueryPage page) {
        return recordMapper.selectRecordListByUserId(userId,page.getLimitStart(),page.getPageSize());
    }

    @Override
    public Record selectUserEndOne(Long userId,String openId) {
        return recordMapper.selectUserEndOne(userId,openId);
    }


}
