package com.wxpay.sdk;

import com.qmcs.chet.util.wechat.WecahtConstans;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class WXPayConfigImpl extends WXPayConfig {

    private byte[] certData;
    private static WXPayConfigImpl INSTANCE;

    private WXPayConfigImpl() throws Exception{
        Properties props = System.getProperties();
        String operation = props.getProperty("os.name");
        String certPath = null;
        if(operation.contains("Windows")){
            String path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
            certPath = path+"wxPay/apiclient_cert.p12";
        }else{
            certPath = "/home/apps/pay2.qmcs-china.com/apiclient_cert.p12";
        }
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    public static WXPayConfigImpl getInstance() throws Exception{
        if (INSTANCE == null) {
            synchronized (WXPayConfigImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WXPayConfigImpl();
                }
            }
        }
        return INSTANCE;
    }

    public String getAppID() {
        return WecahtConstans.APPID;
    }

    public String getMchID() {
        return WecahtConstans.MCHID;
    }

    public String getKey() {
        return WecahtConstans.KEY;
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }


    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    IWXPayDomain getWXPayDomain() {
        return WXPayDomainSimpleImpl.instance();
    }

    public String getPrimaryDomain() {
        return "api.mch.chet.qq.com";
    }

    public String getAlternateDomain() {
        return "api2.mch.chet.qq.com";
    }

    @Override
    public int getReportWorkerNum() {
        return 1;
    }

    @Override
    public int getReportBatchSize() {
        return 2;
    }
}
