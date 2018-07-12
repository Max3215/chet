/**
 * 
 */
package com.qmcs.common.util.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Ran Xu
 * @email ranxrrr@qq.com
 * @tel 
 * @comment AES 128位 CBC PKCS5Padding 方式加解密,base64方式编码
 */
@SuppressWarnings("restriction")
public class AES128CBC {
	private static String OFFSET = "0001000300050007";
	

    /**
     * 加密
     * @param sSrc 文本内容
     * @param sKey 密钥
     * @return
     * @throws Exception
     */
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            throw new NullPointerException("The key was null...");
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            throw new RuntimeException("Key length is not 16...");
        }
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec(OFFSET.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());

        return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    /**
     * 密文解密
     * @param sSrc 密文
     * @param sKey 密钥
     * @return
     * @throws Exception
     */
    public static String Decrypt(String sSrc, String sKey) throws Exception {
            // 判断Key是否正确
            if (sKey == null) {
            	throw new NullPointerException("The key was null...");
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
            	throw new RuntimeException("Key length is not 16...");
            }
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(OFFSET.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
    }
}