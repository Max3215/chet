package com.qmcs.sms.util;

import com.qmcs.common.code.Code;
import com.qmcs.common.restful.ReturnAppData;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.common.util.DateUtils;
import com.qmcs.common.util.SpringUtils;
import com.qmcs.info.model.mybatis.model.Record;
import com.qmcs.info.model.mybatis.model.User;
import com.qmcs.sms.api.MonoSmsService;
import com.qmcs.sms.api.SmsRecordService;
import com.qmcs.sms.api.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 发送短信验证码
 * Created by hh on 2017/6/14.
 */
public class SendPhoneCodeUtil {

    private static SmsService smsService = SpringUtils.getBean(SmsService.class);

    private static MonoSmsService monoSmsService = SpringUtils.getBean(MonoSmsService.class);

    private static SmsRecordService smsRecordService = SpringUtils.getBean(SmsRecordService.class);

    private static Logger logger = LoggerFactory.getLogger(SendPhoneCodeUtil.class);
    /**
     * 发送验证码
     * @param user 发送对象
     */
    public static ReturnAppData sendPhoneCode(User user,String openId){
        logger.info("发送短信验证码入参{}");
        String phone = user.getUserTelphone();
        Map<String, Object> map = null;
        ReturnAppData rd = new ReturnAppData();
        try {
            //设置短信内容
            String content = SmsTemplate.smsNoticeforChet(user.getUserCarCode());
            //调用发送短信接口
            map = smsService.sendSms(phone, content);
            //新短信发送失败时调用旧短信方式发送
            if(CommonUtil.isNotEmpty(map)){
                //保存短信记录
                Record record = new Record();
                record.setRecordCount(content);
                record.setRecordTime(DateUtils.currentTimeMillis());
                record.setRecordUserId(user.getUserId());
                record.setRecordType(0);
                record.setRecordOpenId(openId);
                //新短信发送失败
                if(!map.get("State").equals("0")){
                    map = monoSmsService.sendSms(phone,content);
                    if(CommonUtil.isEmpty(map)){
                        record.setRecordReturnNo("成功");
                        logger.info("短信验证码已发送到您的手机！");
                        rd.setCode(Code.SUCCESS.getCode());
                        rd.setMsg("已成功给车主发送短信提示！");
                    }else {
                        record.setRecordReturnNo("失败");
                        logger.info("短信验证码发送失败！");
                        rd.setCode(Code.FAIl_SMS.getCode());
                        rd.setMsg(Code.FAIl_SMS.getMsg());
                    }
                }else {
                    record.setRecordReturnNo("成功");
//                    MapPhoneCodeUtils.saveMapData(phone, phoneCode);
                    logger.info("短信验证码已发送到您的手机！");
                    rd.setCode(Code.SUCCESS.getCode());
                    rd.setMsg("已成功给车主发送短信提示！");
                }
                //保存短信记录
                smsRecordService.insetRecord(record);
            }

        } catch (Exception e) {
            e.printStackTrace();
            rd.setCode(Code.FAIl_SMS.getCode());
            rd.setMsg(Code.FAIl_SMS.getMsg());
            logger.info("发送短信异常信息:{}",e);
        }finally{
            logger.info("发送短信验证码出参map-->:{}",map);
        }
        return rd;
    }


}
