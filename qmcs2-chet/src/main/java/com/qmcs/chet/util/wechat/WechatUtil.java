package com.qmcs.chet.util.wechat;

import com.qmcs.common.util.CommonUtil;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.UUID;

/**
 * com.qmcs.chet.util.wechat
 *
 * @auther lb
 * @create 2017/12/22 11:02
 */
public class WechatUtil {

    public static String  weChatUnifiedPaymentObjectTransformationXML(WeChatCallback weChatCallback){
        if(CommonUtil.isEmpty(weChatCallback)){
            return null;
        }
        StringBuffer dataXML = new StringBuffer();
        Class<WeChatCallback> weChatUnifiedPaymentClass =  (Class<WeChatCallback>)weChatCallback.getClass();
        Field[] fields =weChatUnifiedPaymentClass.getDeclaredFields();
        dataXML.append("<xml> \n");
        if(fields==null || fields.length < 0){
            return null;
        }
        try {
            for(int i=0;i<fields.length;i++){
                Field field = fields[i];
                field.setAccessible(true);
                if(CommonUtil.isNotEmpty(field.get(weChatCallback))){
                    dataXML.append("\t<"+field.getName()+">");
                    dataXML.append(field.get(weChatCallback).toString());
                    dataXML.append("</"+field.getName()+">\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataXML.append("</xml>");
        return dataXML.toString();
    }

    /**
     * 获取回调信息
     * @param request
     * @return
     */
    public static WeChatCallback getWeChatCallbackData(HttpServletRequest request){
        InputStream inputStream  = null ;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = request.getInputStream();
            bufferedInputStream = new BufferedInputStream(inputStream);
            String dataXML = IOUtils.toString(bufferedInputStream);
            if(CommonUtil.isEmpty(dataXML)){
                return null;
            }
            if(!dataXML.contains("<xml>") && !dataXML.contains("</xml>")){
                return null;
            }
            XStream stream = new XStream(new DomDriver());
            stream.alias("xml",WeChatCallback.class);
            WeChatCallback weChatCallback = (WeChatCallback)stream.fromXML(dataXML);
            if(CommonUtil.isEmpty(weChatCallback)){
                return null;
            }
            return weChatCallback;
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(CommonUtil.isNotEmpty(bufferedInputStream)){
                    bufferedInputStream.close();
                }
                if(CommonUtil.isNotEmpty(inputStream)){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取微信回调成功信息
     * @return
     */
    public static String getSuccessInformation(){
        WeChatCallback weChatUnifiedPayment  = new WeChatCallback();
        weChatUnifiedPayment.setReturn_code("SUCCESS");
        weChatUnifiedPayment.setReturn_msg("系统处理成功");
        return weChatUnifiedPaymentObjectTransformationXML(weChatUnifiedPayment);
    }

    /**
     * 获取微信回调失败信息
     * @return
     */
    public static String getFailInformation(){
        WeChatCallback weChatUnifiedPayment  = new WeChatCallback();
        weChatUnifiedPayment.setReturn_code("FAIL");
        weChatUnifiedPayment.setReturn_msg("系统处理失败");
        return weChatUnifiedPaymentObjectTransformationXML(weChatUnifiedPayment);
    }

    /**
     * 验证消息合法性
     * @param signature
     * @param paraStr
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static boolean checkSingature(String signature,String...paraStr) throws NoSuchAlgorithmException {

        // 按字典顺序排序
        Arrays.sort(paraStr);
        // 字符串拼接
        StringBuilder content = new StringBuilder();
        for (String string : paraStr) {
            content.append(string);
        }
        // sha1加密
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest(content.toString().getBytes());
        String testingStr = byteArrayToHexString(digest);
        // 比较返回
        if (testingStr.equalsIgnoreCase(signature.toUpperCase())) {
            return true;
        }
        return false;
    }

    // 将字节数组转换为十六进制字符串
    private static String byteArrayToHexString(byte[] bytearray) {
        String strDigest = "";
        for (int i = 0; i < bytearray.length; i++) {
            strDigest += byteToHexString(bytearray[i]);
        }
        return strDigest;
    }

    // 将字节转换为十六进制字符串
    private static String byteToHexString(byte ib) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];
        String s = new String(ob);
        return s;
    }

    public static String yuanTransformationCent(BigDecimal money){
        money  = money.multiply(new BigDecimal("100"));
        return String.valueOf(money.intValue());
    }


    /**
     * 获取当前时间戳，单位秒
     * @return
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis()/1000;
    }

    /**
     * 获取当前时间戳，单位毫秒
     * @return
     */
    public static long getCurrentTimestampMs() {
        return System.currentTimeMillis();
    }

    /**
     * 生成 uuid， 即用来标识一笔单，也用做 nonce_str
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }

    public static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

}
