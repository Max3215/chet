package com.qmcs.common.OSSupload;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.qmcs.common.util.callback.CallbackUtil;
import org.apache.log4j.Logger;

/**
 * Created by CC on 2017/6/12.
 * chenchao
 * 阿里云OSS-STS临时授权的静态方法
 */
public class AliyunOSSUtil {

    //log日志
    private static Logger logger = Logger.getLogger(AliyunOSSUtil.class);
    // 目前只有"cn-hangzhou"这个region可用, 不要使用填写其他region的值
    public static final String REGION_CN_HANGZHOU = "cn-hangzhou";
    // 当前 STS API 版本
    public static final String STS_API_VERSION = "2015-04-01";

    static AssumeRoleResponse assumeRole(String accessKeyId, String accessKeySecret,
                                         String roleArn, String roleSessionName, String policy,
                                         ProtocolType protocolType, long durationSeconds) throws ClientException {
        try {
            // 创建一个 Aliyun Acs Client, 用于发起 OpenAPI 请求
            IClientProfile profile = DefaultProfile.getProfile(REGION_CN_HANGZHOU, accessKeyId, accessKeySecret);
            DefaultAcsClient client = new DefaultAcsClient(profile);
            // 创建一个 AssumeRoleRequest 并设置请求参数
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setVersion(STS_API_VERSION);
            request.setMethod(MethodType.POST);
            request.setProtocol(protocolType);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
            request.setDurationSeconds(durationSeconds);
            request.setPolicy(policy);
            // 发起请求，并得到response
            final AssumeRoleResponse response = client.getAcsResponse(request);
            return response;
        } catch (ClientException e) {
            throw e;
        }
    }

    /**
     * 获取STS方法
     * @param Jurisdiction 读写操作
     * @param durationSeconds STS过期时间
     * @param saveDirectory 拼接的存储目录
     * @return
     */
    public static AliyunOSSVO sampleSTS(String saveDirectory,String Jurisdiction,long durationSeconds){
        AliyunOSSVO aliyunOSSVO = null;
        String roleSessionName = "alice-001";
        // 如何定制你的policy?
        String policy = null;
        // 此处必须为 HTTPS
        ProtocolType protocolType = ProtocolType.HTTPS;
        try {
            final AssumeRoleResponse response = assumeRole(AliyunOSSConstant.STS_ACCESS_KEY_ID, AliyunOSSConstant.STS_ACCESS_KEY_SECRET,
                    Jurisdiction, roleSessionName, policy, protocolType,durationSeconds);
            /*SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:ss:mm\'Z\'");
            Date Expirations = null;
            try {
                Expirations = sf.parse(response.getCredentials().getExpiration());
            }catch (Exception e){
                e.printStackTrace();
            }
            SimpleDateFormat normalFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String ExpirationDate = normalFormatter.format(Expirations);*/
            logger.info("Expiration: " + response.getCredentials().getExpiration());
            logger.info("Access Key Id: " + response.getCredentials().getAccessKeyId());
            logger.info("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
            logger.info("Security Token: " + response.getCredentials().getSecurityToken());
            aliyunOSSVO = new AliyunOSSVO();
            aliyunOSSVO.setAccessKeyId(response.getCredentials().getAccessKeyId());
            aliyunOSSVO.setAccessKeySecret(response.getCredentials().getAccessKeySecret());
            aliyunOSSVO.setSecurityToken(response.getCredentials().getSecurityToken());
            aliyunOSSVO.setExpiration(response.getCredentials().getExpiration());
            aliyunOSSVO.setEndpoint(AliyunOSSConstant.STS_ENDPOINT);
            if(String.valueOf(CallbackUtil.getProperties("oss.qmcs.server")).equals("200")){
                saveDirectory = AliyunOSSConstant.TOP_QMCS200 + saveDirectory;
            }
            if(String.valueOf(CallbackUtil.getProperties("oss.qmcs.server")).equals("244")){
                saveDirectory = AliyunOSSConstant.TOP_QMCS244 + saveDirectory;
            }
            if(String.valueOf(CallbackUtil.getProperties("oss.qmcs.server")).equals("qmcs")){
                saveDirectory = AliyunOSSConstant.TOP_QMCS + saveDirectory;
            }
            aliyunOSSVO.setSaveDirectory(saveDirectory);
            aliyunOSSVO.setBucketName(AliyunOSSConstant.BACKET_NAME);
            aliyunOSSVO.setCallbackBody(AliyunOSSConstant.CALLBACKBODY);
        } catch (ClientException e) {
            logger.info(e);
            logger.info("Failed to get a token.");
            logger.info("Error code: " + e.getErrCode());
            logger.info("Error message: " + e.getErrMsg());
        }
        return aliyunOSSVO;
    }



}
