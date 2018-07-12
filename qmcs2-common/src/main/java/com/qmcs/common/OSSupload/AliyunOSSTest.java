package com.qmcs.common.OSSupload;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.DateUtil;
import com.aliyun.oss.model.*;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.common.util.NumberGeneratorUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by CC on 2017/6/12.
 * chenchao
 * 阿里云OSSAPI测试
 */
public class AliyunOSSTest {

    public static void main(String[] args) throws Exception{

        /*List<String> lists = new ArrayList<>();
        lists.add("QMCSTest/qmcs1.jpg");
        lists.add("QMCSTest/qmcs2.jpg");
        for (String s : lists){
            String url =AliyunOSSAPI.getFileUrl(s);
            System.out.println(url);
        }*/

        /*String flieUrl = "QMCSTest/[qmcs1.jpg]";

        String url =AliyunOSSAPI.handleFileUrl(flieUrl);
        String[] ff = url.split(",");
        System.out.println(ff);
        for (int i = 0; i < ff.length; i++) {
            System.out.println(ff[i]);
        }*/
        //
        //AliyunOSSVO aliyunOSSVO = AliyunOSSUtil.sampleSTS("package",AliyunOSSConstant.ROLEARN_WRITE,AliyunOSSConstant.DURATION_SECONDS_UPLOAD);

        //System.out.println("=="+aliyunOSSVO.getAccessKeySecret());


        /*boolean flge = true;
        while (flge == true) {
            //写操作
            AliyunOSSVO aliyunOSSVOWrite = AliyunOSSUtil.sampleSTS(null,AliyunOSSConstant.ROLEARN_WRITE,AliyunOSSConstant.DURATION_SECONDS_UPLOAD);
            OSSClient ossclientWrite = AliyunOSSAPI.getOSSClient(aliyunOSSVOWrite);
            //读操作
            AliyunOSSVO aliyunOSSVORead = AliyunOSSUtil.sampleSTS(null,AliyunOSSConstant.ROLEARN_READ,AliyunOSSConstant.DURATION_SECONDS_IMAGESLIST);
            //初始化OSSClient
            OSSClient ossClientReadv = AliyunOSSAPI.getOSSClient(aliyunOSSVORead);
            // 列举Object
            ObjectListing listing = ossClientReadv.listObjects(aliyunOSSVORead.getBucketName(), "qmcs-nw");
            List<String> listKey = new ArrayList<>();
            // 遍历所有Object
            for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
                System.out.println(objectSummary.getKey());
                listKey.add(objectSummary.getKey());
            }*/
            /*if (CommonUtil.isNotEmpty(listKey)) {
                DeleteObjectsResult deleteObjectsResult = ossclientWrite.deleteObjects(new DeleteObjectsRequest(AliyunOSSConstant.BACKET_NAME).withKeys(listKey));
                List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
                // 关闭client
                ossClientReadv.shutdown();
                for (String s : deletedObjects) {
                    System.out.println(s);
                }
                System.out.println("删除成功!");
            } else {
                flge = false;
                System.out.println("删除完毕!");
            }*/
        //}

        // 删除Object
        //ossclientWrite.deleteObject(AliyunOSSConstant.BACKET_NAME, objectSummary.getKey());
        // 关闭client
        //ossClientReadv.shutdown();
        /*String files="E:\\springUpload\\banner1.png,E:\\springUpload\\banner2.png,E:\\springUpload\\banner3.png";

        UUID uuid  = UUID.randomUUID();
        String[] file=files.split(",");
        for(String filename:file){
            System.out.println("filename:"+filename);
            File filess=new File(filename);
            String md5key = AliyunOSSAPI.uploadObject2OSS(ossclient, filess, aliyunOSSVO.getBucketName(), aliyunOSSVO.getSaveDirectory()+"/"+uuid+"/");
            //上传后的文件MD5数字唯一签名:40F4131427068E08451D37F02021473A
            System.out.println(md5key);
        }*/
        // 销毁*/
        //ossclient.shutdown();




        //String content = "Hello OSS";
        //PutObjectRequest putObjectRequest = new PutObjectRequest(aliyunOSSVO.getBucketName(), "key",
        //    new ByteArrayInputStream(content.getBytes()));
        // 上传回调参数
        //Callback callback = new Callback();
        //callback.setCallbackUrl(callbackUrl);
        //callback.setCallbackHost("oss-cn-hangzhou.aliyuncs.com");
        //callback.setCallbackBody("{\\\"mimeType\\\":${mimeType},\\\"size\\\":${size}}");
        //callback.setCallbackBodyType(CallbackBodyType.JSON);
        //callback.addCallbackVar("x:var1", "value1");
        //callback.addCallbackVar("x:var2", "value2");
        //putObjectRequest.setCallback(callback);
        //PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
        // 读取上传回调返回的消息内容
        //byte[] buffer = new byte[1024];
        //putObjectResult.getCallbackResponseBody().read(buffer);
        // 一定要close，否则会造成连接资源泄漏
        //putObjectResult.getCallbackResponseBody().close();
        // 关闭client
        //ossClient.shutdown();
        //new一个URL对象
        /*URL url = new URL("http://img.qmcs-china.com/pic/200/2017/01/14/a2f3e9cf-d45a-4e1c-952e-ac506cc2a37b.jpg");

        //打开链接
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置请求方式为"GET"
        conn.setRequestMethod("GET");
        //超时响应时间为5秒
        conn.setConnectTimeout(5 * 1000);
        //通过输入流获取图片数据
        InputStream inStream = conn.getInputStream();
        //得到图片的二进制数据，以二进制封装得到数据，具有通用性
        byte[] data = AliyunOSSAPI.readInputStream(inStream);

        UUID uuid  = UUID.randomUUID();
        //new一个文件对象用来保存图片，默认保存当前工程根目录
        File systemUrl = new File("F://fileTest");
        systemUrl.mkdir();
        File imageFile = new File("F://fileTest//"+ uuid +".jpg");
        FileOutputStream outStream = new FileOutputStream(imageFile);
        outStream.write(data);
        outStream.close();

        InputStream is = new FileInputStream(imageFile);
        //写入数据
        String userId = "82";
        String md5key = AliyunOSSAPI.uploadObject2OSS(is,uuid +".jpg",AliyunOSSAPI.getOSSClient(AliyunOSSAPI.finWriteAliyunOSSVO()),AliyunOSSConstant.BACKET_NAME,AliyunOSSConstant.QMCS_U_identity+"/" + userId +"/");
        System.out.println(md5key);*/


    }




}
