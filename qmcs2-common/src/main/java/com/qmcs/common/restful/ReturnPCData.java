package com.qmcs.common.restful;

import com.qmcs.common.code.Code;

/**
 * 
  * @ClassName(类名)      : ReturnData
  * @Description(描述)    : 信息返回
  * @author(作者)         ：suyuanliu
 */
public class ReturnPCData<T> {
	private String msg;
	private int code;
	private T data;

	public ReturnPCData() {
	}

	public ReturnPCData(Code code) {
		this.msg = code.getMsg();
		this.code = code.getCode();
	}

	public ReturnPCData(int code,String msg) {
		this.msg = msg;
		this.code = code;
	}
	public ReturnPCData(Code code, T data) {
		this.msg = code.getMsg();
		this.code = code.getCode();
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
