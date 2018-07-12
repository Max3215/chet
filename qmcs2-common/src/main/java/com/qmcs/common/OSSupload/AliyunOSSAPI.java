package com.qmcs.common.OSSupload;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.qmcs.common.util.CommonUtil;
import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.UUID;


/**
 * Created by CC on 2017/6/12.
 * 阿里云OSS-API
 */
public class AliyunOSSAPI{
    //log日志
    private static Logger logger = Logger.getLogger(AliyunOSSAPI.class);


    /**
     * 使用STS临时授权获取阿里云OSS客户端对象
     * @return ossClient
     */
    public static OSSClient getOSSClient(AliyunOSSVO aliyunOSSVO){
        if(CommonUtil.isNotEmpty(aliyunOSSVO)) {
            return new OSSClient(aliyunOSSVO.getEndpoint(), aliyunOSSVO.getAccessKeyId(), aliyunOSSVO.getAccessKeySecret(), aliyunOSSVO.getSecurityToken());
        }else{
            return null;
        }
    }

    /**
     * 获取写临时权限
     * @return
     */
    public static AliyunOSSVO finWriteAliyunOSSVO(){
        //得到写操作的临时授权
        return AliyunOSSUtil.sampleSTS(null,AliyunOSSConstant.ROLEARN_WRITE,AliyunOSSConstant.DURATION_SECONDS_IMAGESLIST);

    }

    /**
     * 获取读临时权限
     * @return
     */
    public static AliyunOSSVO finReadonlyAliyunOSSVO(){
        //得到读操作的临时授权
        return AliyunOSSUtil.sampleSTS(null,AliyunOSSConstant.ROLEARN_READ,AliyunOSSConstant.DURATION_SECONDS_IMAGESLIST);

    }


    /**
     * 处理数据库存储的图片URL
     * @param fileUrl
     * @return
     */
    public static String handleFileUrl(String fileUrl){
        //得到读操作的临时授权
        AliyunOSSVO aliyunOSSVO = AliyunOSSUtil.sampleSTS(null,AliyunOSSConstant.ROLEARN_READ,AliyunOSSConstant.DURATION_SECONDS_IMAGESLIST);
        String fileUrls = "";
        if(CommonUtil.isNotEmpty(fileUrl)){
            if(fileUrl.indexOf("[") != -1) {
                int beginIndex = fileUrl.indexOf("[");
                int endIndex = fileUrl.indexOf("]");
                String headUrl = fileUrl.substring(0, fileUrl.indexOf("["));
                String str = fileUrl.substring(beginIndex + 1, endIndex);
                String[] fileName = str.split(",");
                for (int i = 0; i < fileName.length; i++) {
                    if (i != fileName.length - 1) {
                        fileUrls += getFileUrl(headUrl + fileName[i],aliyunOSSVO) + ",";
                    } else {
                        fileUrls += getFileUrl(headUrl + fileName[i],aliyunOSSVO);
                    }
                }
            }else{
                fileUrls = fileUrl;
            }
        }
        return fileUrls;
    }

    /**
     * 处理数据库存储的图片URL
     * @param fileUrl
     * @return
     */
    public static String aliyunHandleFileUrl(String fileUrl,AliyunOSSVO aliyunOSSVO){
        String fileUrls = "";
        if(CommonUtil.isNotEmpty(fileUrl)){
            if(fileUrl.indexOf("[") != -1) {
                int beginIndex = fileUrl.indexOf("[");
                int endIndex = fileUrl.indexOf("]");
                String headUrl = fileUrl.substring(0, fileUrl.indexOf("["));
                String str = fileUrl.substring(beginIndex + 1, endIndex);
                String[] fileName = str.split(",");
                for (int i = 0; i < fileName.length; i++) {
                    if (i != fileName.length - 1) {
                        fileUrls += getFileUrl(headUrl + fileName[i],aliyunOSSVO) + ",";
                    } else {
                        fileUrls += getFileUrl(headUrl + fileName[i],aliyunOSSVO);
                    }
                }
            }else{

                fileUrls = fileUrl;
            }
        }
        return fileUrls;
    }




    /**
     * 获得url链接
     * @param key
     * @return
     */
    public static String getFileUrl(String key,AliyunOSSVO aliyunOSSVO) {
        //初始化OSSClient
        OSSClient ossClient= AliyunOSSAPI.getOSSClient(aliyunOSSVO);
        if(CommonUtil.isNotEmpty(ossClient)) {
            //Date expiration = new Date(new Date().getTime() + 3600 * 1000 * 24 * 365 * 20);
            //URL过期时间为1个小时
            Date expiration = new Date(new Date().getTime() + 3600 * 1000);
            GeneratePresignedUrlRequest generatePresignedUrlRequest =
                    new GeneratePresignedUrlRequest(AliyunOSSConstant.BACKET_NAME, key);
            generatePresignedUrlRequest.setExpiration(expiration);
            // 生成URL
            URL url = ossClient.generatePresignedUrl(generatePresignedUrlRequest);
            // 销毁
            ossClient.shutdown();
            if (url != null) {
                return url.toString();
            }
        }else{
            return null;
        }
        return null;
    }


    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static String getContentType(String fileName){
        //文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if(".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if(".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if(".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)  || ".png".equalsIgnoreCase(fileExtension) ) {
            return "image/jpeg";
        }
        if(".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if(".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if(".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if(".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if(".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if(".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        //默认返回类型
        return "image/jpeg";
    }

    /**
     * 上传图片至OSS
     * @param ossClient  oss连接
     * @param file 上传文件（文件全路径如：D:\\image\\cake.jpg）
     * @param bucketName  存储空间
     * @param folder 模拟文件夹名 如"qj_nanjing/"
     * @return String 返回的唯一MD5数字签名
     */
    public static String uploadObject2OSS(InputStream isk,String fileName,OSSClient ossClient, String bucketName, String folder) {
        String resultStr = null;
        try {
            //以输入流的形式上传文件
            //InputStream is = new FileInputStream(file);
            InputStream is = isk;
            UUID uuid  = UUID.randomUUID();
            //文件名
            //String fileName = uuid + file.getName().substring(file.getName().indexOf("."),file.getName().length());
            //文件大小
            //Long fileSize = file.length();
            //创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            //上传的文件的长度
            metadata.setContentLength(is.available());
            //指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            //指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            //指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            //如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            //metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            //上传文件   (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(bucketName, folder + fileName, is, metadata);
            //解析结果
            resultStr = putResult.getETag();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return resultStr;
    }


    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }
}
