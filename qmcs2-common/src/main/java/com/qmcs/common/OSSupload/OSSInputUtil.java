package com.qmcs.common.OSSupload;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.qmcs.common.util.CommonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by CC on 2017/8/11.
 * 导数据用到
 */
public class OSSInputUtil {

    /**
     * 数据导入至阿里云
     * @param windosUrl 转移地址
     * @param catalog 存储端
     * @param id 对象ID
     * @param fileUrl 图片URL
     * @param ossClient OSS存储对象
     * @throws Exception
     */
    public String InputOSS(String windosUrl,String server,String catalog,String id,String fileUrl,OSSClient ossClient) throws Exception{
        UUID uuid = UUID.randomUUID();
        if(server.equals("200")){
            catalog = AliyunOSSConstant.TOP_QMCS200 + catalog;
        }
        if(server.equals("244")){
            catalog = AliyunOSSConstant.TOP_QMCS244 + catalog;
        }
        if(server.equals("qmcs")){
            catalog = AliyunOSSConstant.TOP_QMCS + catalog;
        }
        if(CommonUtil.isNotEmpty(catalog) && CommonUtil.isNotEmpty(id) && CommonUtil.isNotEmpty(fileUrl) && fileUrl.indexOf("http") != -1) {
            String fileUrlObject = fileUrl;
            if (fileUrl.indexOf("s:") != -1) {
                String[] ful1 = fileUrl.split(":");
                String ful2 = ful1[0].substring(0, ful1[0].indexOf("s"));
                fileUrlObject = ful2 + ":" + ful1[1];
            }
            URL url = new URL(fileUrlObject);
            //打开链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置请求方式为"GET"
            conn.setRequestMethod("GET");
            //超时响应时间为5秒
            conn.setConnectTimeout(5 * 1000);
            //通过输入流获取图片数据
            if(conn.getResponseCode() != 200){
                return "";
            }
            InputStream inStream = conn.getInputStream();
            //得到图片的二进制数据，以二进制封装得到数据，具有通用性
            byte[] data = AliyunOSSAPI.readInputStream(inStream);
            //new一个文件对象用来保存图片，默认保存当前工程根目录
            File systemUrl = new File(windosUrl);
            systemUrl.mkdir();
            File imageFile = new File(windosUrl + "/" + uuid + ".jpg");
            FileOutputStream outStream = new FileOutputStream(imageFile);
            outStream.write(data);
            outStream.close();
            InputStream is = new FileInputStream(imageFile);
            //写入数据
            //AliyunOSSAPI.uploadObject2OSS(is, uuid + ".jpg",ossClient, AliyunOSSConstant.BACKET_NAME, catalog + "/" + id + "/");
            //delFolder("D://fileTest");
        }
        return catalog + "/" + id + "/[" + String.valueOf(uuid) +".jpg]";
    }



    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 根据key删除文件
     * @param key
     * @return
     */
    public static int findFileObject(String key){
        int count = 0;
        boolean flge = true;
        while (flge == true) {
            //写操作
            AliyunOSSVO aliyunOSSVOWrite = AliyunOSSUtil.sampleSTS(null,AliyunOSSConstant.ROLEARN_WRITE,AliyunOSSConstant.DURATION_SECONDS_UPLOAD);
            OSSClient ossclientWrite = AliyunOSSAPI.getOSSClient(aliyunOSSVOWrite);
            //读操作
            AliyunOSSVO aliyunOSSVORead = AliyunOSSUtil.sampleSTS(null,AliyunOSSConstant.ROLEARN_READ,AliyunOSSConstant.DURATION_SECONDS_IMAGESLIST);
            //初始化OSSClient
            OSSClient ossClientReadv = AliyunOSSAPI.getOSSClient(aliyunOSSVORead);
            // 列举Object
            ObjectListing listing = ossClientReadv.listObjects(aliyunOSSVORead.getBucketName(),key);
            List<String> listKey = new ArrayList<>();
            // 遍历所有Object
            for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
                System.out.println(objectSummary.getKey());
                listKey.add(objectSummary.getKey());
                count ++;
            }
           if (CommonUtil.isNotEmpty(listKey)) {
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
            }
        }
        return count;
    }

    /**
     * 根据key查找所有文件
     * @param key
     * @return
     */
    public static List<String> findsKeyObject(String key){
        boolean flge = true;
        List<String> listKey = new ArrayList<>();
        //写操作
        //AliyunOSSVO aliyunOSSVOWrite = AliyunOSSUtil.sampleSTS(null,AliyunOSSConstant.ROLEARN_WRITE,AliyunOSSConstant.DURATION_SECONDS_UPLOAD);
        //OSSClient ossclientWrite = AliyunOSSAPI.getOSSClient(aliyunOSSVOWrite);
        //读操作
        AliyunOSSVO aliyunOSSVORead = AliyunOSSUtil.sampleSTS(null,AliyunOSSConstant.ROLEARN_READ,AliyunOSSConstant.DURATION_SECONDS_IMAGESLIST);
        //初始化OSSClient
        OSSClient ossClientReadv = AliyunOSSAPI.getOSSClient(aliyunOSSVORead);
        // 列举Object
        ObjectListing listing = ossClientReadv.listObjects(aliyunOSSVORead.getBucketName(),key);
        // 遍历所有Object
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            System.out.println(objectSummary.getKey());
            listKey.add(objectSummary.getKey());
        }
        return listKey;
    }

    public static void main(String[] args)throws Exception{
        //OSSInputUtil.findFileObject("top-qmcs/qmcs-nw/identity");
        /*for (int i = 0; i < 10; i++) {
            //new一个文件对象用来保存图片，默认保存当前工程根目录
            String windosUrl = "F://fileTest//" + String.valueOf(i);
            File systemUrl = new File(windosUrl);
            systemUrl.mkdirs();
            //申请STS临时授权创建存储对象
            OSSClient ossClient = AliyunOSSAPI.getOSSClient(AliyunOSSAPI.finWriteAliyunOSSVO());
            OSSInputUtil o = new OSSInputUtil();
            //执行上传
            String fileUrl = o.InputOSS(windosUrl, "qmcs", AliyunOSSConstant.QMCS_U_identity, "120", "https://img.qmcs-china.com/pic/200/2017/04/19/1d1f9d03-cfed-4c2e-8fa6-91106fe18aa3.jpg", ossClient);
            System.out.println(fileUrl);
        }*/
        /*OSSInputUtil ossInputUtil = new OSSInputUtil();
        List<StaffIdentity> sList = ossInputUtil.finStaffIdentity();
        for(StaffIdentity s: sList){
            System.out.println(s.getIdentityId());
        }*/


    }


}
