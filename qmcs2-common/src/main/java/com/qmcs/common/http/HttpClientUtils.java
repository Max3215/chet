package com.qmcs.common.http;

import com.qmcs.common.util.CommonUtil;
import com.qmcs.common.util.JsonUtils;
import com.qmcs.common.util.PraseXmlUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
  * @ClassName(类名)      : HttpClientUtils
  * @Description(描述)    : 封装了一些采用HttpClient发送HTTP请求的方法
  * @author(作者)         : suyl
  *
 */
public class HttpClientUtils {
	
	private static Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

	/**
	 * 
	 * @Description(功能描述)    :  封装参数
	 * @author(作者)             ：  panjun
	 * @date (开发日期)          :  2015年2月26日 上午9:45:01 
	 * @param params ：
	 * @return  List<NameValuePair>
	 */
	private static List<NameValuePair> encapsulateParams(Map<String, Object> params) {
		List<NameValuePair> formParams = new ArrayList<NameValuePair>(); //创建参数队列
        for (Entry<String, Object> entry : params.entrySet()) {
			if (!CommonUtil.isEmpty(entry.getValue())) {
        		formParams.add(new BasicNameValuePair(entry.getKey(),(String)entry.getValue()));
        	}
		}
		return formParams;
	}
	
	/**
	 * @Description 发送HTTP_POST请求
	 * @see .该方法会自动关闭连接.释放资源
	 * @param url    请求地址
	 * @param params 参数
	 * @param decodeCharset 字符集
	 * @return 远程主机响应正文
	 */
	public static Map<String, Object> sendPostRequest(String url, Map<String, Object> params, String decodeCharset) {
		//创建HttpClientBuilder  
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        //HttpClient  
        CloseableHttpClient httpClient = httpClientBuilder.build();  
        HttpPost httpPost = new HttpPost(url); 
        
        Map<String, Object> remap = new HashMap<String, Object>();
		try {
			List<NameValuePair> formParams = encapsulateParams(params);
			UrlEncodedFormEntity formEntity = null;
			if(!CommonUtil.isEmpty(decodeCharset)){
			    formEntity = new UrlEncodedFormEntity(formParams,decodeCharset);
			}else{
			    formEntity = new UrlEncodedFormEntity(formParams);
			}
			httpPost.setEntity(formEntity);
			
			//执行请求  
			HttpResponse httpResponse = httpClient.execute(httpPost);
			//获取响应消息实体  
	        HttpEntity entity = httpResponse.getEntity();  
	        //响应状态  
	        System.out.println("HTTP_POST请求status:" + httpResponse.getStatusLine());
	        
	        remap = convertMap(entity,decodeCharset); 
	        
		} catch (ClientProtocolException e) {
			log.error("HTTP_GET请求:", e);
		} catch (IOException e) {
			log.error("HTTP_GET请求:", e);
		} finally {
			try {
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				log.error("HTTP_GET请求:", e);
			}
		}
        
    	return remap;
    
	}
	
	/**
	 * @Description 发送HTTP_POST请求post json数据
	 * @see .该方法会自动关闭连接.释放资源
	 * @param url    请求地址
	 * @param jsonStr json数据字符串
	 * @return 远程主机响应正文
	 */
	public static Map<String, Object> sendPostJsonRequest(String url, String jsonStr) {
		//创建HttpClientBuilder  
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        //HttpClient  
        CloseableHttpClient httpClient = httpClientBuilder.build();  
        HttpPost httpPost = new HttpPost(url); 
        
        Map<String, Object> remap = new HashMap<String, Object>();
		try {
			
			StringEntity stringEntity = new StringEntity(jsonStr,"UTF-8");
			
			stringEntity.setContentEncoding("UTF-8");
			
			stringEntity.setContentType("application/json");
			
			httpPost.setEntity(stringEntity);
			
			//执行请求  
			HttpResponse httpResponse = httpClient.execute(httpPost);
			//获取响应消息实体  
	        HttpEntity entity = httpResponse.getEntity();  
	        //响应状态  
	        System.out.println("HTTP_POST请求status:" + httpResponse.getStatusLine());
	        
	        remap = convertMap(entity,"UTF-8"); 
	        
		} catch (ClientProtocolException e) {
			log.error("HTTP_GET请求:", e);
		} catch (IOException e) {
			log.error("HTTP_GET请求:", e);
		} finally {
			try {
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				log.error("HTTP_GET请求:", e);
			}
		}
        
    	return remap;
    
	}

	/**
	 * 
	 * @Description(功能描述)    :  返回值转map
	 * @author(作者)             ：  panjun
	 * @date (开发日期)          :  2015年2月26日 上午9:45:49 
	 * @param entity :
	 * @return :
	 * @throws IOException  :
	 */
	private static Map<String, Object> convertMap(HttpEntity entity, String defaultCharset) throws IOException {
		Map<String, Object> map = null;
		//判断响应实体是否为空  
		if (entity != null) {  
		    String content = EntityUtils.toString(entity, defaultCharset);
			String ss = entity.getContentType().getValue();
			System.out.println(content);
			if(ss.equals("text/plain")){
				map = JsonUtils.jsonToMap(content);
			}else {
				map = PraseXmlUtils.parseXmlString(content);
			}
		}
		return map;
	}
	
	/**
	 * @Description 发送HTTP_GET请求
	 * @see .该方法会自动关闭连接.释放资源
	 * @param url    请求地址
	 * @param params    参数
	 * @param decodeCharset 解码字符集,解析响应数据时用之,其为null时默认采用UTF-8解码
	 * @return 远程主机响应正文
	 */
	public static Map<String, Object> sendGetRequest(String url, Map<String, Object> params, String decodeCharset) {
		
		//创建HttpClientBuilder  
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        //HttpClient  
        CloseableHttpClient httpClient = httpClientBuilder.build();  
        Map<String,Object> remap = null;
		try {
		    URIBuilder uriBuilder = new URIBuilder(url);
	        if(params != null){
	            for (Entry<String, Object> entry : params.entrySet()) {
	                if (!CommonUtil.isEmpty(entry.getValue())) {
	                    uriBuilder.addParameter(entry.getKey(),(String)entry.getValue());
	                }
	            }
	        }
		    HttpGet httpGet = new HttpGet(uriBuilder.toString()); 
			//执行get请求  
			HttpResponse httpResponse = httpClient.execute(httpGet);
			//获取响应消息实体  
	        HttpEntity entity = httpResponse.getEntity();  
	        //响应状态  
	        int statusCode = httpResponse.getStatusLine().getStatusCode();
	        if(statusCode == 200){
	            remap = convertMap(entity,decodeCharset); 
	        }
	        log.info("HTTP_GET-{}响应状态:{}",url,statusCode);
	        
		} catch (ClientProtocolException e) {
			log.error("HTTP_GET请求:", e);
		} catch (IOException e) {
			log.error("HTTP_GET请求:", e);
		} catch (URISyntaxException e) {
		    log.error("HTTP_GET请求:", e);
        } finally {
			try {
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				log.error("HTTP_GET请求:", e);
			}
		}
        
    	return remap;
    }
	
	/**
	 * @Description 发送HTTP_GET请求
	 * @see .该方法会自动关闭连接,.释放资源
	 * @param url    请求地址
	 * @return 远程主机响应正文
	 */
	public static Map<String, Object> sendGetRequest(String url) {
		return sendGetRequest(url, null, "utf-8");
	}
	
	/**
	 * @Description 发送HTTP_GET请求
	 * @see .该方法会自动关闭连接,.释放资源
	 * @param url    请求地址
	 * @param params    参数
	 * @return 远程主机响应正文
	 */
	public static Map<String, Object> sendGetRequest(String url, Map<String, Object> params) {
		return sendGetRequest(url, params, "utf-8");
	}
	
}
