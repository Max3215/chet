package com.qmcs.common.OSSupload;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * chenchao
 * 阿里云回调API
 */
public class aliUtil {


    private static final String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static final String accessId = "LTAIQby93fQjhScb";
    private static final String accessKey = "1Oe7xDeWY9JyI154dyanVHlufce0a7";
    private static final String bucket = "qmcsimg";
    private static final String host = "http://" + bucket + "." + endpoint;
    // 您的回调服务器地址
    private static final String callbackUrl = "http://j17430q253.imwork.net/qmcs-nw/nwsts/osscallBack";

    /**
     * 初始化 OSSClient
     *
     * @return
     */
    private static OSSClient init() {
        return new OSSClient(endpoint, accessId, accessKey);
    }

    /**
     * 得到秘钥用于文件上传
     * @param flag     (管理员目录flag=1,用户目录flag=2)
     * @param request
     * @param response
     * @throws Exception
     */
    public static void getKey(int flag, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String dir = "";    //上传目录；管理员资源目录为admin,用户目录为user
        OSSClient client = init();
        try {
            long expireTime = 30 * 100;//过期时间3000秒,部署项目后需要设为30秒
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            java.sql.Date expiration = new java.sql.Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);//最大文件1G
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = client.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = client.calculatePostSignature(postPolicy);

            //生成随机文件名
            String uuid = UUID.randomUUID().toString();

            //生成回调
            String callbackBody = "";
            String callbackBodyType = "application/json";
            String callback_param = "{" +
                    "                \"callbackUrl\":\"" + callbackUrl + "\"," +
                    "                    \"callbackBody\":\"{\\\"bucket\\\":${bucket},\\\"object\\\":${object},\\\"mimeType\\\":${mimeType},\\\"size\\\":${size}}\"," +
                    "                    \"callbackBodyType\":\"" + callbackBodyType + "\"" +
                    "            }";
            byte[] binaryDatas = callback_param.getBytes("utf-8");

            byte[] encodeBase64 = org.apache.commons.codec.binary.Base64.encodeBase64(binaryDatas);
            String callback = new String(encodeBase64);


            String strDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            if (flag == 1) {
                dir = "admin/" + strDate;
            } else {
                dir = "user/" + strDate;
            }
            Map<String, String> respMap = new LinkedHashMap<String, String>();
            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime));
            respMap.put("filename", uuid);
            respMap.put("callback", callback);
            net.sf.json.JSONObject ja1 = net.sf.json.JSONObject.fromObject(respMap);
            System.out.println(ja1.toString());
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST");
            response(request, response, ja1.toString());

        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException("秘钥生成失败!");
        } finally {
            client.shutdown();
        }
    }

    /**
     * 私有工具方法
     *
     * @param request
     * @param response
     * @param results
     * @throws IOException
     */
    private static void response(HttpServletRequest request, HttpServletResponse response, String results) throws IOException {
        String callbackFunName = request.getParameter("callback");
        if (callbackFunName == null || callbackFunName.equalsIgnoreCase(""))
            response.getWriter().println(results);
        else {
            response.getWriter().println(results);
            response.getWriter().println(callbackFunName + "( " + results + " )");
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.flushBuffer();
    }

    /**
     * 发送get请求
     *
     * @param url
     * @return
     */
    @SuppressWarnings({"finally"})
    public static String executeGet(String url) {
        BufferedReader in = null;

        String content = null;
        try {
            // 定义HttpClient
            @SuppressWarnings("resource")
            HttpClient client = new DefaultHttpClient();
            // 实例化HTTP方法
            HttpGet request = new HttpGet();
            request.setURI(new URI(url));
            HttpResponse response = client.execute(request);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            content = sb.toString();
        } catch (Exception e) {
        } finally {
            if (in != null) {
                try {
                    in.close();// 最后要关闭BufferedReader
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return content;
        }
    }

    /**
     * 验证回调是否是阿里发送的
     *
     * @param request
     * @param ossCallbackBody
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    public static boolean VerifyOSSCallbackRequest(HttpServletRequest request, String ossCallbackBody) throws NumberFormatException, IOException {
        boolean ret = false;
        String autorizationInput = new String(request.getHeader("Authorization"));
        String pubKeyInput = request.getHeader("x-oss-pub-key-url");
        byte[] authorization = BinaryUtil.fromBase64String(autorizationInput);
        byte[] pubKey = BinaryUtil.fromBase64String(pubKeyInput);
        String pubKeyAddr = new String(pubKey);
        if (!pubKeyAddr.startsWith("http://gosspublic.alicdn.com/") && !pubKeyAddr.startsWith("https://gosspublic.alicdn.com/")) {
            System.out.println("pub key addr must be oss addrss");
            return false;
        }
        String retString = executeGet(pubKeyAddr);
        retString = retString.replace("-----BEGIN PUBLIC KEY-----", "");
        retString = retString.replace("-----END PUBLIC KEY-----", "");
        String queryString = request.getQueryString();
        String uri = request.getRequestURI();
        String decodeUri = java.net.URLDecoder.decode(uri, "UTF-8");
        String authStr = decodeUri;
        if (queryString != null && !queryString.equals("")) {
            authStr += "?" + queryString;
        }
        authStr += "\n" + ossCallbackBody;
        ret = doCheck(authStr, authorization, retString);
        return ret;
    }

    /**
     * 解析阿里回调服务器的接口数据
     *
     * @param is
     * @param contentLen
     * @return
     */
    public static String GetPostBody(InputStream is, int contentLen) {
        if (contentLen > 0) {
            int readLen = 0;
            int readLengthThisTime = 0;
            byte[] message = new byte[contentLen];
            try {
                while (readLen != contentLen) {
                    readLengthThisTime = is.read(message, readLen, contentLen - readLen);
                    if (readLengthThisTime == -1) {// Should not happen.
                        break;
                    }
                    readLen += readLengthThisTime;
                }
                return new String(message);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("解析阿里数据出错!");
            }
        }
        return "";
    }


    public static boolean doCheck(String content, byte[] sign, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = BinaryUtil.fromBase64String(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            java.security.Signature signature = java.security.Signature.getInstance("MD5withRSA");
            signature.initVerify(pubKey);
            signature.update(content.getBytes());
            boolean bverify = signature.verify(sign);
            return bverify;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 返回给阿里云
     * @param request
     * @param response
     * @param results
     * @param status
     * @throws IOException
     */
    public static void response(HttpServletRequest request, HttpServletResponse response, String results, int status) throws IOException {
        String callbackFunName = request.getParameter("callback");
        response.addHeader("Content-Length", String.valueOf(results.length()));
        if (callbackFunName == null || callbackFunName.equalsIgnoreCase(""))
            response.getWriter().println(results);
        else
            response.getWriter().println(callbackFunName + "( " + results + " )");
        response.setStatus(status);
        response.flushBuffer();
    }

    /**
     * 根据key下载文件
     *
     * @param key
     * @param request
     * @param response
     * @return
     */
    public static HttpServletResponse download(String key, HttpServletRequest request, HttpServletResponse response) {
        //初始化OSSClient
        OSSClient client = init();
        // 获取Object，返回结果为OSSObject对象
        OSSObject object = client.getObject(bucket, key);

        // 获取Object Metadata
        ObjectMetadata metadata = object.getObjectMetadata();

        // 获取Object的输入流
        InputStream fis = object.getObjectContent();

        // 取得文件名。
        String fileName = key;

        try {
            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");//firefox浏览器
            } else {
                if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                    fileName = URLEncoder.encode(fileName, "UTF-8");//IE浏览器
                }
            }
            response.setContentType("text/plain");
            response.setHeader("Location", fileName);
            response.reset();
            response.setHeader("Cache-Control", "max-age=0");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            OutputStream fos = null;
            bis = new BufferedInputStream(fis);
            fos = response.getOutputStream();
            bos = new BufferedOutputStream(fos);
            int bytesRead = 0;
            byte[] buffer = new byte[5 * 1024];
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
            }
            bos.close();
            bis.close();
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.shutdown();
        }
        return response;
    }

    /**
     * 根据key在线播放资源
     *
     * @param key
     * @param request
     * @param response
     * @return
     */
    public static HttpServletResponse playOnline(String key, HttpServletRequest request, HttpServletResponse response) {
        //初始化 OSSClient
        OSSClient client = init();
        // 获取Object，返回结果为OSSObject对象
        OSSObject object = client.getObject(bucket, key);
        // 获取Object的输入流
        InputStream fis = object.getObjectContent();
        try {
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            OutputStream fos = null;
            bis = new BufferedInputStream(fis);
            fos = response.getOutputStream();
            bos = new BufferedOutputStream(fos);
            int bytesRead = 0;
            byte[] buffer = new byte[5 * 1024];
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
            }
            bos.close();
            bis.close();
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.shutdown();
        }
        return response;
    }

    /**
     * 批量删除文件
     *
     * @param keys
     */
    public static void del(List<String> keys) throws Exception {
        //初始化 OSSClient
        OSSClient client = init();
        try {
            System.out.println("\nDeleting all objects:");
            DeleteObjectsResult deleteObjectsResult = client.deleteObjects(
                    new DeleteObjectsRequest(bucket).withKeys(keys));
            List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
            for (String object : deletedObjects) {
                System.out.println("\t" + object);
            }
            System.out.println();

        } catch (OSSException oe) {
            throw new RuntimeException("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason." + "**Error Message: " + oe.getErrorCode() + "**Error Code:" + oe.getErrorCode() + "**Request ID:" + oe.getRequestId() + "**Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            throw new RuntimeException("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network. " + "**Error Message: " + ce.getMessage());
        } finally {
            client.shutdown();
        }
    }
}