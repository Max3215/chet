package com.qmcs.common.restful;

import com.qmcs.common.code.Code;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by zhoudu on 2017/5/19.
 */
public class Restful implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private int code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据
     */
    private Map<String,Object>  data;

    private Restful() {
    }

    private static Restful restful;

    /**
     *  封装消息
     * @param code
     * @param o
     * @return
     */
    public static Restful getRestful(final Code code, final Map<String,Object> o){
        if( null == restful){
            restful = new Restful();
        }
        restful.code = code.getCode();
        restful.msg = code.getMsg();
        restful.data = o;
        return restful;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
