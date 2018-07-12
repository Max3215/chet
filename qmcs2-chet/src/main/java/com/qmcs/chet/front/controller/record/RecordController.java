package com.qmcs.chet.front.controller.record;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dyvmsapi.model.v20170525.SingleCallByTtsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.qmcs.common.code.Code;
import com.qmcs.common.page.QueryPage;
import com.qmcs.common.restful.ReturnAppData;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.common.util.DateUtils;
import com.qmcs.info.model.mybatis.model.Record;
import com.qmcs.info.model.mybatis.model.User;
import com.qmcs.sms.util.SendPhoneCodeUtil;
import com.qmcs.chet.service.record.RecordService;
import com.qmcs.chet.service.token.TokenService;
import com.qmcs.chet.service.user.UserService;
import com.qmcs.chet.util.aliConstans;
import com.qmcs.chet.util.aliyunUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.qmcs.chet.controller.record
 *
 * @auther lb
 * @create 2017/12/22 18:48
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/record",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
public class RecordController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private TokenService tokenService;

    /**
     * 扫码提醒
     * @param qrCode
     * @param type
     * @return
     */
    @RequestMapping("/sendRemind")
    @ResponseBody
    public String remindUser(String qrCode,String openId,Integer type){
        if(CommonUtil.isEmpty(qrCode) || CommonUtil.isEmpty(type) || CommonUtil.isEmpty(openId)){
            return JSON.toJSONString(new ReturnAppData(Code.PARAMETER_SHORTAGE));
        }

        User user = userService.selectUserByQrCode(qrCode);
        if(CommonUtil.isEmpty(user))
            return JSON.toJSONString(new ReturnAppData(Code.QR_CODE_INVALID));

        Record recordEnd = recordService.selectUserEndOne(user.getUserId(),openId);
        Long nowTime = DateUtils.currentTimeMillis();
        if(null != recordEnd){
            Long recordTime = recordEnd.getRecordTime();
            // 10分钟内不再发送提醒
            if ((nowTime-recordTime)/1000 < 300)
                return JSON.toJSONString(new ReturnAppData<>(Code.NOTICE_ERROR));
        }

        // 提示类型，0-短信 1-语音
        if (type == 0 ) {
            ReturnAppData returnAppData = SendPhoneCodeUtil.sendPhoneCode(user, openId);
            if (Code.SUCCESS.getCode() == returnAppData.getCode()){
                tokenService.sendWxMessage(user);
            }
            return JSON.toJSONString(returnAppData);
        }else{
            Map<String,String> map = new HashMap<>();
            map.put("name",user.getUserCarCode());

            Record record = new Record();
            record.setRecordCount("语音提醒");
            record.setRecordTime(nowTime);
            record.setRecordUserId(user.getUserId());
            record.setRecordType(1);
            record.setRecordOpenId(openId);
            try {
                SingleCallByTtsResponse ttsResponse = aliyunUtils.singleCallByTts(user.getUserTelphone(), aliConstans.TTSCODE_RECORD, JSON.toJSONString(map));
                if(aliConstans.SUCCESS.equals(ttsResponse.getCode())){
                    record.setRecordReturnNo("成功");
                    recordService.insertRecord(record);
                }else{
                    record.setRecordCount(ttsResponse.getMessage());
                    record.setRecordReturnNo("失败");
                    recordService.insertRecord(record);
                    return JSON.toJSONString(new ReturnAppData<>(Code.FAIl_ALIYUNCS));
                }
            } catch (ClientException e) {
                e.printStackTrace();
                return JSON.toJSONString(new ReturnAppData<>(Code.FAIl_ALIYUNCS));
            }
        }
        tokenService.sendWxMessage(user);
        return JSON.toJSONString(new ReturnAppData<>(Code.SUCCESS.getCode(),"已成功向车主发送语音提示！"));
    }

    /**
     * 提醒记录
     * @param openId
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public String getList(String openId,Integer limitStart,Integer pageSize){
        if(CommonUtil.isEmpty(openId))
            return JSON.toJSONString(new ReturnAppData(Code.PARAMETER_SHORTAGE));
        if (null == limitStart)
            limitStart = 1;
        if (null == pageSize || pageSize <= 0)
            pageSize = 20;

        User user = userService.selectUserByOpenId(openId);
        if(CommonUtil.isEmpty(user))
            return JSON.toJSONString(new ReturnAppData(Code.THE_DATE_IS_EMPTY_INFO));

        QueryPage page = new QueryPage();
        page.setTargetPage(limitStart);
        page.setPageSize(pageSize);
        List<Record> recordList = recordService.selectListByUserId(user.getUserId(),page);

        return JSON.toJSONString(new ReturnAppData<List>(Code.SUCCESS,recordList));
    }


}
