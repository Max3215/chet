package com.qmcs.common.util;

import java.text.DecimalFormat;
import java.util.Random;


public class NumberGeneratorUtils {

    public static final String STAFF_NUMBER = "QMNW";
    public static final String TS_NUMBER = "QMTS";
    public static final String STAFF_PWD = "QMCS";
    
	private static DecimalFormat df = new DecimalFormat("0000");
    /**
     *
     * @Description(功能描述)    :  用户uuid生成规则
     * @author(作者)             ：  suyuanliu
     * @date (开发日期)          :  2017年5月25日 下午17:33:52
     * @exception                :
     * @return  String
     */
    public synchronized static String getUuid(){
        return getNo("12");

    }
    /**
     * 
     * @Description(功能描述)    :  获取商品单号
     * @author(作者)             ：  suyuanliu
     * @date (开发日期)          :  2017年1月9日 下午17:33:52
     * @exception                : 
     * @return  String
     */
    public synchronized static String getGoodsNo(){
    	return getNo("11");
    	
    }

    /**
     *
     * @Description(功能描述)    :  获取公司流水返款单号
     * @author(作者)             ：  suyuanliu
     * @date (开发日期)          :  2017年1月9日 下午17:33:52
     * @exception                :
     * @return  String
     */
    public synchronized static String getQmcsBalanceNo(){
        return getNo("fk");

    }

    /**
     *
     * @Description(功能描述)    :  获取用户流水返款单号
     * @author(作者)             ：  suyuanliu
     * @date (开发日期)          :  2017年1月9日 下午17:33:52
     * @exception                :
     * @return  String
     */
    public synchronized static String geUserBalanceNo(){
        return getNo("ufk");

    }

    /**
     *
     * @Description(功能描述)    :  获取用户返款单号
     * @author(作者)             ：  suyuanliu
     * @date (开发日期)          :  2017年1月9日 下午17:33:52
     * @exception                :
     * @return  String
     */
    public synchronized static String getBusinessRefundNo(){
        return getNo("bfk");

    }

    /**
     *
     * @Description(功能描述)    :  获取订单单号
     * @author(作者)             ：  suyuanliu
     * @date (开发日期)          :  2017年1月9日 下午17:33:52
     * @exception                :
     * @return  String
     */
    public synchronized static String getOrderNo(){
        return getNo("10");

    }
    /**
     * 随机生成追加单号
     * @return
     */
    public synchronized static String randomAddtionAddNo(){
        StringBuffer code = new StringBuffer();
        //生成短信验证码
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }

    /**
     * 随机生成记录对象单号
     * @return
     */
    public synchronized static String randomBalanceObjNo(){
        StringBuffer code = new StringBuffer();
        //生成短信验证码
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }

    /**
     * 签名随机数（1000~9999）
     * @return
     */
    public synchronized static String randomPaymentSign(){
        StringBuffer code = new StringBuffer();
        //生成短信验证码
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }

    /**
     * 随机生成指定位数数字字符串
     * @param index
     * @return
     */
    public synchronized static String randomPaymentSign(int index){
        StringBuffer code = new StringBuffer();
        //生成短信验证码
        Random random = new Random();
        for (int i = 0; i < index; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }

    /**
     * token生成规则
     * @return
     */
    public static String getToken() {
        String str = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = str.length() - 1;
        String result = "";
        int index;
        for (int i = 0; i < 30; ++i) {
            index = (int) (Math.random() * length);
            result = result.concat(str.substring(index, index + 1));
        }
        return result;
    }

    public static void main(String[] args) {
		System.out.println(getToken());
    }
    
    /**
     * 获取充值单号
     * 规则：年2位，月2位，日2位，时2位，分2位，秒2位，随机数6位的字符串
     * @return
     */
    public static synchronized String getNo(String prefix){
    	String number = DateUtils.date2String(DateUtils.currentDateTime(),"yyMMddHHmmss");
//        String str2 = df.format(Long.valueOf(DateUtils.date2String(DateUtils.currentDateTime(),"mmss")));
        return prefix + number + randomPaymentSign(4);
    }

    
}
